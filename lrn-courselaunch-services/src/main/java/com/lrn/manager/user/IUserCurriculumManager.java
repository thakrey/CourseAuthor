package com.lrn.manager.user;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.user.UserCurriculum;
import com.lrn.model.hibernate.user.UserCurriculumPK;

/**
 * The Interface IUserCurriculumManager
 * 

 */
public interface IUserCurriculumManager extends IGenericManager<UserCurriculum, UserCurriculumPK> {

	/**
     * Gets list of UserCurriculum by userId.
     *
     * @param String userId
     * 
     * @return List<UserCurriculum>
     */
	List<UserCurriculum> getUserCurriculumsByUserId(String userId);
}
