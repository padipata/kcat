package dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mapper.FirstMapper;
import model.First;
import model.Pager;
@Component
public class FirstDAO {
	FirstMapper firstMapper;

	public FirstMapper getFirstMapper() {
		return firstMapper;
	}
	@Resource
	public void setFirstMapper(FirstMapper firstMapper) {
		this.firstMapper = firstMapper;
	}
	//����û���������
	public ArrayList<First> login(First first){
		ArrayList<First> list=firstMapper.login(first);
		return list;
	}
	//����û���
	public ArrayList<First> checkUser(First first){
		ArrayList<First> list=firstMapper.checkUser(first);
		return list;
	}
	//����û�
	public void addUser(First first){
		firstMapper.addUser(first);
	}
	
	//��ѯָ���������û�����
	public ArrayList<First> getPartUser(Pager pager){
		return firstMapper.getPartUser(pager);
	}
	//ɾ��ָ��id���û�����
	public void deleteUser(int id){
		System.out.println("����dao���idΪ:"+id);
		firstMapper.deleteUser(id);
	}
	//����id�޸��û�����	
	public void modifyUser(First first){
		firstMapper.modifyUser(first);
	}
	//����id��ѯ�û�����
	public First findUserById(int id){
		return firstMapper.findUserById(id);
	}

	//��ȡ�����û���Ϣ
	public ArrayList<First> getAllUser(){
		return firstMapper.getAllUser();
	}
	
}
