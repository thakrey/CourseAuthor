package com.lrn.adapter;

import java.io.File;

import com.lrn.model.spring.service.response.export.ExportCourseDTO;

/**
 * The Interface IExportAdapter.
 */
public interface IExportAdapter {

	/**
	 * Returns compressed course folder details. 
	 * 
	 * @param Long siteId
	 * @param String systemId
	 * @param String catalogId
	 * 
	 * @return ExportCourseDTO
	 * @throws Exception 
	 */
	ExportCourseDTO exportCourse(Long siteId, String systemId,
			String courseType) throws Exception;
	
	/**
	 * Compresses course by considering all the files to considered, 
	 * new files to be created while constructing course zip folder.
	 * Initially this will consider only SCROM courses. 
	 * 
	 * @param Long siteId
	 * @param String systemId
	 * @param String catalogId
	 * 
	 * @return File
	 * @throws Exception 
	 */
	File compressCourse(Long siteId, String systemId,
			String courseType) throws Exception;
}