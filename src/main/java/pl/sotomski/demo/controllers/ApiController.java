package pl.sotomski.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sotomski.demo.dto.RandomDTO;
import pl.sotomski.demo.services.ApiService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping
    public ResponseEntity<RandomDTO> get(
        @RequestParam(required = false) String operator,
        @RequestParam(required = false) List<String> repositories
    ) {
        if (operator == null || operator.isEmpty()) {
            operator = "sum";
        }
        if (repositories == null || repositories.isEmpty()) {
            repositories = Arrays.asList("random.org", "java-random");
        }
        return ResponseEntity.ok(apiService.next(operator, repositories));
    }
}
