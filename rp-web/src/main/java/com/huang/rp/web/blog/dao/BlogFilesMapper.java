package com.huang.rp.web.blog.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.web.blog.domain.BlogFiles;
import com.huang.rp.web.blog.domain.BlogFilesExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface BlogFilesMapper {
    int countByExample(BlogFilesExample example);

    int deleteByExample(BlogFilesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogFiles record);

    int insertSelective(BlogFiles record);

    List<BlogFiles> selectByExample(BlogFilesExample example);

    BlogFiles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogFiles record, @Param("example") BlogFilesExample example);

    int updateByExample(@Param("record") BlogFiles record, @Param("example") BlogFilesExample example);

    int updateByPrimaryKeySelective(BlogFiles record);

    int updateByPrimaryKey(BlogFiles record);
}