package org.zxbro.store.keeper.biz;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.zxbro.store.keeper.biz.model.EventDO;
import org.zxbro.store.keeper.biz.model.TaskDO;
import org.zxbro.store.keeper.biz.model.UserDO;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventAssignPO;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventPO;
import org.zxbro.store.keeper.infrastructure.event.service.EventAssignService;
import org.zxbro.store.keeper.infrastructure.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EventBiz {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventAssignService eventAssignService;

    public void createEvent(EventDO eventDO) {
        EventPO eventPO = EventPO.buildFrom(eventDO);
        eventPO.setVersion(0);
        eventService.addEvent(eventPO);

        List<EventAssignPO> eventAssignPOs = EventAssignPO.buildFrom(eventDO,0,"Test",new Date());
        eventAssignService.insert(eventAssignPOs);
    }

    public List<TaskDO> listEventByAssign(UserDO.UserId userId){
        List<EventAssignPO> eventAssignPOs = eventAssignService.listByUserNo(userId.getTenantId(),userId.getUserNo());
        if (CollectionUtils.isEmpty(eventAssignPOs)) {
            return null;
        }
        List<TaskDO> taskDOs = Lists.newArrayList();
        eventAssignPOs.forEach(eventAssignPO -> {
            EventPO eventPO = eventService.queryByEventNo(userId.getTenantId(),eventAssignPO.getEventNo());
            TaskDO taskDO = new TaskDO();
            taskDO.setTenantId(userId.getTenantId());
            taskDO.setUserNo(eventAssignPO.getAssignToUserNo());
            taskDO.setEventNo(eventAssignPO.getEventNo());
            taskDO.setEventType(eventPO.getEventType());
            taskDO.setEventTitle(eventPO.getEventTitle());
            taskDO.setEventContent(eventPO.getEventContent());
            taskDO.setEventLevel(eventPO.getEventLevel());
            taskDO.setEventUserState(eventAssignPO.getEventUserState());
            taskDO.setEventEndDate(eventPO.getEventEndDate());
            taskDO.setCreatedBy(eventPO.getCreatedBy());
            taskDO.setCreatedTime(eventPO.getCreatedTime());
            taskDO.setUpdatedBy(eventPO.getUpdatedBy());
            taskDO.setUpdatedTime(eventPO.getUpdatedTime());
            taskDOs.add(taskDO);
        });
        return taskDOs;
    }
}
