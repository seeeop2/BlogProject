package com.inseop.web.board.service;

import java.util.List;
import java.util.Map;
import com.inseop.common.Pagination;
import com.inseop.web.board.model.BoardVO;

public interface BoardService {
  
  public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
  
  public int insertBoard(BoardVO boardVO) throws Exception;

  public BoardVO getBoardContent(int bid) throws Exception;

  public void updateBoard(BoardVO boardVO) throws Exception;

  public void deleteBoard(int bid) throws Exception;

  int getBoardListCnt() throws Exception;


  
}
