package org.zxbro.store.keeper.infrastructure.event.mapper

import org.zxbro.store.keeper.StoreManagerApplication
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventPO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = StoreManagerApplication.class)
@ActiveProfiles("local")
class EventMapperTest extends Specification {
    @Autowired
    private EventMapper eventMapper;

    def "queryById"() {
        given:
        def tenantId = 1
        def eventNo = 1
        eventMapper.insert(new EventPO(
                tenantId:tenantId,
                eventNo:eventNo,
                eventType: 1,
                eventTitle: "test",
                eventContent: "test test test",
                eventLevel: 1,
                eventState: 0,
                eventEndDate: new Date(),
                version: 0,
                createdBy: "Test",
                createdTime: new Date(),
                updatedBy: "test",
                updatedTime: new Date()
        ))
        when:
        def result = eventMapper.selectByEventNo(tenantId, eventNo)
        then:
        result != null
        cleanup:
        eventMapper.deleteByEventNo(tenantId, eventNo)
    }
}
