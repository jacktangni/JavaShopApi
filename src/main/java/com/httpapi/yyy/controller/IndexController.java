package com.httpapi.yyy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test",method= RequestMethod.GET)
public class IndexController {

    @RequestMapping(value="/index",method= RequestMethod.GET)
   public String index(){

        return "hello word";
   }
}
