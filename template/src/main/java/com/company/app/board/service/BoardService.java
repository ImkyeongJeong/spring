package com.company.app.board.service;

import java.util.List;

import com.company.app.common.Criteria;

public interface BoardService {
	public List<BoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public void insert(BoardVO board);
	public BoardVO getboard(BoardVO board);
	public boolean delete(Long bno);
	public boolean update(BoardVO board);
}
