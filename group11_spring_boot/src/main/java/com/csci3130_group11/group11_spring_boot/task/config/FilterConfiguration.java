package com.csci3130_group11.group11_spring_boot.task.config;

import com.csci3130_group11.group11_spring_boot.task.filter.TaskFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<TaskFilter> registrationBean() {
        FilterRegistrationBean<TaskFilter> registrationBean = new FilterRegistrationBean<TaskFilter>();
        registrationBean.setFilter(new TaskFilter());
        registrationBean.addUrlPatterns("/task/*");
        return registrationBean;
    }
}
