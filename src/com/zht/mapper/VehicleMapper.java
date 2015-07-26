package com.zht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zht.entity.Vehicle;

public interface VehicleMapper {
	
	@Insert("INSERT INTO vehicle(c_logo_url,c_name,c_country,c_tale) VALUES(#{CLogoUrl},#{CName},#{CCountry},#{CTale})")
	public int add(Vehicle vehicle);
	
	@Select("select * from vehicle")
	public List<Vehicle> queryAll();

	@Delete("delete from vehicle where c_id = #{0}")
	public int delById(int cid);
}
