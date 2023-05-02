package com.cityeyelab.dt.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "main/index";
    }

    @GetMapping("/test")
    public String test() {

        //FATAL, ERROR, WARN, INFO, DEBUG, TRACE
        log.fatal("FATAL");
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");

        return "main/index_test";
    }
}
