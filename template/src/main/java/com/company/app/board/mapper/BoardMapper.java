package com.company.app.board.mapper;

import java.util.List;

import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public void insert(BoardVO board);
	public BoardVO getboard(BoardVO vo);
	public int delete(Long bno);
	public int update(BoardVO board);
}
