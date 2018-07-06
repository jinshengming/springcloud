package net.htjs.pt4.sys;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description
 * @Author ming.js
 * @Date 2018/6/14
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConfigHandlerInterceptor()).addPathPatterns("/owner/**");
        super.addInterceptors(registry);
    }
}
