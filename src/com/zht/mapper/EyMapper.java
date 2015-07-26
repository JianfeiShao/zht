package com.zht.mapper;

import org.apache.ibatis.annotations.Insert;

public interface EyMapper {
	
	@Insert("INSERT INTO ey(message) values(#{0})")
	public void add(String message);
	
}
