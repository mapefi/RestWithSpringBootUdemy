package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverters;

@RestController
public class MathController {
	
	@Autowired
	private SimpleMath math;
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return math.sum(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return math.subtraction(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return math.multiplication(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		
		return math.division(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return math.mean(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if (!NumberConverters.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return math.squareRoot(NumberConverters.convertToDouble(numberOne));
	}
}
