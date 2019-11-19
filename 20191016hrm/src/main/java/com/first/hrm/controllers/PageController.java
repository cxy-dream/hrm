package com.first.hrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String getPage(@PathVariable String page){

        return page;
    }
}
