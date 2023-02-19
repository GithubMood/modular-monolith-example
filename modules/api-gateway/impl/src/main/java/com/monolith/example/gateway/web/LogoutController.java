package com.monolith.example.gateway.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LogoutController {
    @DeleteMapping("/logout")
    public ResponseEntity<HttpStatus> logout(HttpServletRequest request) {
        //clears session
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
