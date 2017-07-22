package dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import mapper.BangMapper;
import model.Bang;
import model.BangTitle;


@Component
public class BangDAO {
	BangMapper bangMapper;

	public BangMapper getBangMapper() {
		return bangMapper;
	}
	@Resource
	public void setBangMapper(BangMapper bangMapper) {
		this.bangMapper = bangMapper;
	}
	//����id��ȡ��ģ������
	public ArrayList<Bang> getBang(int tid) throws IOException{
		return bangMapper.getBang(tid);
	}
	//��ȡ��������
	public ArrayList<BangTitle> getTitle(){
		return bangMapper.getTitle();
	}
}
