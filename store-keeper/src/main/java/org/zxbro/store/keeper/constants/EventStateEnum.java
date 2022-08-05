package org.zxbro.store.keeper.constants;

public enum EventStateEnum {
    /**
     * 新建
     */
    CREATE,
    /**
     * 挂起
     * 提交挂起原因
     */
    HANG_UP,
    /**
     * 处理中
     * 提交处理进度
     */
    PROCESSING,
    /**
     * 完成
     * 提交完成证迹
     */
    FINISH,
    /**
     * 拒绝
     */
    REJECT,
    /**
     * 重启
     */
    REOPEN,
    /**
     * 归档
     */
    ARCHIVE,
}
