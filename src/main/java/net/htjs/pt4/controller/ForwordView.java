package net.htjs.pt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forword/")
public class ForwordView {


    @GetMapping("{path}")
    public String forword(@PathVariable String path) {
        return path;
    }
}
