package com.fccfc.framework.web.dao;

import java.util.List;

import com.fccfc.framework.config.core.bean.DirectoryPojo;
import com.fccfc.framework.db.core.DaoException;
import com.fccfc.framework.db.core.annotation.Dao;
import com.fccfc.framework.db.core.annotation.Param;
import com.fccfc.framework.db.core.annotation.Sql;
import com.fccfc.framework.db.hibernate.IGenericBaseDao;

/**
 * <Description> <br>
 * 
 * @author 刘柏洋 <br>
 * @version 1.0 <br>
 * @CreateDate 2014年12月2日 <br>
 * @see com.fccfc.test.dao.api <br>
 */
@Dao
public interface DirectoryDao extends IGenericBaseDao {

    @Sql(value = "SELECT * FROM DIRECTORY WHERE DIRECTORY_CODE = :directoryCode", bean = DirectoryPojo.class)
    List<DirectoryPojo> queryDirectory(@Param("directoryCode") String directoryCode) throws DaoException;

    @Sql(value = "SELECT * FROM DIRECTORY WHERE PARENT_DIRECTORY_CODE = :parentDirectoryCode",
        bean = DirectoryPojo.class)
    List<DirectoryPojo> queryDirectoryByParentCode(@Param("parentDirectoryCode") String parentDirectoryCode)
        throws DaoException;

    @Sql("INSERT INTO DIRECTORY(DIRECTORY_CODE,DIRECTORY_NAME,PARENT_DIRECTORY_CODE,REMARK) VALUES(:directory.directoryCode,:directory.directoryName,:directory.parentDirectoryCode,:directory.remark)")
    int insertDirectory(@Param("directory") DirectoryPojo directory) throws DaoException;

    @Sql("DELETE FROM DIRECTORY WHERE DIRECTORY_CODE = :directoryCode")
    int deleteDirectory(@Param("directoryCode") String directoryCode) throws DaoException;

    @Sql("UPDATE DIRECTORY SET DIRECTORY_NAME = :directory.directoryName , REMARK= :directory.remark WHERE DIRECTORY_CODE = :directory.directoryCode")
    int updateDirectory(@Param("directory") DirectoryPojo pojo) throws DaoException;

}