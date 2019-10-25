package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Uom;
import com.app.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@RequestMapping("/register")
	//show register page
	public String  showReg()
	{
		return "UomRegister";
	}
	//save data on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom,ModelMap map)
	{
		//call service
		Integer id=service.saveUom(uom);
		//constructor success message
		String message="Uom '"+id+"'created";
		//send message to ui
		map.addAttribute("msg",message);
		return "UomRegister";
	}
}
