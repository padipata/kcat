package mapper;

import java.util.ArrayList;

import model.StudySoft;
import model.StudySoft_titleB;
import model.StudySoft_titleS;

public interface StudySoftMapper {
	public ArrayList<StudySoft_titleB> getStudySoftB();
	public ArrayList<StudySoft_titleS> getStudySoftS(int tidB);
	public ArrayList<StudySoft> getStudySoft(int tidS);
	public ArrayList<StudySoft> getStudySoft_All(int id);   //ͨ��idѰ�Ҹ�������������Ϣ
	public ArrayList<StudySoft> getStudySoft_id(String name);   //ͨ���������ֲ��Ҹ���������Ϣ
}