package devall.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @GetMapping
    public ResponseEntity<String> validate(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("❌ Validation failed: 'name' parameter is missing or empty.");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("✅ Validation successful! Hello, " + name + "!");
    }
}
