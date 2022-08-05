package org.zxbro.store.keeper.infrastructure.event.service;

import org.zxbro.store.keeper.infrastructure.event.mapper.EventMapper;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventMapper eventMapper;

    public void addEvent(EventPO eventPO) {
        eventMapper.insert(eventPO);
    }

    public EventPO queryByEventNo(Integer tenantId,Long eventNo){
        return eventMapper.selectByEventNo(tenantId,eventNo);
    }
}
