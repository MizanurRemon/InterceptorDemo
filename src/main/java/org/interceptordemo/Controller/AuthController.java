package org.interceptordemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;


@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/test")
    public ResponseEntity<?> test(){
        LinkedHashMap<String, Object> body = new LinkedHashMap<>();
        body.put("statusCode", HttpStatus.OK.value());
        body.put("message", "auth");
        return ResponseEntity.ok(body);
    }
}
