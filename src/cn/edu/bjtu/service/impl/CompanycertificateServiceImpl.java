package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.service.CompanycertificateService;
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
	
	
	@Override
	public boolean validateCompany(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName){
		return companycertificateDao.validateCompany(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation, path, fileName);
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
