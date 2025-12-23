package com.example.employee.controller;

import java.util.HashMap;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Swagger working!");
        return map;
    }
}
