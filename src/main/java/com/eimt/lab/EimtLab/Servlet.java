package com.eimt.lab.EimtLab;


import com.eimt.lab.EimtLab.EimtLabApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class Servlet extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EimtLabApplication.class);
    }

}

