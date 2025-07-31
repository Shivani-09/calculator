package com.example.myCalculator.dto;

public class CalculationResponse {

	private String errorMessage;
	private double result;
	
	public CalculationResponse(Double result, String errorMessage) {
		this.result = result;
		this.errorMessage = errorMessage;
	}
	
	public double getResult() {
		return result;
	}
	
	public void setResult(double result) {
		this.result = result;
	}
	
	public String getErrormessage() {
		return errorMessage;
	}
	
	public void setErrormessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
