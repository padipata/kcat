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

import constan.Global;
import dao.StudySoftDAO;
import model.StudySoft;
import model.StudySoft_titleB;
import model.StudySoft_titleS;

@Controller
public class StudySoftController {
	StudySoftDAO studySoftDAO;

	public StudySoftDAO getStudySoftDAO() {
		return studySoftDAO;
	}
	@Resource
	public void setStudySoftDAO(StudySoftDAO studySoftDAO) {
		this.studySoftDAO = studySoftDAO;
	}
	/**
	 * ��ת��רҵ���ҳ��
	 * @param request
	 * @param response
	 */
	@RequestMapping("/zhuanyeruanjian.do")
	public void toAdminIndex(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/visitor/zhuanyeruanjian.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
/**
 * ��ȡ���еĴ����(ѧԺ)
 */
	@RequestMapping("/getStudySoftB.do")
	@ResponseBody
	public ArrayList<StudySoft_titleB> getStudySoftB(){
		System.out.println("A:"+studySoftDAO.getStudySoftB());
		return studySoftDAO.getStudySoftB();
	}
/**
 * ͨ�������id��ȡС����(רҵ)
 */
	@RequestMapping("/getStudySoftS.do")
	@ResponseBody
	public ArrayList<StudySoft_titleS> getStudySoftS(StudySoft_titleS studySoft_titleS){
		System.out.println("B:"+studySoftDAO.getStudySoftS(1));
		return studySoftDAO.getStudySoftS(studySoft_titleS.getTitleS_to_titleB());
	}
/**
 * ͨ��С����id��ȡרҵ�����Ϣ	
 */
	@RequestMapping("/getStudySoft.do")
	@ResponseBody
	public ArrayList<StudySoft> getStudySoft(StudySoft studySoft){
		System.out.println("D:"+studySoft.getSoft_to_titleS());
		return studySoftDAO.getStudySoft(studySoft.getSoft_to_titleS());
	}
/**
 * ���ݱ���id��ȡ��ģ����Ϣ
 * @param studySoft
 * @return
 */
	@RequestMapping("/getStudySoft_All.do")
	@ResponseBody
	public void getStudySoft_All(int num,HttpServletRequest request,HttpServletResponse response) {
		ArrayList<StudySoft> list=studySoftDAO.getStudySoft_All(num);
		request.setAttribute(Global.Study_Play_DATA, list);
		try {
			request.getRequestDispatcher("visitor/download.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ��������ֲ��Ҹ��������Ϣ
	 */
		@RequestMapping("/getStudySoft_id.do")
		@ResponseBody
		public ArrayList<StudySoft> getStudySoft_id(String data){
			return studySoftDAO.getStudySoft_id(data);
		}

		
/**
 * ��ȡ�����������
 * @param studySoft
 * @return
 */
	@RequestMapping("/getAllSoftName.do")
	@ResponseBody
	public ArrayList<StudySoft> getAllSoftName(){
		ArrayList<StudySoft> list = studySoftDAO.getAllSoftName();
		System.out.println(list);
		return list;
	}
}
