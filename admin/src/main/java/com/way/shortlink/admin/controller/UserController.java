package com.way.shortlink.admin.controller;

import com.way.shortlink.admin.dto.resp.UserRespDTO;
import com.way.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor // 自动为final修饰的字段注入依赖, 避免大量书写@Autowired
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public UserRespDTO getUserByUsername(@PathVariable("username") String username){
        return userService.getByUsername(username);
    }
}
