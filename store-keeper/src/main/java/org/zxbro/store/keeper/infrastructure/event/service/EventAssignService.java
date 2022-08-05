package org.zxbro.store.keeper.infrastructure.event.service;

import org.zxbro.store.keeper.infrastructure.event.mapper.EventAssignMapper;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventAssignPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAssignService {
    @Autowired
    private EventAssignMapper eventAssignMapper;

    public void insert(List<EventAssignPO> eventAssignPOList) {
        eventAssignMapper.insert(eventAssignPOList);
    }

    public List<EventAssignPO> listByUserNo(Integer tenantId,Long userNo){
        return eventAssignMapper.selectByUserNo(tenantId,userNo);
    }
}
