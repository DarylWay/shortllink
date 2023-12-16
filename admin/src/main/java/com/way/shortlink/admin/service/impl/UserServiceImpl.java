package com.way.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.way.shortlink.admin.dao.entity.UserDO;
import com.way.shortlink.admin.dao.mapper.UserMapper;
import com.way.shortlink.admin.dto.resp.UserRespDTO;
import com.way.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = this.getOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();
        //TODO: spring提供的属性拷贝有问题, 后续需要自己定义属性拷贝框架
        BeanUtils.copyProperties(userDO, result);
        return result;
    }
}
