package com.inseop.web.menu.service;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inseop.common.Pagination;
import com.inseop.web.board.dao.BoardDAO;
import com.inseop.web.board.model.BoardVO;
import com.inseop.web.board.model.ReplyVO;
import com.inseop.web.menu.dao.MenuDAO;
import com.inseop.web.menu.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

  @Inject
  private MenuDAO menuDAO;
  
  @Override
  public List<MenuVO> getMenuList() throws Exception {
    return menuDAO.getMenuList();
  }

  @Override
  public void saveMenu(MenuVO menuVO) throws Exception {
    menuDAO.saveMenu(menuVO);
    
  }

  @Override
  public void updateMenu(MenuVO menuVO) throws Exception {
    menuDAO.updateMenu(menuVO);
    
  }

  @Override
  public void deleteMenu(String code) throws Exception {
    menuDAO.deleteMenu(code);
    
  }

}