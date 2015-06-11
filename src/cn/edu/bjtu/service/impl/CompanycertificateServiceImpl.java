package cn.edu.bjtu.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.service.CompanycertificateService;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Companycertificate;
/**
 * client服务层实现
 * @author RussWest0
 *
 */
@Service
@Transactional
public class CompanycertificateServiceImpl implements CompanycertificateService{

	@Autowired	
	CompanycertificateDao companycertificateDao;
	
	@Autowired
	CompanyDao companyDao;
	
	
	@Override
	public boolean validateCompany(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName){
		
		//更新carrierinfo  add by RussWest0 at 2015年6月6日,下午2:49:21 
		Carrierinfo carrierinfo=companyDao.get(Carrierinfo.class, userId);
		
		//carrierinfo.setCity(city);
		//carrierinfo.setCompanyAccount(companyAccount);
		carrierinfo.setCompanyAddr(companyAddr);
		carrierinfo.setCompanyContact(companyContact);
		carrierinfo.setCompanyName(companyName);
		carrierinfo.setCompanyScale(companyScale);
		carrierinfo.setCompanyType(companyType);
//		carrierinfo.setCreditRate(creditRate);
//		carrierinfo.setDepositCondition(depositCondition);
//		carrierinfo.setId(id);
//		carrierinfo.setInvoiceKind(invoiceKind);
//		carrierinfo.setLine(line);
		carrierinfo.setPhone(phone);
		carrierinfo.setRelDate(new Date());
//		carrierinfo.setRemarks(remarks);
//		carrierinfo.setResourceRate(resourceRate);
		carrierinfo.setServiceIndustry(serviceIndustry);
//		carrierinfo.setStatus(status);
//		carrierinfo.setWarehouse(warehouse);
		
		companyDao.update(carrierinfo);
		
		
		//更新certificate表
		companycertificateDao.validateCompany(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation, path, fileName);
		
		return true;
	}
	
	@Override
	public Companycertificate getCompanycertificate(String companyId){
		return companycertificateDao.getCompanycertificate(companyId);
	}

	@Override
	public boolean companycertificateUpdate(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName) {
		return companycertificateDao.companycertificateUpdate(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation, path, fileName);
	}
	
}
