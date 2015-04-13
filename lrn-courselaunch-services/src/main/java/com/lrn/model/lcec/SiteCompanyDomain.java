package com.lrn.model.lcec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@NamedQueries( {
	@NamedQuery(name = "findDomainByCompanyGroupId",
			query = "from SiteCompanyDomain s where s.site = :group_id")
})
@Entity
@Table(name="SITE_COMPANYDOMAIN")
public class SiteCompanyDomain {
	
    private static final long serialVersionUID = 6366423552206963996L;

   @Id
    @Column(name="GROUP_ID")
    private String site;
    
    @Column(name="DOMAIN")
    private String domain;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}