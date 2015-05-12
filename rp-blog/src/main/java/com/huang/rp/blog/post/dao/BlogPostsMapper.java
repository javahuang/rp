package com.huang.rp.blog.post.dao;

import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.post.domain.BlogPosts;
import com.huang.rp.blog.post.domain.BlogPostsExample;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.persistence.MyBatisRepository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface BlogPostsMapper {
    int countByExample(BlogPostsExample example);

    int deleteByExample(BlogPostsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogPostsWithBLOBs record);

    int insertSelective(BlogPostsWithBLOBs record);

    List<BlogPostsWithBLOBs> selectByExampleWithBLOBs(BlogPostsExample example);

    List<BlogPosts> selectByExample(BlogPostsExample example);

    BlogPostsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogPostsWithBLOBs record, @Param("example") BlogPostsExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogPostsWithBLOBs record, @Param("example") BlogPostsExample example);

    int updateByExample(@Param("record") BlogPosts record, @Param("example") BlogPostsExample example);

    int updateByPrimaryKeySelective(BlogPostsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogPostsWithBLOBs record);

    int updateByPrimaryKey(BlogPosts record);

	/**
	 * @param filter
	 * @return
	 */
	List<BlogPostsWithBLOBs> selectArticleExcerptByFilter(AccessFilter filter);
}