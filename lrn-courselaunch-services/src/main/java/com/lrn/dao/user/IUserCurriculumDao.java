package com.lrn.dao.user;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.user.UserCurriculum;
import com.lrn.model.hibernate.user.UserCurriculumPK;

/**
 * The Interface IUserCurriculumDao.
 *
 * @author kishor.pawar
 */
public interface IUserCurriculumDao extends IGenericDao<UserCurriculum, UserCurriculumPK> {
	
	/**
     * Gets list of UserCurriculum by userId.
     *
     * @param String userId
     * 
     * @return List<UserCurriculum>
     */
	List<UserCurriculum> getUserCurriculumsByUserId(String userId);
}
