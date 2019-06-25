package webCalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webCalculator.CalculationResponse;
import webCalculator.Calculator;
import webCalculator.CalculationModel;


@Controller
@RequestMapping("/")
public class CalculatorController {
	
	@GetMapping
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "controller.htm", method = RequestMethod.POST)
	@ResponseBody
	public CalculationResponse getCalculation(@RequestBody CalculationModel model) {		
		CalculationResponse response = new CalculationResponse();
		Calculator calculator = Calculator.getCalculator();
		String result = calculator.getResult(model.getNumber1(), model.getNumber2(), model.getOperator());
		
		response.setResponse(result);
		return response;
	}
}
