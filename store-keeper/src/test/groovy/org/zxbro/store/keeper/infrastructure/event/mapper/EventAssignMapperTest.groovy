package org.zxbro.store.keeper.infrastructure.event.mapper

import org.assertj.core.util.Lists
import org.zxbro.store.keeper.StoreManagerApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventAssignPO
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = StoreManagerApplication.class)
@ActiveProfiles("local")
class EventAssignMapperTest extends Specification {
    @Autowired
    private EventAssignMapper eventAssignMapper

    def "insert"() {
        given:
        def tenantId = 1
        def eventNo = 1
        def eventNo2 = 2
        def user1 = 1
        def user2 = 2
        eventAssignMapper.insert(Lists.newArrayList(
                new EventAssignPO(
                        tenantId: tenantId,
                        eventNo: eventNo,
                        assignToUserNo: user1,
                        eventUserState: 1,
                        createdBy: "Test",
                        createdTime: new Date(),
                        updatedBy: "Test",
                        updatedTime: new Date()
                ),
                new EventAssignPO(
                        tenantId: tenantId,
                        eventNo: eventNo2,
                        assignToUserNo: user1,
                        eventUserState: 1,
                        createdBy: "Test",
                        createdTime: new Date(),
                        updatedBy: "Test",
                        updatedTime: new Date()
                ),
                new EventAssignPO(
                        tenantId: tenantId,
                        eventNo: eventNo,
                        assignToUserNo: user2,
                        eventUserState: 1,
                        createdBy: "Test",
                        createdTime: new Date(),
                        updatedBy: "Test",
                        updatedTime: new Date()
                )
        ))
        when:
        def result1 = eventAssignMapper.selectByUserNo(tenantId, user1)
        def result2 = eventAssignMapper.selectByUserNo(tenantId, user2)
        then:
        result1.size() == 2 && result2.size() == 1
        cleanup:
        eventAssignMapper.deleteById(tenantId, eventNo, user1)
        eventAssignMapper.deleteById(tenantId, eventNo2, user1)
        eventAssignMapper.deleteById(tenantId, eventNo, user2)
    }
}


