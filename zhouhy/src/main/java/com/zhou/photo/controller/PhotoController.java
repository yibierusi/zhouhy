package com.zhou.photo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import com.zhou.index.util.EnumUtil;
import com.zhou.index.util.FileUtil;
import com.zhou.index.util.MsgEnumUtil;
import com.zhou.photo.entity.Photo;
import com.zhou.photo.entity.PhotoAlbum;
import com.zhou.photo.service.PhotoAlbumService;
import com.zhou.photo.service.PhotoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 19:56
 **/
@Controller
@RequestMapping("photoAlbum")
public class PhotoController {
    @Autowired
    private PhotoAlbumService photoAlbumService;
    @Autowired
    private PhotoService photoService;
    /*
     * @作者：zhouhy
     * @描述：跳转相册列表
     * @时间：2018/1/5  10:31
     */
    @RequestMapping(value = "/photoListAlbumView")
    public ModelAndView gotoPhotoListAlbumView(){
        ModelAndView mav = new ModelAndView("/photo/photoAlbumList");
        return mav;
    }
    /*
    * @作者：zhouhy
    * @描述：跳转图片列表
    * @时间：2018/1/5  10:31
    */
    @RequestMapping(value = "/photoListView/{photoAlbumId}")
    public ModelAndView gotoPhotoListView(@PathVariable String photoAlbumId){
        ModelAndView mav = new ModelAndView("/photo/photoList");
        mav.addObject("photoAlbumId",photoAlbumId);
        return mav;
    }
    /*
     * @作者：zhouhy
     * @描述：跳转上传页面
     * @时间：2018/1/5  10:32
     */
    @RequestMapping(value = "/uploadPhotoView/{photoAlbumId}")
    public ModelAndView gotoUploadPhoto(@PathVariable String photoAlbumId){
        ModelAndView mav = new ModelAndView("/photo/uploadPhoto");
        mav.addObject("photoAlbumId",photoAlbumId);
        return mav;
    }
    /*
     * @作者：zhouhy
     * @描述：跳转创建相册视图
     * @时间：2018/1/5  10:32
     */
    @RequestMapping(value = "/createPhotoAlbumView")
    public ModelAndView gotoCreatePhotoAlbum(){
        ModelAndView mav = new ModelAndView("/photo/createPhotoAlbum");
        return mav;
    }
    /*
     * @作者：zhouhy
     * @描述：创建相册
     * @时间：2018/1/5  10:32
     */
    @ResponseBody
    @RequestMapping(value = "/createPhotoAlbum")
    public String createPhotoAlbum(PhotoAlbum photoAlbum, HttpServletRequest req){
        Result result = new Result();
        SysUser su=(SysUser)req.getSession().getAttribute("sysUser");
        photoAlbum.setSysUserId(su.getId());
        try {
            photoAlbumService.insert(photoAlbum);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(MsgEnumUtil.ERROR.code());
            result.setMsg(MsgEnumUtil.ERROR.msg());
            return JSON.toJSONString(result);
        }
        result.setCode(MsgEnumUtil.SUCCESS.code());
        result.setMsg(MsgEnumUtil.SUCCESS.msg());
        return JSON.toJSONString(result);
    }
    /*
         * @作者：zhouhy
         * @描述：获取自己的相册列表
         * @时间：2018/1/5  10:32
         */
    @ResponseBody
    @RequestMapping(value = "/getMyselfPhotoAlbumList")
    public String getMyselfPhotoAlbumList(PhotoAlbum photoAlbum,HttpServletRequest req){
        Result result = new Result();
        SysUser su=(SysUser)req.getSession().getAttribute("sysUser");

        EntityWrapper<PhotoAlbum> ew = new EntityWrapper<>();
        ew.where("del_flag={0}","0");
        ew.and("sys_user_id={0}",su.getId());
        List<PhotoAlbum> obj = photoAlbumService.selectList(ew);

        if(obj==null||obj.size()<1){
            result.setCode(MsgEnumUtil.NO_ALBUMS_CREATED.code());
            result.setMsg(MsgEnumUtil.NO_ALBUMS_CREATED.msg());
        }else{
            result.setCode(MsgEnumUtil.SUCCESS.code());
            result.setMsg(MsgEnumUtil.SUCCESS.msg());
            result.setObj(obj);
        }
        return JSON.toJSONString(result);
    }

