package com.bwf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.NewsMapper;
import com.bwf.entity.News;
import com.bwf.service.INews;
@Service
public class newsImpl implements INews {
	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		List<News> news=newsMapper.getNews();
		List<News> list=new ArrayList<>();
		
		for(int i=0;i<news.size();i++){
			//System.out.println(news.toString());
			Date date=news.get(i).getTime();
			//System.out.println(date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        //System.out.println(sdf.format(date));
			news.get(i).setNewTime(sdf.format(date));
			list=news;
			
		}
		for(News n:list){
			System.out.println(n.getNewsDetails());
		}
		System.out.println(list.size());
		return list;
	}

	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		System.out.println(news);
		newsMapper.addNews(news);
	}

	@Override
	public List<News> getSomeNews() {
		// TODO Auto-generated method stub
		return newsMapper.getSomeNews();
	}

	@Override
	public void deleteNewsByNewsId(Integer newsId) {
		// TODO Auto-generated method stub
		newsMapper.deleteNewsByNewsId(newsId);
	}

	@Override
	public News getSingleNews() {
		// TODO Auto-generated method stub
		return newsMapper.getSingleNews();
	}

}
