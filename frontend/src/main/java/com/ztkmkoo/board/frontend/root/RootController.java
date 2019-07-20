package com.ztkmkoo.board.frontend.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class RootController {

    private static final String ROOT = "index";

    @GetMapping(value = "/")
    public String root() {
        return ROOT;
    }
}
