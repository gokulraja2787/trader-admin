package org.gokapp.trader.admin.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private List<GroupInfo> groupInfo;
    
}
