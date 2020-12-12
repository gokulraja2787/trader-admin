package org.gokapp.trader.admin.services;

import org.gokapp.trader.admin.domain.GroupInfo;

public interface CacheService {

    /**
     * 
     * @param key
     * @param value
     */
    public void putValue(String key, String value);

    /**
     * 
     * @param key
     * @return
     */
    public String getValue(String key);

    /**
     * 
     * @param groupInfo
     */
    public void putGroup(GroupInfo groupInfo);

    /**
     * 
     * @param id
     * @return
     */
    public GroupInfo getGroup(String id);
}
