package com.github.nikita160.jrtb.javarushclient;


import com.github.nikita160.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.nikita160.jrtb.javarushclient.dto.GroupInfo;
import com.github.nikita160.jrtb.javarushclient.dto.GroupRequestArgs;
import com.github.nikita160.jrtb.javarushclient.dto.GroupCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {

    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);
    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);
    Integer getGroupCount(GroupCountRequestArgs countRequestArgs);
    GroupDiscussionInfo getGroupById(Integer id);
}
