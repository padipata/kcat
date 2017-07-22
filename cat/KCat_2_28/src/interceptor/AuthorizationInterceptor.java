package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import model.Admin;
//������
public class AuthorizationInterceptor implements HandlerInterceptor {
	//�����ص�ҳ��
	private static final String[] IGNORE_URI={"/error","/getPartUser","/deleteUser","findUserById","modifyUser"};   //��дXX���� .do  "/XX","/YY"    ������ҳ��getPartUser��deleteUser
	
	/**
	 * ����֮��ִ�У�����������Դ
	 * ��Interceptor��preHandle����Ϊtrueʱִ��
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("����AuthorizationInterceptor  afterCompletion()");
	}
	/**
	 * Controller����֮��ִ�У��ɶ�ModelAndView����
	 * ��Interceptor��preHandle����Ϊtrueʱִ��
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("����AuthorizationInterceptor  postHandle()");
	}
	/**
	 * preHandle����ʹ�ã���controllerִ��֮ǰ
	 * ����ֵΪtrue�Ż�����ִ�У�false�Ļ�����ͽ���
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("����AuthorizationInterceptor  preHandle()");
		boolean flag=false;   //���ڴ洢�жϵ�¼�Ľ��
		//������·�������ж�
		String servletPath=request.getServletPath();  
		//�ж������Ƿ���Ҫ����
		for(String s:IGNORE_URI){
			if(servletPath.contains(s)){
				flag=true;    //����ǲ����ص���վ��flagΪtrue,����ѭ����ת���¸�����
				break;
			}
		}
		//��������
		if(!flag){   //����Ƿǹ�����ҳ���
			Admin admin=(Admin)request.getSession().getAttribute("ADMIN");
			if(admin==null){
				System.out.println("AuthorizationInterceptor��������");
				request.getRequestDispatcher("/visitor/error.jsp").forward(request, response);
			}else{
				//�û���½������֤ͨ��������
				System.out.println("AuthorizationInterceptor��������");
				flag=true;
			}
		}
		
		return flag;
	}

}
