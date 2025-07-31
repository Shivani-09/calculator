package com.example.myCalculator.controller;

import com.example.myCalculator.dto.CalculationRequest;
import com.example.myCalculator.dto.CalculationResponse;
import com.example.myCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/calculator") // Base path for all endpoints in this controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate") // Handles POST requests to /api/calculator/calculate
    public ResponseEntity<CalculationResponse> performCalculation(@RequestBody CalculationRequest request) {
        try {
            double result = calculatorService.calculate(request.getnum1(), request.getnum2(), request.getOperation());
            return ResponseEntity.ok(new CalculationResponse(result, null)); // Return success response
        } catch (IllegalArgumentException e) {
            // Handle specific errors like division by zero or invalid operation
            return ResponseEntity.badRequest().body(new CalculationResponse(null, e.getMessage()));
        } catch (Exception e) {
            // Catch any other unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new CalculationResponse(null, "An unexpected error occurred: " + e.getMessage()));
        }
    }
}