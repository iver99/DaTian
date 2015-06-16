package cn.edu.bjtu.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.ResponseDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Response;

@Repository
public class GoodsInfoDaoImpl extends BaseDaoImpl<Goodsform> implements GoodsInfoDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private ResponseDao responseDao;

	/*@Resource
	private BaseDao baseDao;*/
	/*@Autowired
	GoodsInfoDao goodsInfoDao;*/


	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		// TODO Auto-generated method stub

		return ht.get(GoodsClientView.class, id);

	}

	@Override
	public Goodsform getMyGoodsDetail(String id) {
		// TODO Auto-generated method stub

		return this.get(Goodsform.class, id);

	}

	@Override
	@Deprecated
	public List getSelectedGoodsInfo(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);// Dao层分页函数提取到此方法
	}

	@Override
	/**
	 * 提交反馈Dao
	 */
	public boolean commitResponse(String goodsId, String remarks, String userId,String path,String fileName) {
		// TODO Auto-generated method stub
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
	public List getAllResponse(String carrierId) {
		// TODO Auto-generated method stub
		//return ht.find("from Goodsform where clientId='" + carrierId + "'");
		return this.find("from GoodsResponseView where carrierId='"+carrierId+"'");
	}

	@Override
	public List getUserGoodsInfo(String clientId) {
		// TODO Auto-generated method stub
		return ht.find("from Goodsform where clientId='" + clientId + "'");
	}

	@Override
	public boolean deleteGoods(String id) {

		Goodsform goodsform = ht.get(Goodsform.class, id);
		this.delete(goodsform);
		return true;
	}

}
