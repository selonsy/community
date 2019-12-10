package com.selonsy.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright：Sichen International Co. Ltd.
 *
 * @author selonsy
 * Created on 2019/12/10.
 * Desc : none
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
