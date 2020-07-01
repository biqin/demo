package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.UserPlus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface UserMapperPlus extends BaseMapper<UserPlus> {
    default UserPlus selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<UserPlus>().eq("username", username));
    }

    default List<UserPlus> selectByIds(@Param("ids") Collection<Integer> ids) {
        return selectList(new QueryWrapper<UserPlus>().in("id", ids));
    }

    default IPage<UserPlus> selectPageByCreateTime(IPage<UserPlus> page, @Param("createTime") Date createTime) {
        return selectPage(page,
                new QueryWrapper<UserPlus>().gt("create_time", createTime));
    }
}
