package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.News;
import com.bwf.service.INews;

public interface NewsMapper {

	List<News> getNews();

	void addNews(@Param("news") News news);

	List<News> getSomeNews();

	void deleteNewsByNewsId(@Param("newsId") Integer newsId);

	News getSingleNews();

}
