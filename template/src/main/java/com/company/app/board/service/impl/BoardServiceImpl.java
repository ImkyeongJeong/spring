package com.company.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.board.mapper.BoardMapper;
import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getList(cri);
	}

	@Override
	public void insert(BoardVO board) {
		mapper.insert(board);
	}


	@Override
	public boolean delete(Long bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public boolean update(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	public BoardVO getboard(BoardVO board) {
		return mapper.getboard(board);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

	
}
