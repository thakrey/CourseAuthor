package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.RsaKeys;

/**
 * Interface IRsaKeysDao
 *
 * @author kishor.pawar
 */
public interface IRsaKeysDao extends IGenericDao<RsaKeys, Long> {
	
	/**
     * Gets list of RsaKeys by siteId and RsaKeys Type
     *
     * @param Long siteId
     * @param String type
     * 
     * @return List<RsaKeys>
     */
	List<RsaKeys> getRsaKeysBySiteIdAndType(Long siteId, String type);
}