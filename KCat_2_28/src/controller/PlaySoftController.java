package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import constan.Global;
import dao.PlaySoftDAO;
import model.PlaySoft;
import model.PlaySoft_title;

@Controller
public class PlaySoftController {
	PlaySoftDAO playSoftDAO;
	
	public PlaySoftDAO getPlaySoftDAO() {
		return playSoftDAO;
	}
	@Resource
	public void setPlaySoftDAO(PlaySoftDAO playSoftDAO) {
		this.playSoftDAO = playSoftDAO;
	}
/**
 * ��ת����������ҳ��
 * @param request
 * @param response
 */
	@RequestMapping("/yuleruanjian.do")
	public void toAdminIndex(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/visitor/yuleruanjian.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
/**
 * ֱ�ӻ�ȡ���еı�����Ϣ
 * @return
 */
	@RequestMapping("/getPlaySoft_title.do")
	@ResponseBody
	public ArrayList<PlaySoft_title> getPlaySoft_title(){
		System.out.println("A.������getPlaySoft_title");
		ArrayList<PlaySoft_title> list=playSoftDAO.getPlaySoft_title();
		System.out.println(list);
		return list;
	}
	
/**
 * ���ݱ���id��ȡ��ģ����Ϣ
 * @param playSoft
 * @return
 */
	@RequestMapping("/getPlaySoft.do")
	@ResponseBody
	public ArrayList<PlaySoft> getPlaySoft(PlaySoft playSoft){
		System.out.println(playSoft.getSoft_to_title());
		System.out.println("������PlaySoft��controller����");
		ArrayList<PlaySoft> list=playSoftDAO.getPlaySoft(playSoft.getSoft_to_title());
		System.out.println(list);
		return list;
	}
	
/**
 * ���ݱ���id��ȡ��ģ����Ϣ
 * @param playSoft
 * @return
 */
	@RequestMapping("/getPlaySoft_All.do")
	@ResponseBody
	public void getPlaySoft_All(int num,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		System.out.println("������PlaySoft_All��controller����"+num);
		ArrayList<PlaySoft> list=playSoftDAO.getPlaySoft_All(num);
		System.out.println(list);
		request.setAttribute(Global.Study_Play_DATA, list);
		try {
			request.getRequestDispatcher("visitor/download_play.jsp").forward(request, response);		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}