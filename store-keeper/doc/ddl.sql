create table if not exists event
(
    event_id bigint auto_increment comment '事件ID'
        primary key,
    tenant_id int not null comment '租户ID',
    event_no bigint not null comment '事件编号',
    event_type int not null comment '事件类型',
    event_title varchar(200) not null comment '事件标题',
    event_content varchar(500) null comment '事件内容',
    assign_tos_str varchar(200) null comment '指派给',
    event_level int not null comment '事件级别',
    event_end_date datetime null comment '事件截止日期',
    version int default 0 not null comment '版本号',
    created_by varchar(50) not null comment '创建人',
    created_time datetime not null comment '创建时间',
    updated_by varchar(50) not null comment '更新人',
    updated_time datetime not null comment '更新时间',
    event_state int not null,
    constraint UNI_TENANT_EVENT_NO
        unique (tenant_id, event_no)
);

create table if not exists event_assign
(
    event_assign_id bigint auto_increment,
    tenant_id int not null comment '租户编号',
    event_no bigint not null comment '事件编号',
    assign_to_user_no bigint not null comment '分配用户编号',
    event_user_state int not null,
    created_by varchar(50) not null comment '创建人',
    created_time datetime not null comment '创建时间',
    updated_by varchar(50) not null comment '创建人',
    updated_time datetime not null comment '创建时间',
    constraint event_assign_event_assign_id_uindex
        unique (event_assign_id),
    constraint uniq_event_assign
        unique (tenant_id, event_no, assign_to_user_no)
)
    comment '任务分配表';

alter table event_assign
    add primary key (event_assign_id);

create table if not exists event_assign_his
(
    event_assign_id bigint auto_increment,
    tenant_id int not null comment '租户编号',
    event_no bigint not null comment '事件编号',
    assign_to_user_no bigint not null comment '分配用户编号',
    event_user_state int not null,
    created_by varchar(50) not null comment '创建人',
    created_time datetime not null comment '创建时间',
    updated_by varchar(50) not null comment '创建人',
    updated_time datetime not null comment '创建时间',
    constraint event_assign_event_assign_id_uindex
        unique (event_assign_id),
    constraint uniq_event_assign
        unique (tenant_id, event_no, assign_to_user_no)
)
    comment '任务分配表';

alter table event_assign_his
    add primary key (event_assign_id);

