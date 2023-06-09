package com.inseop.web.menu.dao;

import java.util.List;



import javax.inject.Inject;



import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;
import com.inseop.common.Pagination;
import com.inseop.web.board.model.BoardVO;
import com.inseop.web.board.model.ReplyVO;
import com.inseop.web.menu.model.MenuVO;


@Repository
public class MenuDAOImpl implements MenuDAO {
  @Inject
  private SqlSession sqlSession;
  
  @Override
  public List<MenuVO> getMenuList() throws Exception {
    return sqlSession.selectList("com.inseop.web.menu.menuMapper.getMenuList");
  }

  @Override
  public int saveMenu(MenuVO menuVO) throws Exception {
    return sqlSession.insert("com.inseop.web.menu.menuMapper.insertMenu", menuVO);
  }

  @Override
  public int updateMenu(MenuVO menuVO) throws Exception {
    return sqlSession.update("com.inseop.web.menu.menuMapper.updateMenu", menuVO);
  }

  @Override
  public int deleteMenu(String code) throws Exception {
    return sqlSession.delete("com.inseop.web.menu.menuMapper.deleteMenu", code);
  }

}