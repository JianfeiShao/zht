package com.zht.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zht.entity.Vehicle;
import com.zht.model.VehicleModel;
import com.zht.util.AppJsonDate;

@RequestMapping("/vehicle")
@Controller
public class VehicleController {
	@Autowired
	VehicleModel vehicleModel;
	
	@RequestMapping(value="/initAddPage",method=RequestMethod.GET)
	public String init(){
		return "/VehicleAdd";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Object add(@ModelAttribute Vehicle vehicle,
			@RequestParam("files") MultipartFile files){
		String originFileName = files.getOriginalFilename();
		String suffix = originFileName.substring(originFileName.lastIndexOf("."),originFileName.length());
		String newFileName = UUID.randomUUID().toString()+suffix;
		File file = new File("/vehicleLogo/"+newFileName);
		file.mkdirs();
		try {
			files.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		vehicle.setCLogoUrl("/vehicleLogo/"+newFileName);
		vehicleModel.add(vehicle);
		return null;
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public Object getAll(Model model){
		List<Vehicle> vehicleList = vehicleModel.queryAll();
		model.addAttribute("vehicleList", vehicleList);
		return "VehicleList";
	}
	
	@RequestMapping(value="/appGetAll",method=RequestMethod.GET)
	@ResponseBody
	public Object appGetAll(Model model){
		List<Vehicle> vehicleList = vehicleModel.queryAll();
		return new AppJsonDate(vehicleList, "成功");
	}
	
	
	@RequestMapping(value="/del/{cid}",method=RequestMethod.GET)
	public Object del(@PathVariable("cid")int cid){
		vehicleModel.delById(cid);
		return "forward:/vehicle/getAll";
	}
}