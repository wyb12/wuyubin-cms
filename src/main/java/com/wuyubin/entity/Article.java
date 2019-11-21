package com.wuyubin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 吴宇斌
 *
 */
public class Article implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6320126833474686896L;

	private Integer id               ;
	// 文章标题
	private String title            ;
	// 文章内容
	private String content          ;
	//标题图片的url 地址
	private String picture          ;
	// 频道
	private Integer channelId       ;
	private Channel channel       ;

	private String categoryId      ;
	// 文章的分类
	private Category category;


	private Integer userId          ;
	private User user          ;

	// 点击数量
	private int  hits             ;
	// 是否为热门文章 1 是  0 否
	private int hot              ;
	// 0 待审核  1 审核通过  2 审核未通过
	private int status           ;
	//是否被删除
	private int deleted          ;

	//发表时间
	private Date created          ;

	//最后修改时间
	private Date updated          ;

	// 评论的数量
	private int commentCnt       ;
	//文章类型
	private int articleType      ;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the channelId
	 */
	public Integer getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}
	/**
	 * @param hits the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}
	/**
	 * @return the hot
	 */
	public int getHot() {
		return hot;
	}
	/**
	 * @param hot the hot to set
	 */
	public void setHot(int hot) {
		this.hot = hot;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the deleted
	 */
	public int getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the commentCnt
	 */
	public int getCommentCnt() {
		return commentCnt;
	}
	/**
	 * @param commentCnt the commentCnt to set
	 */
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	/**
	 * @return the articleType
	 */
	public int getArticleType() {
		return articleType;
	}
	/**
	 * @param articleType the articleType to set
	 */
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", picture=" + picture + ", channelId=" + channelId
				+ ", channel=" + channel + ", categoryId=" + categoryId
				+ ", category=" + category + ", userId=" + userId + ", user="
				+ user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created
				+ ", updated=" + updated + ", commentCnt=" + commentCnt
				+ ", articleType=" + articleType + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
