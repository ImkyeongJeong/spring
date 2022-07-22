package com.company.mvc.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public int insert(EmpVO vo);
	public int update(EmpVO vo);
	public int delete(EmpVO vo);
}
