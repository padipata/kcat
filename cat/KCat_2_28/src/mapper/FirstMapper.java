package mapper;

import java.util.ArrayList;

import model.First;
import model.Pager;

public interface FirstMapper {
	public ArrayList<First> login(First first);
	public ArrayList<First> checkUser(First first);
	public void addUser(First first);
	public ArrayList<First> getPartUser(Pager pager);
	public void deleteUser(int id);   //����idɾ���û�
	public void modifyUser(First first);   //�޸�ָ��id���û���Ϣ
	public First findUserById(int id);   //����id��ѯ�û�����
	public ArrayList<First> getAllUser(); //��ȡ�����û���Ϣ
	public void modifyPwd(First first); //�޸��û�����
	public ArrayList<First> admin_login(First first);//����Ա��¼
	
}
