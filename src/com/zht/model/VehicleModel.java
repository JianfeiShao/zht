package com.zht.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zht.entity.Vehicle;
import com.zht.mapper.VehicleMapper;
import com.zht.util.mybatis.M;

@Service("vehicleModel")
public class VehicleModel {
	
	@Autowired
	M m;
	
	public int add(Vehicle vehicle){
		return m.getMapper(VehicleMapper.class).add(vehicle);
	}
	
	public List<Vehicle> queryAll(){
		return m.getMapper(VehicleMapper.class).queryAll();
	}
	
	public int delById(int cid) {
		return m.getMapper(VehicleMapper.class).delById(cid);
	}
}
