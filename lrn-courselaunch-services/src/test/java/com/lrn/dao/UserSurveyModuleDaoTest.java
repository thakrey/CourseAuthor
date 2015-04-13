package com.lrn.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lrn.dao.user.IUserSurveyModuleDao;
import com.lrn.model.hibernate.user.UserSurveyModule;

public class UserSurveyModuleDaoTest extends BaseDaoTestCase {
    
	private Log logger = LogFactory.getLog(UserSurveyModuleDaoTest.class);

	@Autowired
    private IUserSurveyModuleDao dao;

    @Test
    public void testAddAndRemoveRole() throws Exception {
    	UserSurveyModule model = new UserSurveyModule();
    	model.setCatalogId("catalogID1");
    	model.setSiteId(188l);
    	model.setUserSurveyId(1l);
    	model = dao.save(model);
//        flush();
        
        Long modelId = model.getId();
        logger.debug("modelId >> " + modelId);
        UserSurveyModule savedModel = dao.get(modelId);
        assertNotNull(savedModel.getCatalogId());

        dao.remove(modelId);
//        flush();

        UserSurveyModule removedModel = null;
        try{
        	removedModel = dao.get(modelId);
        }catch (Exception exception) {
			logger.debug("throwing exception message is " + exception.getMessage());
		}
        assertNull(removedModel);
    }
}
