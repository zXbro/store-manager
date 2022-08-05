package org.zxbro.store.keeper.api.model;

import lombok.Data;

import java.util.List;

@Data
public class TaskSubmitReq {
    private String eventState;
//    private List<String> imageUrls;
//    private List<String> fileList;
    private String remark;
}
