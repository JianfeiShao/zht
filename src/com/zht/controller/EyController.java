package com.zht.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zht.model.EyModel;

@RequestMapping("/ey")
@Controller
public class EyController {
	
	@Autowired
	EyModel eyModel;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(@RequestParam(value = "i",required = false )String i,HttpServletRequest request){
		System.out.println(i);
		eyModel.add(i);
		return "test";
	}
}
