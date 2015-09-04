package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Repository
/**
 * 客户dao层实现
 * @author RussWest0
 *
 */
public class ClientDaoImpl extends BaseDaoImpl<Clientinfo> implements ClientDao {

	@Autowired
	UserinfoDao userinfoDao;


	@Override
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex, String path, String fileName) {
		
		Clientinfo clientInfo = this.get(Clientinfo.class, userId);
		if (clientInfo == null) {// clientinfo找不到记录
			return false;
		}

		clientInfo.setRealName(realName);
		clientInfo.setPhone(phone);
		clientInfo.setIdcard(IDCard);
		clientInfo.setSex(sex);
		this.update(clientInfo);
		Userinfo userInfo = userinfoDao.get(Userinfo.class, userId);
		userInfo.setStatus("审核中");
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientInfo.setIDPicture(fileLocation);//设置文件上传路径
		}
		userinfoDao.update(userInfo);

		// }

		return true;
	}

}
