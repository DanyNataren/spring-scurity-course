package com.danielflores.app_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.controllers
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 14:29
 * All rights reserved 2025.
 **/

@RestController
@RequestMapping("welcome")
public class WelcomeController {
    @GetMapping
    public Map<String, String> welcome() {
        Map<String, String> welcome = new HashMap<String, String>();
        welcome.put("msg", "Welcome");
        return welcome;
    }
}
