package org.zxbro.store.keeper.biz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDO {
    private UserId userId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserId{
        private Integer tenantId;
        private Long userNo;
    }
}
