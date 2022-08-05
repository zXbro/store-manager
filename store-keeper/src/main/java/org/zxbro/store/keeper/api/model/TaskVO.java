package org.zxbro.store.keeper.api.model;

import lombok.Data;

import java.util.List;

@Data
public class TaskVO {
    private List<TaskDetailVO> taskDetailVOs;
    @Data
    public static class TaskDetailVO{
        private Long eventNo;
        private String eventTitle;
        private String eventContent;
        private Integer eventLevel;
        private Integer eventState;
    }
}
