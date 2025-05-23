package com.danielflores.app_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.controllers
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 11:30
 * All rights reserved 2025.
 **/
@RestController
@RequestMapping("about_us")
public class AboutUsController {
    @GetMapping
    public Map<String, String> aboutUs() {
        ///  ... busssines logic
        return Collections.singletonMap("msg","about us");
    }
}
