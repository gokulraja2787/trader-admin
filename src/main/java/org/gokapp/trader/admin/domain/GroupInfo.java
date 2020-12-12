package org.gokapp.trader.admin.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String groupId;

    @Getter
    @Setter
    private String groupName;
    
}
