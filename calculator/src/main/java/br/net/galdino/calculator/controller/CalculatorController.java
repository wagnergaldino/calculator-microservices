package br.net.galdino.calculator.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.net.galdino.calculator.exception.UnsuportedMathOperationException;
import br.net.galdino.calculator.util.NumberUtil;

@RestController
public class CalculatorController {
	
	private NumberUtil util = new NumberUtil();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!util.isNumeric(numberOne) || !util.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double sum = util.convertToDouble(numberOne) + util.convertToDouble(numberTwo); 
		return sum;
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!util.isNumeric(numberOne) || !util.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double subtraction = util.convertToDouble(numberOne) - util.convertToDouble(numberTwo); 
		return subtraction;
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!util.isNumeric(numberOne) || !util.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double multiplication = util.convertToDouble(numberOne) * util.convertToDouble(numberTwo); 
		return multiplication;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!util.isNumeric(numberOne) || !util.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double division = util.convertToDouble(numberOne) / util.convertToDouble(numberTwo); 
		return division;
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!util.isNumeric(numberOne) || !util.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double mean = (util.convertToDouble(numberOne) + util.convertToDouble(numberTwo)) / 2; 
		return mean;
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!util.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double squareRoot = (Double) Math.sqrt(util.convertToDouble(number)); 
		return squareRoot;
	}

}
