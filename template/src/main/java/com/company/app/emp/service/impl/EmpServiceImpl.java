package com.company.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper mapper;
	
	@Override
	public EmpVO getEmp(EmpVO vo) {
		return mapper.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpReqVO vo) {
		return mapper.getEmpList(vo);
	}

	@Override
	public int insert(EmpVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int update(EmpVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int delete(EmpVO vo) {
		return mapper.delete(vo);
	}

	@Override
	public List<EmpVO> getEmpByDept(String[] dept) {
		return mapper.getEmpByDept(dept);
	}

}
