package dev.aerolinea.springaerolinea.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("${api-endpoint}/auth")
public class AuthController {

    // Login endpoint - доступ ограничен (только аутентифицированным)
    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful");
    }

    // Userinfo endpoint - доступ ограничен (только аутентифицированным)
    @GetMapping("/userinfo")
    public ResponseEntity<Map<String, String>> getUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, String> response = new HashMap<>();
        response.put("message", "User information retrieved successfully");
        response.put("username", auth.getName());
        response.put("roles", auth.getAuthorities().toString());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
