package com.example.demo;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String getCustomerPage() {
		return "GetCustomerPage";
	}

	@RequestMapping("/details")
	public String customerDetailsSave(Customer customers) {
		repo.save(customers);
		return "GetCustomerPage";
	}

	@RequestMapping("/getdetails")
	public String displayCustomerDetails() {
		return "ViewCustomerPage";
	}

	@PostMapping("/getdetails")
	public ModelAndView getDetails(@RequestParam int cid ) {
		ModelAndView mv=new ModelAndView("Retrive");
		Customer customer=repo.findById(cid).orElse(null);
		mv.addObject(customer);
		return mv;
	}

}