    /*
        * @作者：zhouhy
        * @描述：获取自己的相册列表
        * @时间：2018/1/5  10:32
        */
    @ResponseBody
    @RequestMapping(value = "/getMyselfPhotoList/{photoAlbumId}")
    public String getMyselfPhotoList(@PathVariable String photoAlbumId, HttpServletRequest req){
        Result result = new Result();
        SysUser su=(SysUser)req.getSession().getAttribute("sysUser");
        EntityWrapper<PhotoAlbum> ew = new EntityWrapper<>();
        ew.where("del_flag={0}","0");
        ew.and("photo_album_id={0}",photoAlbumId);
        List<PhotoAlbum> obj = photoAlbumService.selectList(ew);

        if(obj==null||obj.size()<1){
            result.setCode(MsgEnumUtil.NO_PHOTO_TO_UPLOAD.code());
            result.setMsg(MsgEnumUtil.NO_PHOTO_TO_UPLOAD.msg());
        }else{
            result.setCode(MsgEnumUtil.SUCCESS.code());
            result.setMsg(MsgEnumUtil.SUCCESS.msg());
            result.setObj(obj);
        }
        return JSON.toJSONString(result);
    }


    /*
     * @作者：zhouhy
     * @描述：上传图片
     * @时间：2018/1/5  10:33
     */
    @ResponseBody
    @RequestMapping(value = "/uploadPhoto/{photoAlbumId}")
    public String uploadPhoto(@PathVariable String photoAlbumId,HttpServletRequest req){
        SysUser su=(SysUser)req.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();

        MultipartFile mf = null;
        File mff = null;
        if (!(req instanceof MultipartHttpServletRequest)) {
            String errorMsg = "your post form is not support ENCTYPE='multipart/form-data' ";
            throw new RuntimeException(errorMsg);
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        List<MultipartFile> multipartFiles = multipartRequest.getFiles("file_data");
        if (null != multipartFiles && multipartFiles.size() > 0) {
            mf = multipartFiles.get(0);

            String fileName = mf.getOriginalFilename();
            String suffix = FileUtil.getFileSuffix(fileName);
            String tempPath = su.getUsername()+"/"+photoAlbumId+"/"+ctmLong+"."+ suffix;
            String realPath = EnumUtil.PHOTOT_PATH.text()+tempPath;
            String classPath = EnumUtil.PHOTO_CLASS_PATH.text()+tempPath;
            File source = FileUtil.mkdirParentFile(realPath);
            File source1 = FileUtil.mkdirParentFile(classPath);
            String url = "/upload/photo/"+tempPath;
            try {
                FileUtils.copyInputStreamToFile(mf.getInputStream(), source);
                FileUtils.copyInputStreamToFile(mf.getInputStream(), source1);
                Photo photo = new Photo();
                photo.setPhotoAlbumId(photoAlbumId);
                photo.setName(FileUtil.removeFileSuffix(fileName));
                photo.setPath(url);
                //photo.setSize1(mf.getSize());
                photo.setSuffix(suffix);
                photoService.insert(photo);

            } catch (Exception e) {
                String errorMsg = "Upload file " + source.getAbsoluteFile() + " Error!" + e.getMessage();
                //log.error(errorMsg);
                throw new RuntimeException(errorMsg);

            }
        }
        return "";
    }
    /*
    * @作者：zhouhy
    * @描述：删除图片
    * @时间：2018/1/5  10:33
    */
    @ResponseBody
    @RequestMapping(value = "/deletePhoto/{photoId}")
    public String deletePhoto(@PathVariable String photoId,HttpServletRequest req){
        Result result = new Result();

        Photo photo = photoService.selectById(photoId);
        photo.setId(photoId);
        photo.setDelFlag(EnumUtil.DELETED.value());
        photo.setUpdateTime(new Date());

        photoService.updateById(photo);

        result.setCode(MsgEnumUtil.SUCCESS.code());
        result.setMsg(MsgEnumUtil.SUCCESS.msg());
        return JSON.toJSONString(result);
    }


}
