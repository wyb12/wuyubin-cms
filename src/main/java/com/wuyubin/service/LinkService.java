package com.wuyubin.service;

import com.github.pagehelper.PageInfo;
import com.wuyubin.entity.Link;

/**
 * 
 * @author 吴宇斌
 *
 */
public interface LinkService {

	int add(Link link);
	PageInfo list(int page);
	int delete(int id);
	Link get(int id);
	int update( Link link);

}
