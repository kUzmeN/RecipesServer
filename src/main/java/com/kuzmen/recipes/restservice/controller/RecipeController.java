package com.kuzmen.recipes.restservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(ModelMap model) {
        return "Hello Wrold";
    }

}
