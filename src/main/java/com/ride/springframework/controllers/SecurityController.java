package com.ride.springframework.controllers;

import com.ride.springframework.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by OD on 6/19/2017.
 */
@Controller
public class SecurityController {

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
