package com.fccfc.framework.web.manager.dao.common;

import java.util.List;

import com.fccfc.framework.config.core.bean.DirectoryPojo;
import com.fccfc.framework.db.core.DaoException;
import com.fccfc.framework.db.core.annotation.Dao;
import com.fccfc.framework.db.core.annotation.Param;
import com.fccfc.framework.db.core.annotation.Sql;
import com.fccfc.framework.db.hibernate.IGenericBaseDao;

/**
 * 
 * <Description> 目录结构<br> 
 *  
 * @author 胡攀<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月4日 <br>
 * @since V1.0<br>
 * @see com.fccfc.framework.web.manager.dao.common <br>
 */
@Dao
public interface DirectoryDao extends IGenericBaseDao {

	/**
	 * 
	 * Description: 分页查询所有的目录结构<br> 
	 *  
	 * @author 胡攀<br>
	 * @taskId <br>
	 * @param parentDirectoryCode
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws DaoException <br>
	 */
	@Sql(bean = com.fccfc.framework.web.manager.bean.system.DirectoryPojo.class)
	List<com.fccfc.framework.web.manager.bean.system.DirectoryPojo> selectList(
			@Param("parentDirectoryCode") String parentDirectoryCode,
			@Param(Param.PAGE_INDEX) Integer pageIndex,
			@Param(Param.PAGE_SIZE) Integer pageSize) throws DaoException;

	/**
	 * 
	 * Description: 删除目录结构<br> 
	 *  
	 * @author 胡攀<br>
	 * @taskId <br>
	 * @param directoryCode
	 * @return
	 * @throws DaoException <br>
	 */
	@Sql(value = "DELETE FROM DIRECTORY WHERE DIRECTORY_CODE = :directoryCode")
	int deleteById(@Param("directoryCode") String directoryCode) throws DaoException;

	/**
	 * 
	 * Description: 修改目录结构<br> 
	 *  
	 * @author 胡攀<br>
	 * @taskId <br>
	 * @param directoryPojo
	 * @return
	 * @throws DaoException <br>
	 */
	@Sql(value="UPDATE DIRECTORY SET DIRECTORY_NAME = :directory.directoryName, REMARK = :directory.remark WHERE DIRECTORY_CODE = :directory.directoryCode")
	int update(@Param("directory") DirectoryPojo directoryPojo) throws DaoException;

	DirectoryPojo getByAttr(@Param("directory") DirectoryPojo directoryPojo) throws DaoException;
}