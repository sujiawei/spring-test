package com.sujiawei.java.config;

import com.sujiawei.java.services.impl.HelloWorld;
import com.sujiawei.java.services.impl.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerConfig.class, SchedulerConfig.class})
public class AppConfig {

    @Bean(name = "helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}
