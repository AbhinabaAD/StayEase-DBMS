
package com.stayease.hotelbooking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to StayEase Hotel Booking System!";
    }

    @GetMapping("/api/status")
    public String status() {
        return "StayEase Backend is Running!";
    }
}
