
    create table comments (
        cid int4 not null,
        post varchar(255),
        time timestamp,
        group_id int4,
        post_by int4,
        primary key (cid)
    );

    create table groups (
        id int4 not null,
        category varchar(255),
        group_name varchar(255),
        isPublic boolean not null,
        owner_id int4,
        primary key (id)
    );

    create table groups_users (
        groups_id int4 not null,
        Users_id int4 not null
    );

    create table groups_users_id (
        id int4 not null,
        friend_id bytea,
        groupId  bytea,
        primary key (id)
    );

    create table users (
        user_type varchar(31) not null,
        id int4 not null,
        email varchar(255),
        enabled boolean not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        primary key (id)
    );

    alter table groups_users 
        add constraint UK_19a4wl31vp7pir17f2yjgs2d5 unique (Users_id);

    alter table comments 
        add constraint FK_f4xxgxt3wps9k29w5ipmcf8gn 
        foreign key (group_id) 
        references groups;

    alter table comments 
        add constraint FK_jxgyl9ue6pfci047j80pwpi52 
        foreign key (post_by) 
        references users;

    alter table groups 
        add constraint FK_qq2lqytvoxgtbx79j2qjqspoc 
        foreign key (owner_id) 
        references users;

    alter table groups_users 
        add constraint FK_19a4wl31vp7pir17f2yjgs2d5 
        foreign key (Users_id) 
        references users;

    alter table groups_users 
        add constraint FK_78p7vbckpk4tlwhweqwv6ymo2 
        foreign key (groups_id) 
        references groups;

    create sequence hibernate_sequence;
