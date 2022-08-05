package org.zxbro.store.keeper.biz.model;

import lombok.Data;
import org.zxbro.store.keeper.api.model.EventVO;
import org.zxbro.store.keeper.utils.ModelUtils;

import java.util.Date;
import java.util.List;

@Data
public class EventDO {
    private Integer tenantId;
    private Long eventNo;
    private Integer eventType;
    private String eventTitle;
    private String eventContent;
    private List<Long> assignTos;
    private Integer eventLevel;
    private Integer eventState;
    private Date eventEndDate;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;

    public static EventDO buildFrom(EventVO eventVO) {
        return ModelUtils.beanConvert(eventVO, EventDO.class);
    }
}
