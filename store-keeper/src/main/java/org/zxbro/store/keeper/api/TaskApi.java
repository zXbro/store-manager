package org.zxbro.store.keeper.api;

import lombok.extern.slf4j.Slf4j;
import org.zxbro.store.keeper.api.model.Result;
import org.zxbro.store.keeper.api.model.TaskSubmitReq;
import org.zxbro.store.keeper.api.model.TaskVO;
import org.zxbro.store.keeper.biz.EventBiz;
import org.zxbro.store.keeper.biz.model.TaskDO;
import org.zxbro.store.keeper.infrastructure.file.FileUploadService;
import org.zxbro.store.keeper.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/task")
@Slf4j
public class TaskApi {
    @Autowired
    private EventBiz eventBiz;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping(value = "/list")
    public List<TaskVO.TaskDetailVO> list(HttpServletRequest httpServletRequest) {
        List<TaskDO> taskDOList = eventBiz.listEventByAssign(TokenUtils.parseUserId());
        if (taskDOList == null) {
            return null;
        }
        return taskDOList.stream().map(taskDO -> {
            TaskVO.TaskDetailVO taskDetailVO = new TaskVO.TaskDetailVO();
            taskDetailVO.setEventNo(taskDO.getEventNo());
            taskDetailVO.setEventTitle(taskDO.getEventTitle());
            taskDetailVO.setEventContent(taskDO.getEventContent());
            taskDetailVO.setEventLevel(taskDO.getEventLevel());
            taskDetailVO.setEventState(taskDO.getEventUserState());
            return taskDetailVO;
        }).collect(Collectors.toList());
    }

    /**
     * 接受任务（可进行任务信息的初步处理，页面无完成逻辑）
     * @param taskSubmitReq
     * @return
     */
    @PostMapping(value = "/accept")
    public Result accpet(@RequestBody TaskSubmitReq taskSubmitReq) {
        log.info("{}", taskSubmitReq);

        return Result.ok();
    }

    /**
     * 处理任务（可重复提交，状态标记为完成时意味着任务最终提交）
     * @param taskSubmitReq
     * @return
     */
    @PostMapping(value = "/submit")
    public Result submit(@RequestBody TaskSubmitReq taskSubmitReq) {
        log.info("{}", taskSubmitReq);

        return Result.ok();
    }

    @PostMapping(value= "/deny")
    public Result deny(@RequestBody int i){
        return Result.ok();
    }

    @PostMapping(value = "/image/aupload")
    public Result imageUpload(HttpServletRequest request, @RequestParam MultipartFile file) {
        log.info("test image upload");
//        fileUploadService.postImage();
        return Result.ok();
    }
}
