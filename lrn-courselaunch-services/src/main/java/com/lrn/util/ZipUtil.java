package com.lrn.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public final class ZipUtil {

	private static final Logger logger = Logger.getLogger(ZipUtil.class);
	
	/**
     * First Generates file list and after that adds to ZipEntry and then writes to
     * ZipOutputStream. 
     * 
     * @param List<String> zipFiles
     * @param List<String> sourceFiles
     * @param String sourceFolderPath
     * @param String zipContentFilePath
     * @param ZipOutputStream zos
     * @param byte[] buffer
     */
	public static void processZipFiles(List<String> zipFiles, 
			List<String> sourceFiles, String sourceFolderPath, 
			String zipContentFilePath, 
			ZipOutputStream zos, byte[] buffer) throws Exception {
		logger.debug("Start of Zip process....");
		logger.debug("Start of generating file list from source folder... " 
				+ sourceFolderPath);
		generateFileList(sourceFiles, new File(sourceFolderPath), 
				sourceFolderPath);
		addFileZipEntryAndWriteToZipSteam(zipFiles, sourceFiles,
				zipContentFilePath, sourceFolderPath, zos, buffer);
		logger.debug("End of Zip process....");
	}
	
	/**
     * Adds file list to ZipEntry and writes to the ZipOutPutStream. 
     * 
     * @param List<String> zipFileList
     * @param List<String> addToZipFileList
     * @param String zipFolder
     * @param String fileFolder
     * @param ZipOutputStream zos
     * @param byte[] buffer
     */
	public static void addFileZipEntryAndWriteToZipSteam(List<String> zipFileList,
			List<String> addToZipFileList, String zipFolder, 
			String fileFolder, ZipOutputStream zos, 
			byte[] buffer) throws Exception {
		logger.debug("Start of adding zip entry and writing to steam...." + zipFolder);
		if(addToZipFileList != null && addToZipFileList.size() > 0) {
    		for(String file : addToZipFileList) {
    			logger.debug("Adding to Zip > File: " + file);
        		String path = zipFolder + file;
        		zipFileList.add(path);
        		String filePath = fileFolder + File.separator + file;
    			addFileZipEntryAndWriteToZipSteam(path, filePath, zos, buffer);
    		}
    	}
		logger.debug("End of adding zip entry and writing to steam...." + zipFolder);
	}
	
	/**
     * Adds file list to ZipEntry and writes to the ZipOutPutStream. 
     * 
     * @param List<String> zipFileList
     * @param List<String> addToZipFileList
     * @param String zipFolder
     * @param String fileFolder
     * @param ZipOutputStream zos
     * @param byte[] buffer
     * @param Map<String, Boolean> neglectFileMap
     */
	public static void addFileZipEntryAndWriteToZipSteam(List<String> zipFileList,
			List<String> addToZipFileList, String zipFolder, 
			String fileFolder, ZipOutputStream zos, 
			byte[] buffer,
			Map<String, Boolean> neglectFileMap) throws Exception {
		logger.debug("Start of adding zip entry and writing to steam...." + zipFolder);
		if(addToZipFileList != null && addToZipFileList.size() > 0) {
    		for(String file : addToZipFileList) {
    			logger.debug("Before adding to Zip > File: " + file);
        		if(neglectFileMap.get(file) == null) {
    				logger.debug("Adding to Zip > File: " + file);
            		String path = zipFolder + file;
            		zipFileList.add(path);
            		String filePath = fileFolder + File.separator + file;
        			addFileZipEntryAndWriteToZipSteam(path, filePath, zos, buffer);
    			}
    		}
    	}
		logger.debug("End of adding zip entry and writing to steam...." + zipFolder);
	}
	
	/**
     * Adds file to ZipEntry and writes to the ZipOutPutStream. 
     *  
     * @param String zipFilePath
     * @param String fileAbsolutePath
     * @param ZipOutputStream zos
     * @param byte[] buffer
     */
	public static void addFileZipEntryAndWriteToZipSteam(String zipFilePath,
    		String fileAbsolutePath, ZipOutputStream zos, 
    		byte[] buffer) throws Exception {
    	System.out.println("Writing to stream > File: " + zipFilePath);
		ZipEntry ze= new ZipEntry(zipFilePath);
    	zos.putNextEntry(ze);
    	FileInputStream in = new FileInputStream(fileAbsolutePath);
    	int len;
    	while ((len = in.read(buffer)) > 0) {
    		zos.write(buffer, 0, len);
    	}
    	in.close();
	}

	/**
     * Generates file list from folder and sub folders 
     *  
     * @param List<String> fileList
     * @param String sourceFolderName
     */
    public static void generateFileList(List<String> fileList, File node, 
    		String sourceFolderName){
    	//add file only
    	if(node.isFile()){
    		fileList.add(generateZipEntry(node.getAbsoluteFile().toString(), 
    				sourceFolderName));
    	}
 
    	if(node.isDirectory()){
    		String[] subNote = node.list();
    		for(String filename : subNote){
    			generateFileList(fileList, new File(node, filename), sourceFolderName);
    		}
    	}
    	logger.debug("End of generating file list from source folder... " 
    			+ sourceFolderName);
    }   
    
    /**
     * Generates file list from only root folder 
     *  
     * @param List<String> fileList
     * @param String sourceFolderName
     */
    public static void generateFileListNonRecursive(List<String> fileList, 
    		String sourceFolderName){
    	File folder = new File(sourceFolderName);
    	for (File fileEntry : folder.listFiles()) {
	    	if (fileEntry.isFile()) {
	    		fileList.add(generateZipEntry(fileEntry.getAbsoluteFile().toString(), 
	    				sourceFolderName));
	    	}
	    }
    } 
    
    /**
     * generates the file name with folder(if it's inside folder at source folder) 
     * required for ZIP entry. 
     * 
     * @param String file
     * @param String sourceFolderName
     * 
     * @return String zipEntry
     */
    private static String generateZipEntry(String file, String sourceFolderName){
    	return file.substring(sourceFolderName.length(), file.length());
    }
}