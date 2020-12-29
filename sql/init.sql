drop database if exists `togethertime`;
create database `togethertime`;
use togethertime;
drop table if exists schedule_temp;
create table schedule_temp
(
    id          bigint auto_increment comment '自增主键'
        primary key,
    user_id     bigint                             not null comment '用户id',
    task_id     bigint                             null comment '事项id',
    task_name   varchar(255)                       null comment '事项名',
    status      int      default 1                 null comment '事项处理状态:1-等待中，2-已实行',
    level       int      default 0                 null comment '事项紧急分类：0-未设定，1-紧急重要，2-紧急不重要，3-重要长期，4-日常',
    start_time  datetime                           null comment '事项开始时间',
    end_time    datetime                           null comment '事项结束时间',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint schedule_temp_task_id_uindex
        unique (task_id)
)
    comment '一次性事项';
drop table if exists schedule_weekly;
create table schedule_weekly
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_id     bigint                             not null comment '用户id——谁的日程',
    task_id     bigint                             null comment '事项id',
    task_name   varchar(255)                       null comment '日程事项名——做什么',
    status      int      default 1                 null comment '日程安排状态：1-开启，2-关闭',
    level       int      default 3                 null comment '日程重要程度：1-非常重要，2-重要，3-日常',
    start_day   int                                null comment '星期：0-星期日，1-星期一，6-星期六',
    start_time  time                               null comment '当日时间',
    create_time datetime default CURRENT_TIMESTAMP not null comment '日程创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '日程内容修改时间'
)
    comment '用户的日程表（每周）';
drop table if exists user;
create table user
(
    id              bigint auto_increment comment '主键userId'
        primary key,
    username        varchar(128)                       null comment '用户名',
    img_url         varchar(500)                       null comment '微信用户头像',
    unionid         varchar(255)                       not null comment '平台用户唯一id',
    openid          varchar(255)                       null comment '用户唯一凭证',
    last_login_time datetime default CURRENT_TIMESTAMP not null comment '上次登录时间',
    create_time     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     datetime                           null on update CURRENT_TIMESTAMP comment '用户信息修改时间',
    constraint user_union_id_uindex
        unique (unionid)
)
    comment '用户信息表';
drop table if exists user_info;
create table user_info
(
    id             bigint                                not null comment '与user表中的user_id一致',
    level          varchar(50) default '青铜Ⅲ'             null comment '段位',
    complete_times int         default 0                 null comment '完成事项次数',
    attent_time    float       default 0                 null comment '专注时间',
    create_time    datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time    datetime                              null on update CURRENT_TIMESTAMP comment '修改时间'
)
    comment '用户信息-总结';
drop table if exists wxaccesstoken;
create table wxaccesstoken
(
    id            int auto_increment comment '主键（应该没用）'
        primary key,
    access_token  varchar(255)                       null comment '每隔一段时间获取的accessToken',
    refresh_token varchar(255)                       null comment '用来刷新access_token',
    expire_time   datetime                           null comment 'token过期时间',
    create_time   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime                           null on update CURRENT_TIMESTAMP comment '上一次刷新token的时间'
)
    comment '开发者使用微信接口所需accessToken';

