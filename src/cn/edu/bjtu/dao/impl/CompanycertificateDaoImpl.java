package cn.edu.bjtu.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.dao.RegisterDao;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;

@Repository
/**
 * 客户dao层实现
 * @author RussWest0
 *
 */
public class CompanycertificateDaoImpl extends BaseDaoImpl<Companycertificate> implements CompanycertificateDao {

	@Resource
	HibernateTemplate ht;
	
	@Autowired
	
	/*@Resource
	BaseDao baseDao;*/
	/*@Autowired
	ClientDao clientDao;*/
	/*@Resource
	Companycertificate companycertificate;*/
	@Resource
	RegisterDao registerDao; 
	
	@Deprecated
	@Override
	public boolean validateCompany(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName){
		
		
		return true;
	}

	@Override
	public Companycertificate getCompanycertificate(String companyId){
		return ht.get(Companycertificate.class, companyId);
	}

	@Override
	public boolean companycertificateUpdate(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName) {
		
		Companycertificate companycertificate=new Companycertificate();
		companycertificate = getCompanycertificate(userId);// 根据id查找到车辆信息
		companycertificate.setCompanyName(companyName);	
		companycertificate.setDivisionCode(divisionCode);
		companycertificate.setLegalName(legalName);
		companycertificate.setLegalIDCard(legalIDCard);
		companycertificate.setCompanyAddr(companyAddr);
		companycertificate.setCompanyType(companyType);
		companycertificate.setCompanyScale(companyScale);
		companycertificate.setInvoiceKind(invoiceKind);
		companycertificate.setServiceIndustry(serviceIndustry);
		companycertificate.setBusinessKind(businessKind);
		companycertificate.setCompanyContact(companyContact);
		companycertificate.setPhone(phone);
		companycertificate.setBasicSituation(basicSituation);
		// 保存文件路径
				if (path != null && fileName != null) {
					String fileLocation = path + "//" + fileName;
					companycertificate.setRelatedMaterial(fileLocation);
				}
		/*baseDao.update(clientInfo);*/
		this.update(companycertificate);
		
		Userinfo userInfo=ht.get(Userinfo.class, userId);
		userInfo.setStatus("审核中");
		/*baseDao.update(userInfo);*/
		registerDao.update(userInfo);
		
		return true;
	}
}
