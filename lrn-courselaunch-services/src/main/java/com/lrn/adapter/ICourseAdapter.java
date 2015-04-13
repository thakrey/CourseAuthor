package com.lrn.adapter;

import java.text.ParseException;

import com.lrn.model.spring.service.response.course.MobileSyncDTO;

/**
 * The Interface ICourseAdapter.
 * 
 */
public interface ICourseAdapter {

	/**
	 * Returns Course progress. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * 
	 * @return MobileSyncDTO
	 * @throws ParseException 
	 */
	MobileSyncDTO getMobileSyncGetParam(String userId, String company,
			Long course) throws ParseException;
	/**
	 * Saves course progress to the database. 
	 * 
	 * @param MobileSyncDTO mobileSyncDTO
	 * 
	 * @return MobileSyncDTO
	 * @throws ParseException 
	 */
	MobileSyncDTO saveMobileSyncPutParam(MobileSyncDTO mobileSyncDTO) 
			throws ParseException;
}