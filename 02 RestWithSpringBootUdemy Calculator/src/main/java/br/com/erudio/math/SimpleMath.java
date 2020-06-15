package br.com.erudio.math;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {
	
	public Double sum(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}	
	
	public Double subtraction(double numberOne, double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public Double multiplication(double numberOne, double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public Double division(double numberOne, double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public Double mean(double numberOne, double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	
	public Double squareRoot(double numberOne) {
		return Math.sqrt(numberOne);
	}
}
