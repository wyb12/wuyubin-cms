package com.wuyubin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuyubin.common.ConstantClass;
import com.wuyubin.dao.ArticleMapper;
import com.wuyubin.entity.Article;
import com.wuyubin.entity.Comment;
import com.wuyubin.service.ArticleService;

/**
 * 
 * @author 吴宇斌
 *
 */
@Service
public class ArticleServiceImpl  implements ArticleService{
	
	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	private RedisTemplate template;
	

	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.newList(i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<Article> hotList(int page) {
		// TODO Auto-generated method stub
		//PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		//从redis中查询热门文章
		List<Article> list = template.opsForList().range("hot_articles", 0, -1);
		//判断redis中的数据是否为空
		if (list!=null&&list.size()>0) {
			System.err.println("从redis中查询了热点文章");
			return new PageInfo<Article>(list);
		}
		//如果为空，从mysql中查询数据，添加到redis并且返回到页面
		List<Article> mysqlDB = articleMapper.hostList();
		System.err.println("从mysql中查询了热点文章");
		template.opsForList().leftPushAll("hot_articles", mysqlDB.toArray());
		
		return new PageInfo<Article>(mysqlDB);
		
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getById(id);
	}

	@Override
	public PageInfo<Article> listByCat(int chnId, int categoryId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByCat(chnId,categoryId));
	}

	@Override
	public PageInfo<Article> listByUser(int page,Integer userId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByUser(userId));
	
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return articleMapper.delete(id);
	}

	/* (non Javadoc) 
	 * @Title: checkExist
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.zhukaige.service.ArticleService#checkExist(int) 
	 */
	@Override
	public Article checkExist(int id) {
		// TODO Auto-generated method stub
		return  articleMapper.checkExist(id);
	}

	/* (non Javadoc) 
	 * @Title: getPageList
	 * @Description: TODO
	 * @param status
	 * @param page
	 * @return 
	 * @see com.zhukaige.service.ArticleService#getPageList(int, java.lang.Integer) 
	 */
	@Override
	public PageInfo<Article> getPageList(int status, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByStatus(status));
	}

	@Override
	public Article getDetailById(int id) {
		// TODO Auto-generated method stub
		return  articleMapper.getDetailById(id);
	}

	@Override
	public int apply(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.apply(id,status);
	}

	
	@Override
	public int setHot(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.setHot(id,status);
	}

	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.add(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public int faverite(Integer userId, int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.favorite(userId,articleId);
	}

	@Override
	public List<Article> getImgArticles(int num) {
		// TODO Auto-generated method stub
		return articleMapper.getImgArticles(num);
	}

	@Override
	public int comment(Integer userId, int articleId, String content) {
		// TODO Auto-generated method stub
		
		//插入评论表一条数据
		int result = articleMapper.addComment(userId, articleId, content);
		if(result>0) {
			// 让文章表中的评论数量自增1
			articleMapper.increaseCommentCnt(articleId);
		}else {
			return 0;
		}
		return result;
		
	}

	@Override
	public PageInfo<Comment> commentlist(int articleId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,10);
		
		return new PageInfo<Comment>(articleMapper.commentlist(articleId));
	}

}
