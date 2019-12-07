package com.wuyubin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wuyubin.entity.Collect;

public interface CollectMapper {
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Insert("INSERT INTO cms_collect (userId,url,name,created) "
			+ " VALUES(#{userId},#{url},#{name},now())")
	int add(Collect collect);
	
	/**
	 * 
	 * @return
	 */
	@Select("SELECT * FROM cms_collect "
			+ " WHERE userId=#{userId} "
			+ " ORDER BY created DESC")
	List<Collect> list(int userId);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Update("UPDATE cms_collect set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int  update(Collect collect);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_collect WHERE id=#{value} ")
	Collect get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_collect WHERE id=#{value} ")
	int delete(int id);

	/**  
	* @Title: addCollect  
	* @Description: TODO  
	* @param @param collect     
	* @return void    
	* @throws  
	*/
	@Insert("INSERT INTO cms_collect VALUES (null,#{userId},#{url},#{name},now()")
	void addCollect(Collect collect);

	/**  
	* @Title: deleted  
	* @Description: TODO  
	* @param @param id     
	* @return void    
	* @throws  
	*/
	@Delete("DELETE FROM cms_collect WHERE ID=#{id}")
	void deleted(Integer id);

}
