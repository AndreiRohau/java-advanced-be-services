package org.example.config;

import org.example.converter.SubscriptionConverter;
import org.example.converter.SubscriptionDtoConverter;
import org.example.converter.UserConverter;
import org.example.converter.UserDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableSpringDataWebSupport
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add( new PageableHandlerMethodArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SubscriptionDtoConverter());
        registry.addConverter(new SubscriptionConverter());
        registry.addConverter(new UserConverter());
        registry.addConverter(new UserDtoConverter());
    }

}
