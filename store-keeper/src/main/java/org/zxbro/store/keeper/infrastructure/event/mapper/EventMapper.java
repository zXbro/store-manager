package org.zxbro.store.keeper.infrastructure.event.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventPO;

@Mapper
public interface EventMapper {
    EventPO selectByEventNo(@Param("tenantId") Integer tenantId, @Param("eventNo") Long eventNo);
    void insert(EventPO eventPO);
    void deleteByEventNo(@Param("tenantId") Integer tenantId, @Param("eventNo") Long eventNo);
}
