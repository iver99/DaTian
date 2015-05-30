package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Companycertificate;

/**
 * 
 * @author RussWest0
 *
 */
public interface CompanycertificateService {
	
	public boolean validateCompany(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName);
	public Companycertificate getCompanycertificate(String companyId);
	public boolean companycertificateUpdate(String userId, String companyName,
			String divisionCode, String legalName, String legalIDCard,
			String companyAddr, String companyType, String companyScale,
			String invoiceKind, String serviceIndustry, String businessKind,
			String companyContact, String phone, String basicSituation,
			String path, String fileName);
}
