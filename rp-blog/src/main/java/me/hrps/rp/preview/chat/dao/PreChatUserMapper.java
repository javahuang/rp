package me.hrps.rp.preview.chat.dao;

import java.util.List;

import me.hrps.rp.preview.chat.domain.PreChatUser;
import me.hrps.rp.preview.chat.domain.PreChatUserExample;

import org.apache.ibatis.annotations.Param;

import com.huang.rp.common.persistence.MyBatisRepository;

@MyBatisRepository
public interface PreChatUserMapper {
    int countByExample(PreChatUserExample example);

    int deleteByExample(PreChatUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PreChatUser record);

    int insertSelective(PreChatUser record);

    List<PreChatUser> selectByExample(PreChatUserExample example);

    PreChatUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PreChatUser record, @Param("example") PreChatUserExample example);

    int updateByExample(@Param("record") PreChatUser record, @Param("example") PreChatUserExample example);

    int updateByPrimaryKeySelective(PreChatUser record);

    int updateByPrimaryKey(PreChatUser record);
}