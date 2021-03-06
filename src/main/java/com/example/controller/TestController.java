package com.example.controller;

import com.example.dto.TestDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class TestController {
    @PostMapping("/")
    public String test(@Valid TestDto testDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("request data: " + testDto);
            return "fail";
        }

        return "success";
    }
}
