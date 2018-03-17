package com.zking.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/input")
public class InputController {

    public InputController() {
        super();
    }

    @RequestMapping("/admin")
    public String index(){
        String path = "/WEB-INF/" + "admin" + ".jsp";
        return "admin";
    }

    @RequestMapping("/login")
    public String login(){
        String path = "/WEB-INF/" + "login" + ".jsp";
        return "login";
    }

    @RequestMapping("/{dir}/{page}")
    public String forwardPage(@PathVariable String dir,@PathVariable String page){
        String path = dir + "/" +page;
        return path;
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

}
