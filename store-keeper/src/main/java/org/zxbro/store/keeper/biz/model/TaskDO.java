package org.zxbro.store.keeper.biz.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDO {
    private Integer tenantId;
    private Long userNo;
    private Long eventNo;
    private Integer eventType;
    private String eventTitle;
    private String eventContent;
    private Integer eventLevel;
    private Integer eventUserState;
    private Date eventEndDate;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
