package com.huang.rp.common.cache.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.cache.domain.SysParameterExample;
import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.common.persistence.fliter.QueryFilter;
import com.huang.rp.web.blog.domain.TagParameter;

@MyBatisRepository
public interface SysParameterMapper {
    int countByExample(SysParameterExample example);

    int deleteByExample(SysParameterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    List<SysParameter> selectByExample(SysParameterExample example);

    SysParameter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
    
    /**
     * 获取paraType下当前code 的最大值
     * */
    int getMaxCodeByParaCode(String paraType);

	/**
	 * @param filter2
	 * @return
	 */
	List<TagParameter> selectByFilter(QueryFilter filter2);
}