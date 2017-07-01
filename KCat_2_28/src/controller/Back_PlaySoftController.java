package controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import dao.PlaySoftDAO;
import model.PlaySoft;

@Controller
@RequestMapping("/back")
public class Back_PlaySoftController {
	PlaySoftDAO playSoftDAO;
	
	public PlaySoftDAO getPlaySoftDAO() {
		return playSoftDAO;
	}
	@Resource
	public void setPlaySoftDAO(PlaySoftDAO playSoftDAO) {
		this.playSoftDAO = playSoftDAO;
	}
	
	
/**
 * ��ת������ҳ��	
 * @param request
 * @param response
 */
	@RequestMapping("/error.do")	
	public void toError(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/**
 * ��ת��adminIndex������Ա��ҳ
 * @param request
 * @param response
 */
//	@RequestMapping("/index.do")
//	public void toAdminIndex(HttpServletRequest request,HttpServletResponse response){
//		try {
//			request.getRequestDispatcher("/admin/adminIndex.jsp").forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
	
/**
 * ��ת���ϴ�ҳ��
 * @param request
 * @param response
 */
	@RequestMapping("/uploadPage.do")  //�ύ��ת��jsp��ֱ�ӵ����.do����
	public void toPlayUpload(HttpServletRequest request,HttpServletResponse response){
		System.out.println("������uploadPage��controller����");
		try {
			request.getRequestDispatcher("/admin/yuleruanjianUpload.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
/**
 * ���Ȼ�ȡʱ��Ϊ�ļ�����
 * copy�ļ���ָ��λ��
 * ��������Ϣ�������ݿ�	
 * @param playSoft
 * @param request
 * @param imageFile
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	@RequestMapping("/uploadPlay.do")
	public void uploadPlay(PlaySoft playSoft,HttpServletRequest request,@RequestParam("imageFile") MultipartFile imageFile,HttpServletResponse response) throws ServletException, IOException{
		
		//����ʱ�������ļ���		
		String uploadUrl=request.getSession().getServletContext().getRealPath("/")+"images//ylrj//";      //��ȡ·��:�洢���������
//		String filename=imageFile.getOriginalFilename();    //��ȡ�ļ���

		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);//��ȡ��
		int month=cal.get(Calendar.MONTH)+1;//��ȡ��
		String month_2="";
		String day_2="";
		String hour_2="";
		String minute_2="";
		String second_2="";
		
		if(month<10){
			month_2="0"+month;
		}else{
			month_2=""+month;
		}
		int day=cal.get(Calendar.DAY_OF_MONTH);//��ȡ��
		if(day<10){
			day_2="0"+day;
		}else{
			day_2=""+day;
		}
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<10){
			hour_2="0"+hour;
		}else{
			hour_2=""+hour;
		}
		int minute=cal.get(Calendar.MINUTE);
		if(minute<10){
			minute_2="0"+minute;
		}else{
			minute_2=""+minute;
		}
		int second=cal.get(Calendar.SECOND);
		if(second<10){
			second_2="0"+second;
		}else{
			second_2=""+second;
		}

		String filename=year+month_2+day_2+hour_2+minute_2+second_2+".jpg";   //ֻ���ϴ�jpg�ļ�
		System.out.println("��"+filename);

		File dir=new File(uploadUrl);   //�½�File�ļ��ж���
		if(!dir.exists()){    //�жϲ������½��ļ���
			dir.mkdirs();
		}
		System.out.println("�ļ��ϴ���"+uploadUrl+filename);
		File targetFile=new File(uploadUrl+filename);    //�½��ļ����ݶ���
		if(!targetFile.exists()){
			try {
				targetFile.createNewFile();    //�ļ��������½��ļ�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			imageFile.transferTo(targetFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ݿ�
		playSoft.setSoftImage("ylrj/"+filename);
		playSoftDAO.uploadPlay(playSoft);
		
		request.getRequestDispatcher("/admin/yuleruanjianUpload.jsp").forward(request, response);
	}

}
