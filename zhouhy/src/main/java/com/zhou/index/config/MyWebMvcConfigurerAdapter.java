package com.zhou.index.config;

import com.zhou.index.config.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title：
 * Description：重写WebMvcConfigurerAdapter中的addInterceptors方法如下
 *
 * @author: zhouhy
 * @create 2017-11-09 10:21
 **/
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
//
//      注释的代码为spring boot 2.0.x以下的写法  2.0.x以上静态资源会被默认拦截
//
//

    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义项目内目录
        //registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        //指向外部目录
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        //super.addResourceHandlers(registry);
    }


    /**
     * 以前要访问一个页面需要先创建个Controller控制类，在写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.html页面了
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("/zhou/login");
    }

    /**
     * @Author: zhouhy
     * @Description:
     * @Date: 15:15 2018/7/5
     * @params: [registry]
     * @returns: void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathPatterns = new ArrayList<>();
        //登录
        excludePathPatterns.add("/toLogin");
        excludePathPatterns.add("/login");
        //静态资源
        excludePathPatterns.add("/module/**");
        excludePathPatterns.add("/plugins/**");

        excludePathPatterns.add("/*/css/**");
        excludePathPatterns.add("/*/js/**");
        excludePathPatterns.add("/*/css/**");
        excludePathPatterns.add("/*/fonts/**");
        excludePathPatterns.add("/*/images/**");
        excludePathPatterns.add("/*/scss/**");
        excludePathPatterns.add("/*/nuget/**");
        excludePathPatterns.add("/*/themes/**");
        excludePathPatterns.add("/*/lib/**");
        excludePathPatterns.add("/*/include/**");
        excludePathPatterns.add("/*/plugins/**");

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
