package org.gokapp.trader.admin.services.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.gokapp.trader.admin.domain.GroupInfo;
import org.gokapp.trader.admin.domain.UserInfo;
import org.gokapp.trader.admin.services.CacheService;
import org.gokapp.trader.common.domain.Group;
import org.gokapp.trader.common.domain.User;
import org.gokapp.trader.common.jpa.repositories.GroupRepository;
import org.gokapp.trader.common.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 
     */
    @Override
    public void putValue(String key, String value) {

        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 
     */
    @Override
    public String getValue(String key) {

        if (redisTemplate.hasKey(key)) {
            Object value = redisTemplate.opsForValue().get(key);
            if (value instanceof String) {
                return value.toString();
            } else {
                return "Invalid type";
            }
        } else {
            return "Not Found";
        }
    }

    /**
     * 
     */
    @Override
    public void putGroup(GroupInfo groupInfo) {

        groupRepository.save(new Group(groupInfo.getGroupId(), groupInfo.getGroupName()));

    }

    @Override
    public GroupInfo getGroup(String id) {
        Group group = groupRepository.findById(id).orElse(new Group());
        return new GroupInfo(group.getGroupId(), group.getGroupdName());
    }

    @Override
    public void putUser(UserInfo userInfo) {
        Set<String> groupId;
        if(CollectionUtils.isEmpty(userInfo.getGroupInfo())) {
            groupId = Collections.emptySet();
        } else {
            groupId = new HashSet<>();
            userInfo.getGroupInfo().forEach(
                item -> {
                    groupId.add(item.getGroupId());
                }
            );
        }
        User user = new User(userInfo.getUserId(), userInfo.getUserName(), groupId);
        userRepository.save(user);
    }

    @Override
    public UserInfo getUser(String id) {
        User user = userRepository.findById(id).orElse(new User());
        Set<GroupInfo> userGroups;
        if (CollectionUtils.isEmpty(user.getGroups())) {
            userGroups = Collections.emptySet();
        } else {
            userGroups = new HashSet<>();
            groupRepository.findAllById(user.getGroups()).forEach(
                item -> {
                    new GroupInfo(item.getGroupId(), item.getGroupdName());
                }
            );
        }
        return new UserInfo(user.getUserId(), user.getUserName(), userGroups);
    }
    
}
