package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	@GetMapping("/getCustomer")
	public String customerPage()
	{
		return "GetCustomerPage";
	}
	
	@PostMapping("/details")
	public String getDetails(@RequestParam("cid")String cid,@RequestParam("cname")String cname,@RequestParam("cemail")String cemail,
			ModelMap mv)
	{
		mv.put("cid",cid);
		mv.put("cname",cname);
		mv.put("cemail",cemail);
		return "ViewCustomerPage";
	}

}
