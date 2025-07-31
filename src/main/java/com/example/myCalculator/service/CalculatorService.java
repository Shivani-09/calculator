package com.example.myCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double calculate(double num1, double num2, String operation) {
		return switch (operation.toLowerCase()) {
		case "add" -> num1 + num2;
		case "substract" -> num1 - num2;
		case "multiply" -> num1 * num2;
		case "divide" -> {
			if(num2 == 0) {
			throw new IllegalArgumentException ("Cannot divide by zero!");
			}
			yield num1 / num2;
		}
		
		default ->
			throw new IllegalArgumentException("Unexpected value: " + operation);
		};
	}
}
