package co.grandcircus.Lab215;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab215Controller {

	public static NumberFormat df = NumberFormat.getCurrencyInstance();
	
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/mileage-form")
	public ModelAndView showForm() {
		return new ModelAndView("/mileage-form");
	}
	
	@RequestMapping("/mileage-result")
	public ModelAndView showResult(
			@RequestParam("MPG") double MPG,
			@RequestParam("gallons") double gallons,
			@RequestParam("price") double price,
			@RequestParam("distYear") int distYear) {
		
		double distance = MPG * gallons;
		BigDecimal bd = new BigDecimal(distance);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double resultDistance = bd.doubleValue();
		double resultCost = (price / MPG);
		String resultCostPerMile = df.format(resultCost);
		double costYear = (distYear / MPG) * price;
		String resultCostYear = df.format(costYear);
		
		ModelAndView mav = new ModelAndView("mileage-result");
		mav.addObject("MPG", MPG);
		mav.addObject("gallons", gallons);
		mav.addObject("resultDistance", resultDistance);
		mav.addObject("resultCostPerMile", resultCostPerMile);
		mav.addObject("resultCostYear", resultCostYear);
		return mav;
	}
}
