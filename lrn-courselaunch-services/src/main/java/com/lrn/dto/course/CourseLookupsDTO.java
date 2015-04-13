package com.lrn.dto.course;

import java.io.Serializable;
import java.util.List;

/**  
* CourseLookupsDTO - data transfer object class for list of course lookup. 
* It stores the data for the list of course lookup. 
* 
* @see CourseLookupDTO
*/ 
public class CourseLookupsDTO implements Serializable {
	
	private static final long serialVersionUID = 1839624390184570792L;
	
	private List<CourseLookupDTO> courseLookupDTOList;
	/**
	 * Gets the list of course lookup.
	 *
	 * @return the courseLookupDTOList, holds the list of {@link CourseLookupDTO} 
	 */
	public List<CourseLookupDTO> getCourseLookupDTOList() {
		return courseLookupDTOList;
	}
	/**
	 * Sets the list of course lookup.
	 *
	 * @param courseLookupDTOList the courseLookupDTOList - list of {@link CourseLookupDTO} to set
	 */
	public void setCourseLookupDTOList(List<CourseLookupDTO> courseLookupDTOList) {
		this.courseLookupDTOList = courseLookupDTOList;
	}
}
