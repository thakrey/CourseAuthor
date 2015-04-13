package com.lrn.dto.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseBulletinDTOList implements Serializable {

	private static final long serialVersionUID = -4687037630215381350L;
	
	private List<CourseBulletinDTO> courseBulletinDtoList = new ArrayList<CourseBulletinDTO> ();

	public List<CourseBulletinDTO> getCourseBulletinDtoList() {
		return courseBulletinDtoList;
	}

	public void setCourseBulletinDtoList(
			List<CourseBulletinDTO> courseBulletinDtoList) {
		this.courseBulletinDtoList = courseBulletinDtoList;
	}

}
