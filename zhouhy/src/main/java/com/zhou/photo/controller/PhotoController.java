package com.zhou.photo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import com.zhou.index.util.EnumUtil;
import com.zhou.index.util.FileUtil;
import com.zhou.index.util.MsgEnumUtil;
import com.zhou.index.util.UUIDUtil;
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
 * @Author: zhouhy
 * @Description:
 * @Date: 17:16 2018/8/23
 */
@Controller
@RequestMapping("photo")
public class PhotoController {
    @Autowired
    private PhotoAlbumService photoAlbumService;
    @Autowired
    private PhotoService photoService;

    /**
     * @Author: zhouhy
     * @Description: 跳转相册列表
     * @Date: 17:16 2018/8/23
     */
    @RequestMapping(value = "/photoAlbum")
    public ModelAndView gotoPhotoListAlbumView() {
        ModelAndView mav = new ModelAndView("/photo/photo_album_list");
        return mav;
    }

    /**
     * @Author: zhouhy
     * @Description: 跳转图片列表
     * @Date: 17:17 2018/8/23
     */
    @RequestMapping(value = "/photoListView/{photoAlbumId}")
    public ModelAndView gotoPhotoListView(@PathVariable String photoAlbumId) {
        ModelAndView mav = new ModelAndView("/photo/photo_list");
        mav.addObject("photoAlbumId", photoAlbumId);
        return mav;
    }

    /**
     * @Author: zhouhy
     * @Description: 跳转上传页面
     * @Date: 17:17 2018/8/23
     */
    @RequestMapping(value = "/uploadPhotoView/{photoAlbumId}")
    public ModelAndView gotoUploadPhoto(@PathVariable String photoAlbumId) {
        ModelAndView mav = new ModelAndView("/photo/upload_photo");
        mav.addObject("photoAlbumId", photoAlbumId);
        return mav;
    }

    /**
     *  @Author: zhouhy
     *  @Description: 跳转创建相册视图
     *  @Date: 17:17 2018/8/23
     */
    @RequestMapping(value = "/newPhotoAlbum")
    public ModelAndView gotoCreatePhotoAlbum() {
        ModelAndView mav = new ModelAndView("/photo/new_photo_album");
        return mav;
    }

    /**
     *  @Author: zhouhy
     *  @Description: 创建相册
     *  @Date: 17:18 2018/8/23
     */
    @ResponseBody
    @RequestMapping(value = "/addPhotoAlbum")
    public Result addPhotoAlbum(PhotoAlbum photoAlbum, HttpServletRequest req) {
        SysUser su = (SysUser) req.getSession().getAttribute("sysUser");
        photoAlbum.setSysUserId(su.getId());
        photoAlbum.setId(UUIDUtil.getUUID());
        try {
            photoAlbumService.insert(photoAlbum);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.create(MsgEnumUtil.STATEMENT_EXE_FAILED);
        }
        return Result.ok();
    }

    /**
     *  @Author: zhouhy
     *  @Description: 获取自己的相册列表
     *  @Date: 17:20 2018/8/23
     */
    @ResponseBody
    @RequestMapping(value = "/getMyselfPhotoAlbumList")
    public Result getMyselfPhotoAlbumList(HttpServletRequest req) {
        Result result;
        SysUser su = (SysUser) req.getSession().getAttribute("sysUser");

        EntityWrapper<PhotoAlbum> ew = new EntityWrapper<>();
        ew.where("del_flag={0}", "0");
        ew.and("sys_user_id={0}", su.getId());
        List<PhotoAlbum> photoAlbums = photoAlbumService.selectList(ew);

        if (photoAlbums == null || photoAlbums.size() == 0) {
            result = Result.create(MsgEnumUtil.NO_ALBUMS_CREATED);
        } else {
            result = Result.ok();
            result.put("photoAlbums", photoAlbums);
        }
        return result;
    }

    /**
     *  @Author: zhouhy
     *  @Description: 获取自己的相册列表
     *  @Date: 17:20 2018/8/23
     */
    @ResponseBody
    @RequestMapping(value = "/getMyselfPhotoList/{photoAlbumId}")
    public Result getMyselfPhotoList(@PathVariable String photoAlbumId, HttpServletRequest req) {
        Result result = new Result();
        SysUser su = (SysUser) req.getSession().getAttribute("sysUser");
        EntityWrapper<Photo> ew = new EntityWrapper<>();
        ew.where("del_flag={0}", "0");
        ew.and("photo_album_id={0}", photoAlbumId);
        List<Photo> photos = photoService.selectList(ew);

        if (photos == null || photos.size() == 0) {
            result = Result.create(MsgEnumUtil.NO_PHOTO_TO_UPLOAD);
        } else {
            result = Result.ok();
            result.put("photos", photos);
        }
        return result;
    }


    /**
     *  @Author: zhouhy
     *  @Description: 上传图片
     *  @Date: 17:20 2018/8/23
     */
    @ResponseBody
    @RequestMapping(value = "/uploadPhoto/{photoAlbumId}")
    public Result uploadPhoto(@PathVariable String photoAlbumId, HttpServletRequest req) {
        SysUser su = (SysUser) req.getSession().getAttribute("sysUser");
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
            String tempPath = su.getUsername() + "/" + photoAlbumId + "/" + ctmLong + "." + suffix;
            String realPath = EnumUtil.PHOTOT_PATH.text() + tempPath;
            String classPath = EnumUtil.PHOTO_CLASS_PATH.text() + tempPath;
            File source = FileUtil.mkdirParentFile(realPath);
            File source1 = FileUtil.mkdirParentFile(classPath);
            String url = "/upload/photo/" + tempPath;
            try {
                FileUtils.copyInputStreamToFile(mf.getInputStream(), source);
                FileUtils.copyInputStreamToFile(mf.getInputStream(), source1);
                Photo photo = new Photo();
                photo.setPhotoAlbumId(photoAlbumId);
                photo.setName(FileUtil.removeFileSuffix(fileName));
                photo.setPath(url);
                //photo.setSize1(mf.getSize());
                photo.setSuffix(suffix);
                photo.setId(UUIDUtil.getUUID());
                photoService.insert(photo);

            } catch (Exception e) {
                String errorMsg = "Upload file " + source.getAbsoluteFile() + " Error!" + e.getMessage();
                //log.error(errorMsg);
                throw new RuntimeException(errorMsg);

            }
        }
        return Result.ok();
    }

    /**
     *  @Author: zhouhy
     *  @Description: 删除图片
     *  @Date: 17:22 2018/8/23
     */
    @ResponseBody
    @RequestMapping(value = "/deletePhoto/{photoId}")
    public Result deletePhoto(@PathVariable String photoId, HttpServletRequest req) {
        Photo photo = photoService.selectById(photoId);
        photo.setId(photoId);
        photo.setDelFlag(EnumUtil.DELETED.value());
        photo.setUpdateTime(new Date());

        photoService.updateById(photo);
        return Result.ok();
    }


}
