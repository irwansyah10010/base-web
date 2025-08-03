package io.irwansyahdev96.backoffice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping(value = "generalapi/health-check", method = RequestMethod.GET)
    public ResponseEntity<String> healthStatus(){
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
    
            return ResponseEntity.ok().body("Status Health Check OK");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }
}
