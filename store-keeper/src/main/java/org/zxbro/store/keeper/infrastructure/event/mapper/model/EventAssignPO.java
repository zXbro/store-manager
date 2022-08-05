package org.zxbro.store.keeper.infrastructure.event.mapper.model;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.zxbro.store.keeper.biz.model.EventDO;

import java.util.Date;
import java.util.List;

@Data
public class EventAssignPO {
    private Long eventAssignId;
    private Integer tenantId;
    private Long eventNo;
    private Long assignToUserNo;
    private Integer eventUserState;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;

    public static List<EventAssignPO> buildFrom(EventDO eventDO, Integer state, String updatedBy, Date updatedTime) {
        if(CollectionUtils.isEmpty(eventDO.getAssignTos())){
            return null;
        }
        List<EventAssignPO> eventAssignPOS = Lists.newArrayList();
        eventDO.getAssignTos().forEach(assignTo->{
            EventAssignPO eventAssignPO=new EventAssignPO();
            eventAssignPO.setTenantId(eventDO.getTenantId());
            eventAssignPO.setEventNo(eventDO.getEventNo());
            eventAssignPO.setAssignToUserNo(assignTo);
            eventAssignPO.setEventUserState(state);
            eventAssignPO.setCreatedBy(eventDO.getCreatedBy());
            eventAssignPO.setCreatedTime(eventDO.getCreatedTime());
            eventAssignPO.setUpdatedBy(updatedBy);
            eventAssignPO.setUpdatedTime(updatedTime);
            eventAssignPOS.add(eventAssignPO);
        });
        return eventAssignPOS;
    }
}
