package com.ming.demo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigurer implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/login/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/rider/**")
                .excludePathPatterns("/admin/index/login")
                .excludePathPatterns("/login/loginControllerOld")
                .excludePathPatterns("/login/weichatwxLogin")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/getClassification");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
