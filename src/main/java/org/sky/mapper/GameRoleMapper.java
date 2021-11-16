package org.sky.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.GameRole;
import org.sky.base.GameRoleExample;

public interface GameRoleMapper {
    long countByExample(GameRoleExample example);

    int deleteByExample(GameRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(GameRole record);

    int insertSelective(GameRole record);

    List<GameRole> selectByExample(GameRoleExample example);

    GameRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") GameRole record, @Param("example") GameRoleExample example);

    int updateByExample(@Param("record") GameRole record, @Param("example") GameRoleExample example);

    int updateByPrimaryKeySelective(GameRole record);

    int updateByPrimaryKey(GameRole record);
}