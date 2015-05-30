package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Companycertificate;

/**
 * 
 * @author RussWest0
 *
 */
public interface CompanycertificateDao extends BaseDao<Companycertificate>{
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
