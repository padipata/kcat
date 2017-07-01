package dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mapper.TelMapper;
import model.Tel;

@Component
public class TelDAO {
	TelMapper telMapper;
	
	public TelMapper getTelMapper() {
		return telMapper;
	}

	@Resource
	public void setTelMapper(TelMapper telMapper) {
		this.telMapper = telMapper;
	}

	//��ȡ����������Ϣ
	public ArrayList<Tel> getTel(){
		return telMapper.getTel();
	}
}
