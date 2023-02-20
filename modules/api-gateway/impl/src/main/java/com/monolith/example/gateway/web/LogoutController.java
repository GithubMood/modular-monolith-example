package com.monolith.example.gateway.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

//@Slf4j
//@RestController
//@RequiredArgsConstructor
public class LogoutController {
    //    @DeleteMapping("/logout")
    public ResponseEntity<HttpStatus> logout(HttpServletRequest request) {
        //clears session
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
