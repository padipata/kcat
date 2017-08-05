package com.kcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author leeyubin
 *
 */

public class TmDownImgUtil {
	/**
	 * ������ַ��ȡ��վԴ��
	 * @param link
	 * @param encoding
	 * @return
	 */
	public static String htmlSource(String link,String encoding){
		StringBuilder stringBuilder=new StringBuilder();
		try {
			URL url =new URL(link);   //��ȡ�������
			URLConnection uc=url.openConnection();   //������������  
			uc.setRequestProperty("User-Agent", "java");   //αװ
			InputStream inputStream=uc.getInputStream();  //��ȡ�ļ�������
			InputStreamReader in=new InputStreamReader(inputStream,encoding); //����io������
			BufferedReader reader=new BufferedReader(in);   //���ش��뻺����
			
			//��ʼ����Դ��
			//����һ����ʱ�ļ� 
			String line=null;
			//ѭ��
			while((line=reader.readLine())!=null){
				stringBuilder.append(line+"\r\n");
			}
			
			//�ر�
			reader.close();
			in.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		return stringBuilder.toString();
	}
	
}
