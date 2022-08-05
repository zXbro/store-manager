package org.zxbro.store.keeper.api.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class EventVO {
    /**
     * 任务类型
     */
    @NotNull
    private Integer eventType;
    /**
     * 任务标题
     */
    @NotBlank
    @Max(50)
    private String eventTitle;
    /**
     * 任务描述
     */
    @Max(200)
    private String eventContent;
    /**
     * 事件指派给
     */
    @NotEmpty
    @Max(5)
    private List<Long> assignTos;
    /**
     * 任务级别
     */
    private Integer eventLevel;
    /**
     * 截止日期
     */
    private Date eventEndDate;
}
