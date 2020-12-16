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

-- ---------------------------------------
-- table constructure for token
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


