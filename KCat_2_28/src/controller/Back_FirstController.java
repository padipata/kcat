package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.FirstDAO;
import model.First;
import model.Pager;
//��̨�����û�ҳ�棨�ܵ����أ�

@Controller
@RequestMapping("/back")
public class Back_FirstController {
	FirstDAO firstDAO;

	public FirstDAO getFirstDAO() {
		return firstDAO;
	}
	@Resource
	public void setFirstDAO(FirstDAO firstDAO) {
		this.firstDAO = firstDAO;
	}
	
/**
 * ��ת���û�����ҳ��	
 * @param request
 * @param response
 */
	@RequestMapping("/toPartUserPage.do")	
	public void toPartUserPage(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/admin/userManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * ��ȡָ���������ݵ��û���Ϣ
 * @return
 */
	@RequestMapping("/getPartUser.do")
	@ResponseBody
	public ArrayList<First> getPartUser(){

		Pager pager=new Pager();   //�������ù̶��ĵڼ�ҳ��ҳ��Size��֮����Ҫ�޸�ͨ���ж�ȥ����ֵ
		pager.setPageNo(0);	  //��0��ʼ
		pager.setPageSize(3);   //��ʾ����
		System.out.println(firstDAO.getPartUser(pager));
		return firstDAO.getPartUser(pager);
	}
/**
 * ɾ��ָ��id���û�	
 * @param id
 */
	@RequestMapping("/deleteUser.do")
	public void deleteUser(int id,HttpServletRequest request,HttpServletResponse response){
		System.out.println("First��ǰ�˻�ȡ����idΪ��"+id);
		firstDAO.deleteUser(id);   //û�з���ִ����Ϣ
		//ִ��ɾ��֮������ʲô����ת���󣡣���
		try {
			request.getRequestDispatcher("/admin/userManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * ����id�޸��û�	
 * @param first
 */
	@RequestMapping("/modifyUser.do")
	public void modifyUser(First first){
		firstDAO.modifyUser(first);   //û�з���ִ����Ϣ
	}
/**
 * ����id��ѯ�û�����
 * @param id
 * @return
 */
	@RequestMapping("/findUserById.do")
	@ResponseBody
	public First findUserById(int id){
		return firstDAO.findUserById(id);
	}
	
}
