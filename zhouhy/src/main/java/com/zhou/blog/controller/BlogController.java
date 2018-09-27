package com.zhou.blog.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.blog.entity.Blog;
import com.zhou.blog.service.BlogService;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import com.zhou.index.comm.util.*;
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

    /**
     * @Author: zhouhy
     * @Description: 编辑
     * @Date: 14:07 2018/8/23
     */
    @RequestMapping(value = "/edit")
    public ModelAndView edit(String id) {
        ModelAndView mav = new ModelAndView("blog/edit");
        mav.addObject("id", id);
        return mav;
    }

    /**
     * @Author: zhouhy
     * @Description: 查看
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/blog")
    public ModelAndView query(String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("blog/blog");
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

    /**
     * @Author: zhouhy
     * @Description: 删除
     * @Date: 14:09 2018/8/23
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(String id, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.where("id={0}", id);
        ew.and("sys_user_id", su.getId());
        Blog blog = blogService.selectOne(ew);

        if (blog == null) {
            return Result.create(MsgEnumHelper.RESULT_SET_NOT_EXIST);
        }
        //更新文件名字
        String filePath = EnumHelper.BLOG_PATH.v() + su.getUsername() + "/md/";
        String fileName = blog.getFileName();
        String newFileName = DateHelper.dateToString(new Date(), EnumHelper.DATE_FULL_FORMAT.v()) + "_" + fileName;
        boolean fileDelFlag = FileHelper.fileRename(filePath + fileName,newFileName);

        blog.setFileName(newFileName);
        blog.setState(EnumHelper.DELETED.k());
        boolean flag = blogService.updateById(blog);

        if (flag && fileDelFlag) {
            return Result.ok();
        } else {
            return Result.create(MsgEnumHelper.RESULT_SET_NOT_EXIST);
        }
    }

    /**
     * @Author: zhouhy
     * @Description: 列表
     * @Date: 14:23 2018/8/23
     */
    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("blog/list");
        return mav;
    }

    /**
     * @Author: zhouhy
     * @Description: 发表
     * @Date: 14:23 2018/8/23
     */
    @RequestMapping(value = "/publish")
    @ResponseBody
    public Result publish(Blog b, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        b.setFileName(ctmLong + ".md");
        FileHelper.fileOutputStreamFunc(EnumHelper.BLOG_PATH.v() + su.getUsername() + "/md/" + b.getFileName(), b.getContent());

        b.setId(UUIDHelper.getUUID());
        b.setSysUserId(su.getId());
        b.setCreateTime(new Date());
        b.setUpdateTime(new Date());
        blogService.insert(b);
        return Result.ok().put("id", b.getId());
    }

    /**
     * @Author: zhouhy
     * @Description: 修改博客 如果修改的博客md文件不存在 则重新创建
     * @Date: 17:06 2018/8/23
     */
    @RequestMapping(value = "/modify")
    @ResponseBody
    public Result modify(Blog b, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.where("id={0}", b.getId());
        ew.and("sys_user_id={0}", su.getId());
        Blog blog = blogService.selectOne(ew);

        if (!(blog == null || blog.getId() == null || blog.getId().equals(""))) {
            boolean isSuccess = FileHelper.fileOutputStreamFunc(EnumHelper.BLOG_PATH.v() + su.getUsername() + "/md/" + blog.getFileName(), b.getContent());
            if (!isSuccess) {
                long ctmLong = System.currentTimeMillis();
                FileHelper.fileOutputStreamFunc(EnumHelper.BLOG_PATH.v() + su.getUsername() + "/md/" + ctmLong + ".md", b.getContent());
                blog.setFileName(ctmLong + ".md");
            }

            blog.setUpdateTime(new Date());
            blog.setTitle(b.getTitle());
            blogService.updateById(blog);
        }
        return Result.ok().put("id", b.getId());
    }

    /**
     * @Author: zhouhy
     * @Description: 增加阅读量
     * @Date: 17:08 2018/8/23
     */
    @RequestMapping(value = "/modifyBlogReadCountById")
    @ResponseBody
    public Result modifyBlogReadCountById(String id) {
        Blog blog = blogService.selectById(id);
        blog.setReads(blog.getReads() + 1);
        boolean flag = blogService.updateById(blog);
        if (flag) {
            System.out.println("阅读量+1");
        } else {
            System.out.println("阅读量增加失败");
        }
        return Result.ok();
    }

    /**
     * @Author: zhouhy
     * @Description: 获取列表
     * @Date: 17:09 2018/8/23
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");

        EntityWrapper<Blog> ew = new EntityWrapper<>();
        ew.and("a.sys_user_id={0}", su.getId());
        ew.and("a.state={0}", EnumHelper.NOT_DELETE);
        ew.orderBy("a.create_time", false);
        List<Blog> blogList = blogService.selectBlog(ew);

        return Result.ok().put("list", blogList);
    }

    /**
     * @Author: zhouhy
     * @Description: 获取博客信息
     * @Date: 17:11 2018/8/23
     */
    @RequestMapping(value = "/getContent")
    @ResponseBody
    public Result getContent(String id, HttpServletRequest request) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        Blog blog = blogService.selectById(id);
        String str = FileHelper.fileInputStreamFunc(EnumHelper.BLOG_PATH.v() + su.getUsername() + "/md/" + blog.getFileName());
        return Result.ok().put("md", str).put("blog", blog);
    }

    /**
     *  @Author: zhouhy
     *  @Description: 上传图片
     *  @Date: 17:13 2018/8/23
     */
    @RequestMapping(value = "/editormdUploadFile", method = RequestMethod.POST)
    public void editormdUploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = EnumHelper.BLOG_PATH.v() + su.getUsername() + "/images/";

            String fileName = ctmLong + "." + FileHelper.getFileSuffix(attach.getOriginalFilename());
            //最终文件名
            File realFile = FileHelper.mkdirParentFile(rootPath + fileName);
            //文件名字：attach.getOriginalFilename();
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            //class文件下放一份
            File classFile = FileHelper.mkdirParentFile(EnumHelper.BLOG_CLASS_PATH.v() + su.getUsername() + "/images/" + fileName);
            FileUtils.copyInputStreamToFile(attach.getInputStream(), classFile);

            String url = "/upload/blog/" + su.getUsername() + "/images/";
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + EnumHelper.DOMAIN_NAME.v() + "" + url + fileName + "\"}");
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
