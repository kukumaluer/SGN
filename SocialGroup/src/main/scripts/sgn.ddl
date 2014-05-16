
    create table comments (
        cid int4 not null,
        post varchar(255),
        time timestamp,
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
        groupFriends_id int4 not null
    );

    create table users (
        user_type varchar(31) not null,
        id int4 not null,
        email varchar(255),
        enabled boolean not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table groups_users 
        add constraint UK_aggxt0dr5kximpf1qnm63f3iv unique (groupFriends_id);

    alter table comments 
        add constraint FK_jxgyl9ue6pfci047j80pwpi52 
        foreign key (post_by) 
        references users;

    alter table comments 
        add constraint FK_jxgyl9ue6pfci047j80pwpi52 
        foreign key (post_by) 
        references groups;

    alter table groups 
        add constraint FK_qq2lqytvoxgtbx79j2qjqspoc 
        foreign key (owner_id) 
        references users;

    alter table groups_users 
        add constraint FK_aggxt0dr5kximpf1qnm63f3iv 
        foreign key (groupFriends_id) 
        references users;

    alter table groups_users 
        add constraint FK_78p7vbckpk4tlwhweqwv6ymo2 
        foreign key (groups_id) 
        references groups;

    create sequence hibernate_sequence;
