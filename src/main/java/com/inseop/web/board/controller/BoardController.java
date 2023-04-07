package com.inseop.web.board.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.inseop.common.Pagination;
import com.inseop.web.board.model.BoardVO;
import com.inseop.web.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Inject
  private BoardService boardService;
  
  @RequestMapping(value = "/getBoardList",method = RequestMethod.GET)
  public String getBoardList(Model model,
                             @RequestParam(required = false,defaultValue = "1") int page,
                             @RequestParam(required = false,defaultValue = "1") int range )
                                 throws Exception {
    
    //전체 게시물 개수
    int listCnt = boardService.getBoardListCnt();
    
    //pagination 객체 생성
    Pagination pagination = new Pagination();
    pagination.pageInfo(page, range, listCnt);

    model.addAttribute("pagination", pagination);
    model.addAttribute("boardList",boardService.getBoardList(pagination));
    return "board/index";
  }
  
  @RequestMapping(value = "/boardForm",method = RequestMethod.GET)
  public String boardForm(@ModelAttribute("boardVO") BoardVO vo, 
                          Model model) throws Exception {
    return "board/boardForm";
  }
  
  @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
  public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO,
                          @RequestParam("mode") String mode,
                           RedirectAttributes rttr) throws Exception {
    
    if(mode.equals("edit")) {
      boardService.updateBoard(boardVO);
    }else {
      boardService.insertBoard(boardVO);
    }
    
    return "redirect:/board/getBoardList";  //redirect의 역할 : 뒤로가기를 했을 때 도배의 여지를 없앰.
  }
  
  @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
  public String getBoardContent(Model model,@RequestParam("bid") int bid) 
                                 throws Exception {
    model.addAttribute("boardContent", boardService.getBoardContent(bid));
    return "board/boardContent";
  }
  
  @RequestMapping(value = "/editForm", method = RequestMethod.GET)
  public String editForm(@RequestParam("bid") int bid, 
                         @RequestParam("mode") String mode, 
                         Model model) throws Exception {
    
    model.addAttribute("boardContent", boardService.getBoardContent(bid));
    model.addAttribute("mode", mode);
    model.addAttribute("boardVO", new BoardVO());
    return "board/boardForm";
  }  

  @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
  public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
    boardService.deleteBoard(bid);
    return "redirect:/board/getBoardList";
  }

//controllerAdvice 이용을 위한 주석
//  @ExceptionHandler(RuntimeException.class)
//  public String exceptionHandler(Model model, Exception e){
//  logger.info("exception : " + e.getMessage());
//  model.addAttribute("exception", e);
//  return "error/exception";
//  }
  
}