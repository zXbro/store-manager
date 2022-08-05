package org.zxbro.store.keeper.infrastructure.event.mapper.model;

import lombok.Data;
import org.zxbro.store.keeper.biz.model.EventDO;
import org.zxbro.store.keeper.utils.ModelUtils;

import java.util.Date;

@Data
public class EventPO {
    private Long eventId;
    private Integer tenantId;
    private Long eventNo;
    private Integer eventType;
    private String eventTitle;
    private String eventContent;
    private Integer eventLevel;
    private Integer eventState;
    private Date eventEndDate;
    private Integer version;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;

    public static EventPO buildFrom(EventDO eventDO){
        return ModelUtils.beanConvert(eventDO,EventPO.class);
    }
}
