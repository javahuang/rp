package com.huang.rp.web.blog.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.web.blog.domain.BlogPostTerms;
import com.huang.rp.web.blog.domain.BlogPostTermsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface BlogPostTermsMapper {
    int countByExample(BlogPostTermsExample example);

    int deleteByExample(BlogPostTermsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogPostTerms record);

    int insertSelective(BlogPostTerms record);

    List<BlogPostTerms> selectByExample(BlogPostTermsExample example);

    BlogPostTerms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogPostTerms record, @Param("example") BlogPostTermsExample example);

    int updateByExample(@Param("record") BlogPostTerms record, @Param("example") BlogPostTermsExample example);

    int updateByPrimaryKeySelective(BlogPostTerms record);

    int updateByPrimaryKey(BlogPostTerms record);
}