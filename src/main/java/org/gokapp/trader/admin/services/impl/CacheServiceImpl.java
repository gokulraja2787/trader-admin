package org.gokapp.trader.admin.services.impl;

import org.gokapp.trader.admin.domain.GroupInfo;
import org.gokapp.trader.admin.services.CacheService;
import org.gokapp.trader.common.domain.Group;
import org.gokapp.trader.common.jpa.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GroupRepository groupRepository;

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
    
}
