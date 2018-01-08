package com.zhou.blog.controller;

import com.alibaba.fastjson.JSON;
import com.zhou.blog.domain.Blog;
import com.zhou.blog.service.BlogService;
import com.zhou.index.domain.SysUser;
import com.zhou.index.util.DateUtil;
import com.zhou.index.util.EnumUtil;
import com.zhou.index.util.FileUtil;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value="/mdeditor")
    public ModelAndView mdeditor(String id){
        ModelAndView mav = new ModelAndView("/blog/mdeditor");
        mav.addObject("id",id);
        return mav;
    }

    @RequestMapping(value="/editor2")
    public ModelAndView editor2(){
        ModelAndView mav = new ModelAndView("/blog/csdneditor");
        return mav;
    }
    //查看
    @RequestMapping(value="/blog")
    public ModelAndView blog(String id,HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/blog/blog");
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        Blog blog = blogService.queryBlogByIdAndUserId(id,su.getId());
        if(!(blog==null||blog.getId()==null||"".equals(blog.getId()))){
            mav.addObject("id",id);
        }
        return mav;
    }

    //删除
    @RequestMapping(value="/deleteBlog")
    @ResponseBody
    public String deleteBlog(String id,HttpServletRequest request){
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        Blog blog = blogService.queryBlogByIdAndUserId(id,su.getId());
        String filePath = EnumUtil.BLOG_PATH.text()+su.getUsername()+"/md/";
        String fileName = blog.getContent();
        boolean fileDelFlag = FileUtil.fileRename(filePath+fileName,
                DateUtil.dateToString(new Date(),EnumUtil.DATE_FULL_FORMAT.text())+"_"+fileName);
        int flag = blogService.deleteBlog(id,su.getId());
        return ""+flag;
    }

    //列表
    @RequestMapping(value="/blogList")
    public ModelAndView postList(){
        ModelAndView mav = new ModelAndView("/blog/blogList");
        return mav;
    }
    //发表
    @RequestMapping(value="/postBlog")
    @ResponseBody
    public String postBlog(Blog b,HttpServletRequest request){
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        FileUtil.fileOutputStreamFunc(EnumUtil.BLOG_PATH.text()+su.getUsername()+"/md/"+ctmLong+".md",b.getContent());

        b.setContent(ctmLong+".md");
        b.setSysUser(su);
        blogService.addBlog(b);
        return b.getId();
    }
    //修改博客
    @RequestMapping(value="/modifyBlog")
    @ResponseBody
    public String modifyBlog(Blog b,HttpServletRequest request){
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        Blog blog = blogService.queryBlogByIdAndUserId(b.getId(),su.getId());
        if(!(blog==null||blog.getId()==null||blog.getId().equals(""))){
            FileUtil.fileOutputStreamFunc(EnumUtil.BLOG_PATH.text()+su.getUsername()+"/md/"+blog.getContent(),b.getContent());
            blogService.modifyBlog(b);
        }
        return b.getId();
    }
    //增加阅读量
    @RequestMapping(value="/modifyBlogReadCountById")
    @ResponseBody
    public String modifyBlogReadCountById(String id,HttpServletRequest request){
        int flag = blogService.modifyBlogReadCountById(id);
        if(flag==1){
            System.out.println("阅读量+1");
        }else
            System.out.println("阅读量增加失败");
        return "";
    }
    //获取列表
    @RequestMapping(value="/getBlogList")
    @ResponseBody
    public String getBlogList(HttpServletRequest request){
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        List<Blog> blogList = blogService.queryBlogListByAuthorId(su.getId());
        return JSON.toJSONString(blogList);
    }
    //获取博客信息
    @RequestMapping(value="/getBlogContent")
    @ResponseBody
    public String getBlogContent(String id,HttpServletRequest request){
        SysUser su=(SysUser)request.getSession().getAttribute("sysUser");
        Blog blog = blogService.queryBlogById(id);
        String str = FileUtil.fileInputStreamFunc(EnumUtil.BLOG_PATH.text()+su.getUsername()+"/md/"+blog.getContent());
        Map<String,Object> res = new HashMap<>();
        res.put("md",str);
        res.put("blog",blog);
        return JSON.toJSONString(res);
    }

    //上传图片
    @RequestMapping(value="/editormdUploadFile",method=RequestMethod.POST)
    public void hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        SysUser su = (SysUser)request.getSession().getAttribute("sysUser");
        long ctmLong = System.currentTimeMillis();
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = EnumUtil.BLOG_PATH.text()+su.getUsername()+"/images/";

            String fileName = ctmLong + "." + FileUtil.getFileSuffix(attach.getOriginalFilename());
            //最终文件名
            File realFile = FileUtil.mkdirParentFile(rootPath + fileName);
            //文件名字：attach.getOriginalFilename();
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            //class文件下放一份
            File classFile = FileUtil.mkdirParentFile(EnumUtil.BLOG_CLASS_PATH.text() +su.getUsername()+"/images/" + fileName);
            FileUtils.copyInputStreamToFile(attach.getInputStream(), classFile);

            String url = "/upload/blog/"+su.getUsername()+"/images/";
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\""+EnumUtil.OBJECT_IP+":"+EnumUtil.OBJECT_PROT+""+url+fileName+"\"}");
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
