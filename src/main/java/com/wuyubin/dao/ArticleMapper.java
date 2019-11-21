package com.wuyubin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wuyubin.entity.Article;

public interface ArticleMapper {

	/**
	 * 获取最新文章
	 * @param i 获取的个数
	 * @return
	 */
	List<Article> newList(int i);

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hostList();

	/**
	 * 获取文章
	 * @param id
	 * @return
	 */
	Article getById(Integer id);

	/**
	 * 根据频道获取文章
	 * @param chnId
	 * @param categoryId
	 * @return
	 */
	List<Article> listByCat(@Param("chnId") int chnId,@Param("categoryId") int categoryId);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<Article> listByUser(Integer userId);

	@Update(" UPDATE cms_article SET  deleted=1 WHERE id=#{value} ")
	int delete(int id);

	/** 
	 * @Title: checkExist 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	@Select("SELECT id, title,user_id AS userId FROM cms_article WHERE id = #{value}")
	@ResultType(Article.class)
	Article checkExist(int id);

	/** 
	 * 管理员根据状态查询文章
	 * @Title: listByStatus 
	 * @Description: TODO
	 * @param status
	 * @return
	 * @return: List<Article>
	 */
	List<Article> listByStatus(int status);

	/**
	 * 获取文章详情，不考虑状态
	 * @param id
	 * @return
	 */
	Article getDetailById(int id);

	/**
	 *  审核文章 
	 * @param id
	 * @param status
	 * @return
	 */
	@Update(" UPDATE cms_article SET  status=#{status} "
			+ " WHERE id=#{id} ")
	int apply(@Param("id") int id,@Param("status") int status);

	/**
	 * 设置热门
	 * @param id
	 * @param status
	 * @return
	 */
	@Update(" UPDATE cms_article SET  hot=#{status} "
			+ " WHERE id=#{id} ")
	int setHot(@Param("id") int id,@Param("status") int status);

	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},#{deleted},"
			+ "now(),now(),#{commentCnt},#{articleType})")
	int add(Article article);

	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channelId},"
			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int update(Article article);

}
