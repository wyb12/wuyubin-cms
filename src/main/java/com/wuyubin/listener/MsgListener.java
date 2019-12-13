package com.wuyubin.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.wuyubin.dao.ArticleMapper;
import com.wuyubin.entity.Article;


/**
 * @author 吴宇斌
 *
 * 2019年12月11日
 */
public class MsgListener implements MessageListener<String, String>{

	@Autowired
	private ArticleMapper mapper;
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String value = data.value();
		
		if (value.equals("upd")) {
			redisTemplate.delete("hot_articles");
		} else if(value.equals("add")){
			redisTemplate.delete("hot_articles");
		}else if(value.equals("del")){
			redisTemplate.delete("hot_articles");
		}else {
			System.err.println("已经收到-------------");
			Article article = JSON.parseObject(value, Article.class);
			
			mapper.add(article);
		}
		
	}

}
