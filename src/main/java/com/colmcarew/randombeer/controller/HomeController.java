package com.colmcarew.randombeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by colmcarew on 13/07/2017.
 * The purpose of this controller is to render the React App which is rendered through the index.html file
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
}
