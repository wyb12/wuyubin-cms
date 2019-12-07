package com.wuyubin.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.wuyubin.entity.Collect;

/**
 *  收藏
 * @author 吴宇斌
 *
 */
public interface CollectService {

	/**
	 * 
	 * @param collect
	 * @return
	 */
	int add(Collect collect);
	/**
	 * 
	 * @param page
	 * @return
	 */
	PageInfo list(int userId,int page);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Collect get(int id);
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	int update( Collect collect);
	/**  
	* @Title: addCollect  
	* @Description: TODO  
	* @param @param collect     
	* @return void    
	* @throws  
	*/
	void addCollect(Collect collect);
	/**  
	* @Title: deleted  
	* @Description: TODO  
	* @param @param id     
	* @return void    
	* @throws  
	*/
	void deleted(Integer id);

}
