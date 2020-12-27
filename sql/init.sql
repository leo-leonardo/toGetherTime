create schema ToGetherTime;

-- -----------------------------------------
-- 用户信息表，登录信息另一张表
-- -----------------------------------------
drop table if exists `user`;
create table `user`
(
    id bigint auto_increment comment '主键id',
    username varchar(128) null comment '用户名',
    union_id varchar(255) not null comment '开放平台用户唯一标识',
    open_id varchar(255) not null comment '用户唯一标识',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime null on update CURRENT_TIMESTAMP comment '用户信息修改时间',
    constraint user_pk
        primary key (id)
)
    comment '用户信息表';

create unique index user_union_id_uindex
    on `user` (union_id);

-- -----------------------------------------
-- 用户日程记录表
-- -----------------------------------------
drop table if exists `schedule_weakly`;
create table `schedule_weakly`
(
    id bigint auto_increment comment '主键',
    userId bigint not null comment '用户id——谁的日程，对应user的id',
    task varchar(1000) null comment '日程事项——做什么',
    start_day int null comment '星期：0-星期日，1-星期一，6-星期六',
    start_time time null comment '当日时间',
    create_time datetime default CURRENT_TIMESTAMP not null comment '日程创建时间',
    modify_time datetime null on update CURRENT_TIMESTAMP comment '日程内容修改时间',
    constraint schedule_weakly_pk
        primary key (id)
)
    comment '用户的日程表（每周循环）';

alter table schedule_weakly change userId user_id bigint not null comment '用户id——谁的日程';

alter table schedule_weakly
    add task_id bigint null comment '事项id' after user_id;

alter table schedule_weakly change task task_name varchar(255) null comment '日程事项名——做什么';

alter table schedule_weakly change modify_time update_time datetime null on update CURRENT_TIMESTAMP comment '日程内容修改时间';

rename table schedule_weakly to schedule_weekly;

alter table schedule_weekly comment '用户的日程表（每周）';

alter table schedule_weekly
    add level int default 3 null comment '日程重要程度：1-非常重要，2-重要，3-日常' after task_name;

alter table schedule_weekly
    add status int default 1 null comment '日程安排状态：1-开启，2-关闭';


-- ---------------------------------------
-- table constructure for token——微信请求用token
-- ---------------------------------------
drop table if exists `wxAccessToken`;
create table `wxAccessToken`
(
    id int auto_increment comment '主键（应该没用）',
    access_token varchar(255) null comment '每隔一段时间获取的accessToken',
    refresh_token varchar(255) null comment '用来刷新access_token',
    expire_time datetime null comment 'token过期时间',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime null on update CURRENT_TIMESTAMP comment '上一次刷新token的时间',
    constraint wxAccessToken_pk
        primary key (id)
)
    comment '开发者使用微信接口所需accessToken';

-- --------------------------------------
-- table constructure for schedule_temp——临时事务表
-- --------------------------------------
drop table if exists schedule_temp;
create table schedule_temp
(
    id bigint auto_increment comment '自增主键',
    user_id bigint not null comment '用户id',
    task_id bigint null comment '事项id',
    task_name varchar(255) null comment '事项名',
    status int default 0 null comment '事项处理状态',
    level int default 0 null comment '事项紧急分类：0-未设定，1-紧急重要，2-紧急不重要，3-重要长期，4-日常',
    start_time datetime null comment '事项开始时间',
    end_time datetime null comment '事项结束时间',
    create_time datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime null on update current_timestamp comment '更新时间',
    constraint schedule_temp_pk
        primary key (id)
)
    comment '一次性事项';

create unique index schedule_temp_task_id_uindex
    on schedule_temp (task_id);


