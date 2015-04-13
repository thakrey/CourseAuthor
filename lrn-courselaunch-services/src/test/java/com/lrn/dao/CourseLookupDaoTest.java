package com.lrn.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lrn.model.hibernate.CourseLookup;
import com.lrn.model.hibernate.module.Module;

public class CourseLookupDaoTest extends BaseDaoTestCase {
    
	private Log logger = LogFactory.getLog(CourseLookupDaoTest.class);

	@Autowired
    private ICourseLookupDao dao;
	
	@Autowired
    private IModuleDao moduleDao;

    @Test
    public void testAddAndRemoveRole() throws Exception {
    	Module module = moduleDao.save(ModuleDaoTest.getModel("bscatID1"));
    	CourseLookup model = dao.save(getModel("stest1", module));
//        flush();
        
        String systemId = model.getSystemId();
        logger.debug("systemId >> " + systemId);
        CourseLookup savedModel = dao.get(systemId);
        assertNotNull(savedModel.getSystemId());

        dao.remove(systemId);
        moduleDao.remove(module.getId());
//        flush();

        CourseLookup removedModel = null;
        try{
        	removedModel = dao.get(systemId);
        }catch (Exception exception) {
			logger.debug("throwing exception message is " + exception.getMessage());
		}
        assertNull(removedModel);
    }
    
    @Test
	public void testGetCourseLookupByCatalogId() {
    	Module module = moduleDao.save(ModuleDaoTest.getModel("bscatID1"));
//    	flush();
		CourseLookup model = getModel("stest1", module);
		List<CourseLookup> beforeModels = 
				dao.getCourseLookupByCatalogId(model.getCatalogId());
		model = dao.save(model);
//		flush();
		List<CourseLookup> afterModels = 
			dao.getCourseLookupByCatalogId(model.getCatalogId());
        
		if(null != beforeModels && beforeModels.size() > 0){
			assertTrue(afterModels.size() - 1 == afterModels.size());
		} else {
			assertTrue(afterModels.size() == 1);
		}
		dao.remove(model.getSystemId());
        moduleDao.remove(module.getId());
//        flush();
	}
    
    public static CourseLookup getModel(String name, Module module) {
    	CourseLookup model = new CourseLookup();
    	model.setAppType("app1");
    	model.setAvailability(1l);
    	model.setCatalogId("c1");
    	model.setContentSize(12l);
    	model.setCopyrightYear(2014l);
    	model.setCoreVendor("cv");
    	model.setCourseImgUrl("url");
    	model.setCoursePath("path");
    	model.setCourseShortName("short name");
    	model.setCreated(new Date());
    	model.setDescription("des");
    	model.setDocuments("documents");
    	model.setEditionId(1l);
    	model.setIsLibrary(1l);
    	model.setLanguage("en");    	
    	model.setModule(module);
    	model.setRecordQuiz(1l);
    	model.setSystemId(name);
    	model.setTemplates("templates");
    	model.setTitle("title");
    	model.setUpdated(new Date());
    	model.setVendor("vendor");
    	model.setVersion("veriosn");
    	return model;
    }
}
