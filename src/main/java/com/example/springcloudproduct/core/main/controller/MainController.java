package com.example.springcloudproduct.core.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * packageName  :   com.example.springcloudproduct.core.main.controller
 * fileName     :   MainController
 * author       :   sinabeuro53
 * date         :   2022-03-24
 * description  :
 */

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/*","/productDetail/*"})
    public ModelAndView pageMove(ModelAndView modelAndView) {
        String path = System.getProperty("user.dir");
        modelAndView.setViewName("index");
        modelAndView.addObject("path", path);

        return modelAndView;
    }
}
