package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
@Log
public class InfoController {

    @GetMapping(value = "/status")
    public ResponseEntity<String> getStatus() {
        log.info("Endpoint-get-path=" + "/info/status");
        return ResponseEntity.ok("Success!");
    }
}
