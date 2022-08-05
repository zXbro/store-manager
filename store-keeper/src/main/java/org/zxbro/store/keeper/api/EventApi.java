package org.zxbro.store.keeper.api;

import lombok.extern.slf4j.Slf4j;
import org.zxbro.store.keeper.api.model.EventVO;
import org.zxbro.store.keeper.biz.EventBiz;
import org.zxbro.store.keeper.biz.model.EventDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/event")
@Validated
@Slf4j
public class EventApi {
    @Autowired
    private EventBiz eventBiz;

    @PostMapping(value = "/submit")
    public void submit(@Valid @RequestBody EventVO eventVO) {
        log.info("create event:{}", eventVO);
        EventDO eventDO = EventDO.buildFrom(eventVO);
        eventDO.setCreatedBy("Test");
        Date current = new Date();
        eventDO.setTenantId(1);
        eventDO.setEventNo(System.currentTimeMillis());
        eventDO.setEventState(0);
        eventDO.setCreatedTime(current);
        eventDO.setUpdatedBy("Test");
        eventDO.setUpdatedTime(current);
        eventBiz.createEvent(eventDO);
    }
}
