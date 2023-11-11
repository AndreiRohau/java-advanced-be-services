package any.thing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("App is working");
    }
}
