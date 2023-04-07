package com.inseop.web.board.service;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inseop.common.Pagination;
import com.inseop.web.board.dao.BoardDAO;
import com.inseop.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
  
  @Inject
  BoardDAO boardDAO;
  
  @Override
  public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
    return boardDAO.getBoardList(pagination) ;
  }
  
  @Override
  public int insertBoard(BoardVO boardVO) throws Exception {
    
    return boardDAO.insertBoard(boardVO);
  }

  @Override
  public BoardVO getBoardContent(int bid) throws Exception {
    
    BoardVO boardVO = new BoardVO();

    boardDAO.updateViewCnt(bid);
//    
//    boardVO.setBid(bid);
//    boardVO.setCate_cd("1111111111111111111111111111111111111111111111111111111111");
//    boardDAO.updateBoard(boardVO);
////    return boardDAO.getBoardContent(bid);
    return boardVO;
  }

  @Override
  public void updateBoard(BoardVO boardVO) throws Exception {
    boardDAO.updateBoard(boardVO);    
  }

  @Override
  public void deleteBoard(int bid) throws Exception {
    boardDAO.deleteBoard(bid);
  }
  //총 게시글 개수 확인
  @Override
  public int getBoardListCnt() throws Exception {
    return boardDAO.getBoardListCnt();
  }
  
}