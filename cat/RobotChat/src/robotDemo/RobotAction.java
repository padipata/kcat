package robotDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������Ϣ������
 * @author liyb
 *
 */

@WebServlet("/robot")
public class RobotAction extends HttpServlet{
	public static final String APIKEY="857532846c5349939e6a0c70be75b6b3";
	public static final String url="http://www.tuling123.com/openapi/api?key=";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String text=req.getParameter("text");
		String result=getResult(text);
		resp.getWriter().print(result);
	}
	
	public static String getResult(String text){
		String INFO="";
		StringBuilder sb=new StringBuilder();
		
		try {
			INFO=URLEncoder.encode(text,"UTF-8");
			String getUrl=url+APIKEY+"&info="+INFO;
			URL queryUrl=new URL(getUrl);
			URLConnection connection=queryUrl.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String temp="";
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}
	
}
