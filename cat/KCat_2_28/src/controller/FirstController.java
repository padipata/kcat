package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import dao.FirstDAO;
import model.First;
@Controller
public class FirstController {
	FirstDAO firstDAO;

	public FirstDAO getFirstDAO() {
		return firstDAO;
	}
	@Resource
	public void setFirstDAO(FirstDAO firstDAO) {
		this.firstDAO = firstDAO;
	}
/*
 * ����¼
 */
	@RequestMapping("/login.do")
	@ResponseBody
	public boolean login(HttpSession session,First first){
		System.out.println("����login"+first.getUserName()+":"+first.getUserPwd());
		ArrayList<First> list=firstDAO.login(first);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}
/*
 * ����û���	
 */
	@RequestMapping("/checkUser.do")
	@ResponseBody
	public boolean checkUser(First first){
		System.out.println("������add111");
		ArrayList<First> list=firstDAO.checkUser(first);
		if(list.size()>0){     //���û�
			return false;    //�жϵ����û�������
		}
		return true;
	}
/*
 * ����û�
 * 	
 */
	@RequestMapping("/addUser.do")
	@ResponseBody
	public boolean addUser(First first){
		System.out.println("����controller_add:"+first.getUserName()+":"+first.getUserPwd()+":"+first.getSex()+":"+first.getEmail()+":"+first.getBirthday());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //�������ڸ�ʽ
		System.out.println(df.format(new Date()));    //new Date()Ϊ��ȡ��ǰϵͳʱ��

		firstDAO.addUser(first);
		return true;
	}

/*
 * ��ȡ�����û���Ϣ 
 * 	
 */
		@RequestMapping("/getAllUser.do")
		@ResponseBody
		public ArrayList<First> getAllUser(){		
			return firstDAO.getAllUser(); 
		}
		
/*
 * �޸��û���Ϣ 
 * 	
 */
		
		@RequestMapping("/modifyUser.do")
		@ResponseBody
		public boolean modifyUser(First first){
			System.out.println("����controller_modify:"+first.getUserName()+":"+first.getUserPwd()+":"+first.getSex()+":"+first.getEmail());
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //�������ڸ�ʽ
			System.out.println(df.format(new Date()));    //new Date()Ϊ��ȡ��ǰϵͳʱ��

			firstDAO.modifyUser(first);
			return true;
		}

/*
 * ɾ���û���Ϣ 
 * 	
 */
		@RequestMapping("/deleteUser.do")
		@ResponseBody
		public boolean deleteUser(int id){
			System.out.println("����controller_delete:id = "+id);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //�������ڸ�ʽ
			System.out.println(df.format(new Date()));    //new Date()Ϊ��ȡ��ǰϵͳʱ��

			firstDAO.deleteUser(id);
			return true;
		}
		
}
