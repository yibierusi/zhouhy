package com.zhou.photo.controller;

import com.alibaba.fastjson.JSON;
import com.zhou.index.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 19:56
 **/
@Controller
@RequestMapping("photo")
public class PhotoController {

    @RequestMapping(value = "/photoList")
    public ModelAndView photoList(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("/photo/photoList");
        return mav;
    }

    @RequestMapping(value = "/uploadPhoto")
    public ModelAndView gotoUploadPhoto(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("/photo/uploadPhoto");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value = "/uploadPhoto1")
    public String uploadPhoto(HttpServletRequest req){
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
            String realPath = "D:/"+mf.getOriginalFilename();
            File source = new File(realPath);
            try {
                mf.transferTo(source);
                mff = source;
                //log.debug("Upload file " + source.getAbsoluteFile() + " Success!");
            } catch (Exception e) {
                String errorMsg = "Upload file " + source.getAbsoluteFile() + " Error!" + e.getMessage();
                //log.error(errorMsg);
                throw new RuntimeException(errorMsg);

            }
        }
        return "";
    }


}
