package com.lrn.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lrn.model.hibernate.module.Module;

public class ModuleDaoTest extends BaseDaoTestCase {
    
	private Log logger = LogFactory.getLog(ModuleDaoTest.class);

	@Autowired
    private IModuleDao dao;

    @Test
    public void testAddAndRemoveRole() throws Exception {
    	Module model = new Module();
    	model.setBaseCatalogId("bscatID1");
    	model.setCreated(new Date());
    	model = dao.save(model);
//        flush();
        
        Long modelId = model.getId();
        logger.debug("modelId >> " + modelId);
        Module savedModel = dao.get(modelId);
        assertNotNull(savedModel.getBaseCatalogId());

        dao.remove(modelId);
//        flush();

        Module removedModel = null;
        try{
        	removedModel = dao.get(modelId);
        }catch (Exception exception) {
			logger.debug("throwing exception message is " + exception.getMessage());
		}
        assertNull(removedModel);
    }
    
    public static Module getModel(String name) {
    	Module model = new Module();
    	model.setBaseCatalogId(name);
    	model.setCreated(new Date());
    	return model;
    }
}
