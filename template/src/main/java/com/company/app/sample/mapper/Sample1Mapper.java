package com.company.app.sample.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	
	@Insert("insert into tbl_sample1 (col1) values ( #{data} )")//xml없이 데이터 쿼리
	public int insert(String data);
}
