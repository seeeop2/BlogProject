package com.inseop.web.board.controller;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.inseop.common.Pagination;
import com.inseop.web.board.model.BoardVO;
import com.inseop.web.board.model.ReplyVO;
import com.inseop.web.board.service.BoardService;

@RestController
@RequestMapping(value = "/restBoard")
public class RestBoardController {
  private static final Logger logger = LoggerFactory.getLogger(RestBoardController.class);

  @Inject
  private BoardService boardService;
  

  @RequestMapping(value = "/getReplyList", method = RequestMethod.POST)
  public List<ReplyVO> getReplyList(@RequestParam("bid") int bid) throws Exception {
    System.out.println("오니?");
    return boardService.getReplyList(bid);
  }
  
  
}
