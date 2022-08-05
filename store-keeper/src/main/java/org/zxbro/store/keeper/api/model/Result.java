package org.zxbro.store.keeper.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    private Boolean success;
    private String code;
    private String message;

    public static Result ok() {
        return Result.builder().success(true).build();
    }
}
