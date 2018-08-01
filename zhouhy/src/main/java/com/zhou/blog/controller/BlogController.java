package com.zhou.blog.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.blog.entity.Blog;
import com.zhou.blog.service.BlogService;
import com.zhou.index.entity.SysUser;
import com.zhou.index.util.DateUtil;
import com.zhou.index.util.EnumUtil;
import com.zhou.index.util.FileUtil;
import com.zhou.index.util.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-10 18:01
 **/
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    //编辑
    @RequestMapping(value = "/edit")
    public ModelAndView edit(String id) {
        ModelAndView mav = new ModelAndView("/blog/edit");
        mav.addObject("id", id);
        return mav;
    }

    //查看
    @RequestMapping(value = "/query")
    public ModelAndView query(String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/blog/query");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.where("id={0}", id);
        ew.and("sys_user_id", su.getId());
        Blog blog = blogService.selectOne(ew);

        if (!(blog == null || blog.getId() == null || "".equals(blog.getId()))) {
            mav.addObject("id", id);
        }
        return mav;
    }

    //删除
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(String id, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.where("id={0}", id);
        ew.and("sys_user_id", su.getId());
        Blog blog = blogService.selectOne(ew);

        String filePath = EnumUtil.BLOG_PATH.text() + su.getUsername() + "/md/";
        String fileName = blog.getContent();
        boolean fileDelFlag = FileUtil.fileRename(filePath + fileName,
                DateUtil.dateToString(new Date(), EnumUtil.DATE_FULL_FORMAT.text()) + "_" + fileName);

        boolean flag = blogService.delete(ew);
        //todo 由之前的int  变为 boolean  前段为修改
        return "" + flag;
    }

    //列表
    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/blog/list");
        return mav;
    }

    //发表
    @RequestMapping(value = "/publish")
    @ResponseBody
    public String publish(Blog b, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        FileUtil.fileOutputStreamFunc(EnumUtil.BLOG_PATH.text() + su.getUsername() + "/md/" + ctmLong + ".md", b.getContent());

        b.setId(UUIDUtil.getUUID());
        b.setSysUserId(su.getId());
        b.setCreateTime(new Date());
        b.setUpdateTime(new Date());
        b.setContent(ctmLong + ".md");
        blogService.insert(b);
        return b.getId();
    }

    //修改博客
    @RequestMapping(value = "/modify")
    @ResponseBody
    public String modify(Blog b, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.where("id={0}", b.getId());
        ew.and("aithor_id={0}", su.getId());
        Blog blog = blogService.selectOne(ew);

        if (!(blog == null || blog.getId() == null || blog.getId().equals(""))) {
            FileUtil.fileOutputStreamFunc(EnumUtil.BLOG_PATH.text() + su.getUsername() + "/md/" + blog.getContent(), b.getContent());

            blog.setUpdateTime(new Date());
            blog.setContent(b.getContent());
            blog.setTitle(b.getTitle());
            blogService.updateById(blog);
        }
        return b.getId();
    }

    //增加阅读量
    @RequestMapping(value = "/modifyBlogReadCountById")
    @ResponseBody
    public String modifyBlogReadCountById(String id) {
        Blog blog = blogService.selectById(id);
        blog.setReads(blog.getReads() + 1);
        boolean flag = blogService.updateById(blog);
        if (flag) {
            System.out.println("阅读量+1");
        } else
            System.out.println("阅读量增加失败");
        return "";
    }

    //获取列表
    @RequestMapping(value = "/getList")
    @ResponseBody
    public String getList(HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.and("a.sys_user_id={0}", su.getId());
        ew.and("a.del_flag={0}", EnumUtil.NOT_DELETE);
        ew.orderBy("a.create_time", false);
        List<Blog> blogList = blogService.selectBlog(ew);

        return JSON.toJSONString(blogList);
    }

    //获取博客信息
    @RequestMapping(value = "/getContent")
    @ResponseBody
    public String getContent(String id, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        Blog blog = blogService.selectById(id);
        String str = FileUtil.fileInputStreamFunc(EnumUtil.BLOG_PATH.text() + su.getUsername() + "/md/" + blog.getContent());
        Map<String, Object> res = new HashMap<>();
        res.put("md", str);
        res.put("blog", blog);
        return JSON.toJSONString(res);
    }

    //上传图片
    @RequestMapping(value = "/editormdUploadFile", method = RequestMethod.POST)
    public void hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = EnumUtil.BLOG_PATH.text() + su.getUsername() + "/images/";

            String fileName = ctmLong + "." + FileUtil.getFileSuffix(attach.getOriginalFilename());
            //最终文件名
            File realFile = FileUtil.mkdirParentFile(rootPath + fileName);
            //文件名字：attach.getOriginalFilename();
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            //class文件下放一份
            File classFile = FileUtil.mkdirParentFile(EnumUtil.BLOG_CLASS_PATH.text() + su.getUsername() + "/images/" + fileName);
            FileUtils.copyInputStreamToFile(attach.getInputStream(), classFile);

            String url = "/upload/blog/" + su.getUsername() + "/images/";
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + EnumUtil.OBJECT_IP + ":" + EnumUtil.OBJECT_PROT + "" + url + fileName + "\"}");
        } catch (Exception e) {
            try {
                e.printStackTrace();
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
