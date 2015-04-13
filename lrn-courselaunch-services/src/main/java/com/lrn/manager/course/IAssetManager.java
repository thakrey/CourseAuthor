/**
 * 
 */
package com.lrn.manager.course;


import com.lrn.manager.IGenericManager;
import com.lrn.model.course.Asset;



public interface IAssetManager extends IGenericManager<Asset, Long> {
	public String getMaxCreatedDate(Long siteId);
}
