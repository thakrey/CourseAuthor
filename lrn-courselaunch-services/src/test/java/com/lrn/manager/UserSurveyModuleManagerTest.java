package com.lrn.manager;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lrn.manager.user.IUserSurveyModuleManager;
import com.lrn.model.hibernate.user.UserSurveyModule;

//@ContextConfiguration(locations = { "file:/src/main/resources/application-context-resources.xml" })
@ContextConfiguration(
        locations = {"classpath*:/resources/application-context-resources.xml",
                "classpath*:/resources/application-context-dao.xml",
                "classpath*:/resources/application-context-manager.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSurveyModuleManagerTest extends BaseManagerTestCase {
    
	private Log logger = LogFactory.getLog(UserSurveyModuleManagerTest.class);
    
	@Autowired
    private IUserSurveyModuleManager manager;

    @Test
    public void testAddAndRemoveRole() throws Exception {
    	UserSurveyModule model = new UserSurveyModule();
    	model.setCatalogId("catalogID1");
    	model.setSiteId(188l);
    	model.setUserSurveyId(1l);
    	logger.debug("saving model: " + model);
    	UserSurveyModule dbModel = manager.save(model);
    	
        assertEquals("catalogID1", dbModel.getCatalogId());
//        role = dao.getRoleByName("testrole");
//        assertNotNull(role.getDescription());
//
//        dao.removeRole("testrole");
//        flush();
//
//        role = dao.getRoleByName("testrole");
//        assertNull(role);
    }
}
