package org.gokapp.trader.admin.controller;

import org.gokapp.trader.admin.domain.GroupInfo;
import org.gokapp.trader.admin.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    
    /**
     * 
     */
    @Autowired
    private CacheService cacheService;

    @GetMapping("/group/{groupId}")
    public GroupInfo getGroupInfo(@PathVariable String groupId) {
        
        return cacheService.getGroup(groupId);
    }

    @PostMapping("/group/add")
    public void putGroupInfo(@RequestParam String groupId, @RequestParam String groupName) {
        // TODO data validation
        cacheService.putGroup(new GroupInfo(groupId, groupName));
    }
}
