package com.inseop.web.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    List<ReplyVO> list = boardService.getReplyList(bid);
    return list;
  }
  
  @RequestMapping(value = "/saveReqly", method = RequestMethod.POST)
  public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) 
                                          throws Exception {
  
    Map<String, Object> result = new HashMap<>();

    try {
      boardService.saveReply(replyVO);
      result.put("status", "OK");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "False");
    }

    return result;
  }
  
  @RequestMapping(value = "/updateReply", method = {RequestMethod.GET, RequestMethod.POST})
  public Map<String, Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception {
    
  Map<String, Object> result = new HashMap<>();

  try {
  boardService.updateReply(replyVO);
  result.put("status", "OK");

  } catch (Exception e) {
  e.printStackTrace();
  result.put("status", "False");
  }
  return result;
  }
  
  @RequestMapping(value = "/deleteReply", method = {RequestMethod.GET, RequestMethod.POST})

  public Map<String, Object> deleteReply(@RequestParam("rid") int rid) throws Exception {

  Map<String, Object> result = new HashMap<>();
  
  try {
  boardService.deleteReply(rid);
  result.put("status", "OK");
  } catch (Exception e) {
  e.printStackTrace();
  result.put("status", "False");
  }
  return result;
  }

}
