package com.github.nikita160.jrtb.javarushclient.dto;
import lombok.Data;

/**
 * DTO for User discussion info.
 */
@Data
public class UserDiscussionInfo {
    private Boolean isBookmarked;
    private Integer lastTime;
    private Integer newCommentsCount;
}
