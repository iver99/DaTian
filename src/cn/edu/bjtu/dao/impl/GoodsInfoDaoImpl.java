package cn.edu.bjtu.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.GoodsClientViewDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.ResponseDao;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Response;

@Repository
public class GoodsInfoDaoImpl extends BaseDaoImpl<Goodsform> implements GoodsInfoDao {

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private ResponseDao responseDao;
	@Autowired
	GoodsClientViewDao goodsClientViewDao;

	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		

		return goodsClientViewDao.get(GoodsClientView.class, id);

	}

	/**
	 * 根据id得到货物
	 */
	@Override
	public Goodsform getMyGoodsDetail(String id) {

		return this.get(Goodsform.class, id);

	}


	@Override
	/**
	 * 提交反馈Dao
	 */
	public boolean commitResponse(String goodsId, String remarks, String userId,String path,String fileName) {
		
		Goodsform goods = this.get(Goodsform.class, goodsId);
		String clientId="";
		String committer="";
		String phone="";
		if(goods!=null){
			clientId=goods.getClientId();
		}
		Carrierinfo carrier=companyDao.getCarrierInfo(userId);
		if(carrier!=null){
			committer=carrier.getCompanyContact();
			phone=carrier.getPhone();
		}
		//goods.setRemarks(remarks);
		int feedBackQuantity=goods.getFeedbackQuantity();
		feedBackQuantity++;//反馈数量加1
		goods.setFeedbackQuantity(feedBackQuantity);
		this.update(goods);
		//此处还需要记录到反馈表中
		Response response=new Response();
		response.setId(IdCreator.createResponseId());
		response.setCarrierId(userId);
		response.setClientId(clientId);
		response.setCommitter(committer);
		response.setGoodsId(goodsId);
		response.setPhone(phone);
		response.setRemarks(remarks);
		response.setRelDate(new Date());
		response.setStatus("待确认");//add by RussWest0 at 2015年6月6日,下午3:07:08 
		// 保存文件路径
				if (path != null && fileName != null) {
					String fileLocation = path + "//" + fileName;
					response.setRelatedMaterial(fileLocation);
				}
		//保存反馈信息
		responseDao.save(response);
		
		return true;
	}


	@Override
	public boolean deleteGoods(String id) {

		Goodsform goodsform = this.get(Goodsform.class, id);
		this.delete(goodsform);
		return true;
	}

}
