package com.wuyubin.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wuyubin.entity.Channel;
import com.wuyubin.service.ChannelService;


public class TestChannel  extends TestBase{
	
	@Autowired
	ChannelService channelService;
	
	@Test
	 public void testList() {
		List<Channel> list = channelService.list();
		 list.forEach(x->{
			 System.out.println(" 频道是 " + x);
		 });
	 }
	
}
