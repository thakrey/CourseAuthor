/*package com.lrn.adapter.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import com.lrn.adapter.IExportAdapter;
import com.lrn.manager.ICourseLookupManager;
import com.lrn.manager.site.ISiteBaseCatalogConfigsManager;
import com.lrn.manager.site.ISiteManager;
import com.lrn.model.hibernate.CourseLookup;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.site.SiteBaseCatalogConfigs;
import com.lrn.model.spring.service.response.export.ExportCourseDTO;
import com.lrn.util.ExportConstants;
import com.lrn.util.ZipUtil;

*//**
 * The Class ExportAdapter.
 * 
 *//*
public class ExportAdapter implements IExportAdapter {

	private static final Logger logger = Logger.getLogger(ExportAdapter.class);
	
	private ISiteManager 					siteManager;
	
	private ICourseLookupManager 			courseLookupManager;
	
	private ISiteBaseCatalogConfigsManager 	siteBaseCatalogConfigsManager;
	
	*//** Export folder path. *//*
	private String exportZipFolderPath;
	
	*//** Repository path where 2acontent and 2acommon are stored. *//*
	private String repoPath;
	
	*//** LMS branch name from where scrom xsd files will be copied. *//*
	private String lmsBranchName;
	
	*//** Export folder name. *//*
	private String exportZipFolderName;
	
	*//** Content base path. *//*
	private String contentBasePath;
	
	*//** Common base path. *//*
	private String commonBasePath;
	
	*//** LMS base path. *//*
	private String lmsBasePath;
	
	*//**
	 * @param siteManager the siteManager to set
	 *//*
	public void setSiteManager(ISiteManager siteManager) {
		this.siteManager = siteManager;
	}

	*//**
	 * @param courseLookupManager the courseLookupManager to set
	 *//*
	public void setCourseLookupManager(ICourseLookupManager courseLookupManager) {
		this.courseLookupManager = courseLookupManager;
	}

	*//**
	 * @param siteBaseCatalogConfigsManager the siteBaseCatalogConfigsManager to set
	 *//*
	public void setSiteBaseCatalogConfigsManager(
			ISiteBaseCatalogConfigsManager siteBaseCatalogConfigsManager) {
		this.siteBaseCatalogConfigsManager = siteBaseCatalogConfigsManager;
	}

	*//**
	 * @param exportZipFolderPath the exportZipFolderPath to set
	 *//*
	public void setExportZipFolderPath(String exportZipFolderPath) {
		this.exportZipFolderPath = exportZipFolderPath;
	}

	*//**
	 * @param repoPath the repoPath to set
	 *//*
	public void setRepoPath(String repoPath) {
		this.repoPath = repoPath;
	}

	*//**
	 * @param lmsBranchName the lmsBranchName to set
	 *//*
	public void setLmsBranchName(String lmsBranchName) {
		this.lmsBranchName = lmsBranchName;
	}

	*//**
	 * @param exportZipFolderName the exportZipFolderName to set
	 *//*
	public void setExportZipFolderName(String exportZipFolderName) {
		this.exportZipFolderName = exportZipFolderName;
	}

	*//**
	 * @param contentBasePath the contentBasePath to set
	 *//*
	public void setContentBasePath(String contentBasePath) {
		this.contentBasePath = contentBasePath;
	}

	*//**
	 * @param commonBasePath the commonBasePath to set
	 *//*
	public void setCommonBasePath(String commonBasePath) {
		this.commonBasePath = commonBasePath;
	}

	*//**
	 * @param lmsBasePath the lmsBasePath to set
	 *//*
	public void setLmsBasePath(String lmsBasePath) {
		this.lmsBasePath = lmsBasePath;
	}
	
	@Override
	public ExportCourseDTO exportCourse(Long siteId, String systemId,
			String courseType) throws Exception {
		ExportCourseDTO exportCourseDTO = new ExportCourseDTO();
		logger.debug("Start of exporting a course...");
		Site site = siteManager.get(siteId);
		CourseLookup courseLookup = courseLookupManager.get(systemId);
		logger.debug("site name>> " + site.getName());
		if(courseLookup != null) {
			String siteName = site.getName();
			String catalogId = courseLookup.getCatalogId();
			logger.debug("course catalogId>> " + catalogId);
			StringBuilder relativeZipUrl = new StringBuilder();
			relativeZipUrl.append(exportZipFolderName).append("/").append(siteName);
			relativeZipUrl.append("/").append(catalogId).append(".zip");
			exportCourseDTO.setCourseUrl(relativeZipUrl.toString());
			
			//Following code is to get the size of the file
			StringBuilder outputZipFileBuilder = new StringBuilder();
			outputZipFileBuilder.append(exportZipFolderPath).append(siteName);
			outputZipFileBuilder.append("/").append(catalogId).append(".zip");			
			File zipFile = new File(outputZipFileBuilder.toString());
	    	double courseSize = zipFile.length() / (1024*1024);;
	    	exportCourseDTO.setCourseSize(courseSize);
		}
		return exportCourseDTO;
	}

	@Override
	public File compressCourse(Long siteId, String systemId,
			String courseType) throws Exception {
		logger.debug("Start of compressing a course...");
		Site site = siteManager.get(siteId);
		CourseLookup courseLookup = courseLookupManager.get(systemId);
		logger.debug("site name>> " + site.getName());
		if(courseLookup != null) {
			String siteName = site.getName();
			String catalogId = courseLookup.getCatalogId();
			logger.debug("course catalogId>> " + catalogId);
			String courseName = catalogId.substring(0, catalogId.indexOf("-"));
			logger.debug("courseName>>>" + courseName);
			StringBuilder outputZipFileBuilder = new StringBuilder();
			outputZipFileBuilder.append(exportZipFolderPath).append(siteName);
			outputZipFileBuilder.append("/").append(catalogId).append(".zip");
			logger.debug("Export course absolute path>>>" + 
					outputZipFileBuilder.toString());
			File zipSiteFolder = new File(exportZipFolderPath + siteName);
			if(!zipSiteFolder.isDirectory()) {
				zipSiteFolder.mkdirs();
				logger.debug("Zip site folder>>>> " + zipSiteFolder.getAbsolutePath());
			}
			zipIt(outputZipFileBuilder.toString(), courseName, courseLookup, 
					siteName, siteId);
			File zipFile = new File(outputZipFileBuilder.toString());
			logger.debug("Done with compressing a course...");
	    	return zipFile;
		}
		return null;
	}

	*//**
     * Considers all required files and creates ZIP file from those files.
     * This is only for SCORM course folder structure.
	 * 
     * @param String zipFile
     * @param String courseName
     * @param CourseLookup courseLookup
     * @param String siteName
     * @param Long siteId 
     *  
	 * @throws Exception 
     *//*
	private void zipIt(String zipFile, String courseName,
			CourseLookup courseLookup, String siteName, 
			Long siteId) throws Exception {
		byte[] buffer = new byte[2048];
		logger.debug("Inside zipit method... ");
		FileOutputStream fos = new FileOutputStream(zipFile);
		ZipOutputStream zos = new ZipOutputStream(fos);
		List<String> zipFileList = new ArrayList<String>();
		Map<String, List<String>> sourceFileListMap = getSourceFileListMap();
		logger.debug("Start of processing course > content folder..");
		processContentFiles(courseName, courseLookup, zipFileList,
				sourceFileListMap, zos, buffer);
		logger.debug("End of processing course > content folder..");
		String webContentPath = commonBasePath + ExportConstants.FLUIDX_WEB_CONTENT_PATH;
		logger.debug("commonBasePath:::::::::::::"+commonBasePath);
		logger.debug("commonBasePath:::commonBasePath:::::::::::::"+webContentPath);
		logger.debug("Start of processing course > player folder..");
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_PLAYER), webContentPath + "player/", 
				"player/", zos, buffer);
		logger.debug("End of processing course > player folder..");
		//AS of now for testing purpose we are putting sitename as "lrnmodules"
		siteName = "lrnmodules";
		String sitePath = webContentPath + "sites/" + siteName;
		logger.debug("Start of processing course > Site folder..");
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_SITE),	sitePath, "sites/" + siteName, 
				zos, buffer);
		logger.debug("End of processing course > site folder..");
		logger.debug("Start of processing course > ui folder..");
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_UI), webContentPath + "ui/", "ui/", zos, buffer);
		logger.debug("End of processing course > ui folder..");
		logger.debug("Start of processing course root folder xml files..");
		processXmlFiles(courseLookup, zipFileList, sourceFileListMap, zos, buffer);  
		Map<String, Boolean> neglectFileMap = new HashMap<String, Boolean>();
		neglectFileMap.put("config.js", true);
		ZipUtil.generateFileListNonRecursive(sourceFileListMap.get(
    			ExportConstants.LIST_CONTENT_ROOT), webContentPath);
    	ZipUtil.addFileZipEntryAndWriteToZipSteam(zipFileList, 
    			sourceFileListMap.get(ExportConstants.LIST_CONTENT_ROOT), "", 
				webContentPath, zos, buffer, neglectFileMap);
    	logger.debug("End of processing course root folder xml files..");
    	logger.debug("Start of creating license file and zip process of same..");
		File licenseFile = createLicenseFile(null);
		zipFileList.add(licenseFile.getName());
		ZipUtil.addFileZipEntryAndWriteToZipSteam(licenseFile.getName(), 
				licenseFile.getAbsolutePath(), zos, buffer);
		logger.debug("End of creating license file and zip process of same..");
		
		logger.debug("Start of creating config file file and zip process of same..");
		File configFile = createConfigFile(courseName, courseLookup.getLanguage(),
				courseLookup.getCatalogId());
		ZipUtil.addFileZipEntryAndWriteToZipSteam(configFile.getName(), 
				configFile.getAbsolutePath(), zos, buffer);
		zipFileList.add(configFile.getName());
		logger.debug("End of creating config file file and zip process of same..");
		
		logger.debug("Start of creating manifest file and zip process of same..");
		Map<String, String> mfstParamMap = new HashMap<String, String>();
		mfstParamMap.put("title", courseLookup.getTitle());
		String masterScore = getMasterScore(siteId, courseLookup);
		if(masterScore == null) {
			masterScore = "0";
		}
		mfstParamMap.put("score", masterScore);
		File imsmanifestTemplateFile = createManiFestTemplateFile(mfstParamMap, 
				zipFileList);
		ZipUtil.addFileZipEntryAndWriteToZipSteam(imsmanifestTemplateFile.getName(), 
				imsmanifestTemplateFile.getAbsolutePath(), zos, buffer);
		logger.debug("End of creating manifest file and zip process of same..");
				
		zos.closeEntry();
    	//remember close it
    	zos.close();
    	//Start of deleting temporary folder after exporting course folder.
    	File delFile = new File(exportZipFolderPath);
    	for (File file: delFile.listFiles()) {
            file.delete();
        }
    	//End of deleting temporary folder after exporting course folder.
    	logger.debug("Export Done.....");
    }
	
	*//**
     * Fetches masterScore from database table.
	 * 
     * @param Long siteId
     * @param CourseLookup courseLookup
     *  
	 * @return String masterScore
     *//*
	private String getMasterScore(Long siteId, CourseLookup courseLookup) {
		List<SiteBaseCatalogConfigs> catalogConfigs = 
			new ArrayList<SiteBaseCatalogConfigs>();
		String baseCatalogId = courseLookup.getModule().getBaseCatalogId();
		catalogConfigs = 
			siteBaseCatalogConfigsManager.getConfigsByBaseCatalogIdAndSiteIdAndKey(
					siteId, baseCatalogId, "quiz_mastery");
		if(catalogConfigs != null && catalogConfigs.size() > 0) {
			return catalogConfigs.get(0).getConfigValue();
		}
		// TODO Auto-generated method stub
		return null;
	}

	*//**
     * Processes XML and XSD files at course root folder. 
     * 
     * @param CourseLookup courseLookup
     * @param List<String> zipFileList
     * @param Map<String, List<String>> sourceFileListMap
     * @param ZipOutputStream zos
     * @param byte[] buffer
     * 
     * @throws Exception
     *//*
	private void processXmlFiles(CourseLookup courseLookup,
			List<String> zipFileList,
			Map<String, List<String>> sourceFileListMap, 
			ZipOutputStream zos,
			byte[] buffer) throws Exception {
		logger.debug("inside process xml files");
		StringBuilder xmlPath = new StringBuilder();
		xmlPath.append(lmsBasePath);
		xmlPath.append(lmsBranchName).append("/xml/SCORM12");
		List<String> rootXmlFolderFiles = sourceFileListMap.get(
				ExportConstants.LIST_CONTENT_ROOT_XML);
		ZipUtil.generateFileList(rootXmlFolderFiles, 
    			new File(xmlPath.toString()), xmlPath.toString());
    	
		for(String file : rootXmlFolderFiles) {
			if(!file.endsWith("html") && 
					!file.contains("imsmanifest_template.xml")) {
				logger.debug("XML File Added : " + file);
				zipFileList.add(file);
				String filePath = xmlPath.toString() + File.separator + file;    				
        		ZipUtil.addFileZipEntryAndWriteToZipSteam(file, filePath, 
        				zos, buffer);
			}
		}
	}

	*//**
     * Processes course > content folder. 
     * 
     * @param String courseName
     * @param CourseLookup courseLookup
     * @param List<String> zipFileList
     * @param Map<String, List<String>> sourceFileListMap
     * @param ZipOutputStream zos
     * @param byte[] buffer
     * 
     * @throws Exception
     *//*
	private void processContentFiles(String courseName,
			CourseLookup courseLookup, List<String> zipFileList,
			Map<String, List<String>> sourceFileListMap, ZipOutputStream zos,
			byte[] buffer) throws Exception {
		logger.debug("Start of processing content folder of course...");
		logger.debug("Start of processing course content folder..");
		logger.debug("processContenFiles repo>>> " + repoPath);
		logger.debug("processContenFiles lmsBasePath>>> " + lmsBasePath);
		logger.debug("processContenFiles contentBasePath>>> " + contentBasePath);
		logger.debug("processContenFiles commonBasePath>>> " + commonBasePath);
		String language = courseLookup.getLanguage();
		String contentPath = contentBasePath;
		logger.debug("contentPath>> " + contentPath);
		String sourceContentFilePath = contentPath + courseLookup.getCoursePath();
		logger.debug("processContent sourceContentFilePath>>" + sourceContentFilePath);
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_CONTENT_FILE),	sourceContentFilePath, 
				"content/" + courseLookup.getCoursePath(), zos, buffer);    		
		StringBuilder contentMedia = new StringBuilder(); 
		contentMedia.append(contentPath).append(courseName).append("/");
		contentMedia.append(language).append("/media");
		logger.debug("Start of processing course media folder..");
		logger.debug("processContent contentMedia>> " + contentMedia.toString());
		StringBuilder zipMediaPath = new StringBuilder();
		zipMediaPath.append("content/").append(courseName).append("/");
		zipMediaPath.append(language).append("/media/");
		logger.debug("processContent zipMediaPath>> " + zipMediaPath.toString());
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_CONTENT_LANG_MEDIA), contentMedia.toString(), 
				zipMediaPath.toString(), zos, buffer);    		
		String mediaPath = contentPath + courseName + "/media";
		logger.debug("Start of processing media folder..");
		logger.debug("processContent mediaPath>> " + mediaPath);
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_CONTENT_MEDIA), mediaPath, 
				"content/" + courseName + "/media/", zos, buffer);    		
		String FusionPlusPath = contentPath + courseName + "/FusionPlus";
		logger.debug("Start of processing Fusion Plus folder..");
		logger.debug("processContent mediaPath>> " + mediaPath);
		ZipUtil.processZipFiles(zipFileList, sourceFileListMap.get(
				ExportConstants.LIST_CONTENT_FUSION_PLUS), FusionPlusPath, 
				"content/" + courseName + "/FusionPlus/", zos, buffer);
		logger.debug("End of processing content folder of course...");
	}

	*//**
     * Creates configuration file which has pointer to different configuration parameter in it. 
     * 
	 * @param Map<String, String> paramMap  
     * @param List<String> zipFileList
     * 
     * @throws IOException
     *//*
	private File createConfigFile(String courseName, String language, String catalogId) 
			throws IOException {
    	File configFile = new File(exportZipFolderPath + "config.js");
		if (!configFile.exists()) {
			configFile.createNewFile();
		}
		StringBuilder coursepathLang = new StringBuilder(); 
		coursepathLang.append("content/").append(courseName).append("/").append(language);
		coursepathLang.append("/").append(catalogId).append("/");
		StringBuilder courseDataPath = new StringBuilder(); 
		courseDataPath.append(coursepathLang.toString()).append(catalogId).append(".xml");
		StringBuilder content = new StringBuilder();
		content.append("(function(ns) {\n\n ");
		content.append("ns.configs = ns.configs ? ns.configs : {}; \n ");
		content.append("ns.configs.coursePathLang = \"").append(coursepathLang.toString());
		content.append("\";\n ns.configs.courseDataPath = \"").append(courseDataPath.toString());
		content.append("\"; \n ns.configs.site = \"lrnmodules\"; \n\n ");
		content.append("})(window.com.lrn.courseware);");
		FileWriter fw = new FileWriter(configFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content.toString());
		bw.close();
		return configFile;
	}
	
	*//**
     * Creates manifest files which consists ZIP folder structure. 
     * 
	 * @param Map<String, String> paramMap  
     * @param List<String> zipFileList
     * 
     * @throws IOException
     *//*
	private File createManiFestTemplateFile(Map<String, String> paramMap, 
			List<String> zipFileList) throws IOException {
    	File maniFestFile = new File(exportZipFolderPath + "imsmanifest_template.xml");
		if (!maniFestFile.exists()) {
			maniFestFile.createNewFile();
		}
		StringBuilder content = new StringBuilder();
		content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<manifest identifier=\"LCEC_SCORMLRNHostedgoo\" ");
		content.append("xmlns=\"http://www.imsproject.org/xsd/imscp_rootv1p1p2\" xmlns:adlcp=\"http://www.adlnet.org/xsd/adlcp_rootv1p2\" ");
		content.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.imsproject.org/xsd/imscp_rootv1p1p2 ");
		content.append("imscp_rootv1p1p2.xsd http://www.imsglobal.org/xsd/imsmd_rootv1p2p1 imsmd_rootv1p2p1.xsd ");
		content.append("http://www.adlnet.org/xsd/adlcp_rootv1p2 adlcp_rootv1p2.xsd\">\n");
		content.append("<metadata>\n<schema>ADL SCORM</schema>\n<schemaversion>1.2</schemaversion>\n</metadata>\n");
		content.append("<organizations default=\"LRN\">\n<organization identifier=\"LRN\">\n<title>LRN Corp</title>");
		content.append("\n<item identifier=\"TEST\" identifierref=\"sco\">\n<title>").append(paramMap.get("title"));
		content.append("</title>\n<adlcp:masteryscore>").append(paramMap.get("score")).append("</adlcp:masteryscore>\n</item>\n");
		content.append("</organization>\n</organizations>\n<resources>\n<resource identifier=\"sco\" href=\"index.html\" ");
		content.append("adlcp:scormtype=\"sco\" type=\"webcontent\">\n");
		if(zipFileList != null && zipFileList.size() > 0) {
			for(String file : zipFileList) {
				content.append("<file href=\"").append(file).append("\" />\n");
			}
			content.append("<file href=\"imsmanifest_template.xml\" />\n");
		}
		content.append("</resource>\n</resources>\n</manifest>");

		FileWriter fw = new FileWriter(maniFestFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content.toString());
		bw.close();
		return maniFestFile;
	}

	*//**
     * Creates license file. 
     * 
	 * @param Map<String, String> paramMap
     * 
     * @throws IOException
     *//*
	private File createLicenseFile(Map<String, String> paramMap) throws IOException {
    	File licenseFile = new File(exportZipFolderPath + "LICENSE.txt");
		if (!licenseFile.exists()) {
			licenseFile.createNewFile();
		}
		StringBuilder content = new StringBuilder();
		content.append("PLEASE READ THIS NOTE BEFORE PROCEEDING.\n\n");
		content.append("The use of this module is subject to the terms and conditions of the Knowledge Service Provider Agreement or Governance and Ethics Management System Agreement (the \"Agreement\") entered into\n"); 
		content.append("between LRN Modules and LRN Corporation (\"LRN\"), including the limitation on the maximum number of registered Users (as\n");
		content.append("defined in the Agreement) allowed under such Agreement. This module may be distributed only to registered Users and only for the sole\n");
		content.append("purpose of the use of the module by such registered Users as permitted under the Agreement. All information and materials contained in\n");
		content.append("this module are the confidential and proprietary information of LRN and/or other third party, and except to the extent set forth in the\n");
		content.append("preceding sentence, may not be downloaded, copied, distributed, or shared with any other party without the express written consent of\n");
		content.append("LRN. The copyrights and other intellectual property rights to this module shall remain the property of LRN. Upon request by LRN you\n");
		content.append("shall be required to return to LRN or destroy any information or materials contained in this module.");
		FileWriter fw = new FileWriter(licenseFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content.toString());
		bw.close();
		return licenseFile;
	}

	*//**
     * Creates list for different source folder files and map them with name. 
     * 
     * @return Map<String, List<String>>
     *//*
	private Map<String, List<String>> getSourceFileListMap() {
		Map<String, List<String>> sourceFileListMap = new HashMap<String, List<String>>();
		sourceFileListMap.put(ExportConstants.LIST_CONTENT_FILE, 
				new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_CONTENT_LANG_MEDIA, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_CONTENT_MEDIA, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_CONTENT_FUSION_PLUS, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_PLAYER, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_SITE, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_UI, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_CONTENT_ROOT_XML, 
    			new ArrayList<String>());
    	sourceFileListMap.put(ExportConstants.LIST_CONTENT_ROOT, 
    			new ArrayList<String>());
		return sourceFileListMap;
	}
}*/