package org.zxbro.store.keeper.utils;

import org.zxbro.store.keeper.biz.model.UserDO;

public class TokenUtils {
    public static UserDO.UserId parseUserId(){
        return UserDO.UserId.builder()
                .tenantId(1)
                .userNo(1L)
                .build();
    }
}
