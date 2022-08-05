package org.zxbro.store.keeper.infrastructure.event.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zxbro.store.keeper.infrastructure.event.mapper.model.EventAssignPO;

import java.util.List;

@Mapper
public interface EventAssignMapper {
    void insert(@Param("eventAssigns") List<EventAssignPO> eventAssignPOList);

    List<EventAssignPO> selectByUserNo(@Param("tenantId") Integer tenantId, @Param("userNo") Long userNo);

    void deleteById(@Param("tenantId") Integer tenantId, @Param("userNo") Long userNo, @Param("eventNo") Long eventNo);
}
