package com.lrn.dao;

import com.lrn.model.lcec.SiteCompanyDomain;

public interface ISiteCompanyDomainDao {
		SiteCompanyDomain getCompanyDomainByCompanyGroupId(String companyGroupId);
}
