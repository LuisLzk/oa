package com.bwf.service;

import java.util.List;

import com.bwf.entity.News;

public interface INews {

	List<News> getNews();

	void addNews(News news);

	List<News> getSomeNews();

	void deleteNewsByNewsId(Integer newsId);

	News getSingleNews();

}
