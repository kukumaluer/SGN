   create sequence hibernate_sequence minvalue 1000;
    create table users (
        user_type 	varchar(31) not null,
        id		 	integer not null,
        email 		varchar(255),
        enabled 	boolean not null,
        first_name 	varchar(255), 
        last_name 	varchar(255),
        password 	varchar(255),
        username 	varchar(255) unique not null,
        primary key (id)
    );
    create table comments (
        cid			integer not null,
        post 		varchar(255),
        time 		timestamp,
        post_by 	integer,
        primary key (cid)
    );
    
     create table groups (
        id 			integer not null,
        category 	varchar(255),
        group_name 	varchar(255),
        isPublic 	boolean not null,
        owner_id 	integer,
        primary key (id)
    );
    
    create table groups_users(
    groups_id		integer not null,
    groupFriends_id	integer not null
    );
    
    alter table groups_users
    	add constraint UK_if unique (groupFriends_id);
    	
    alter table comments 
        add constraint fk_post_by 
        foreign key (post_by) 
        references users;

    alter table comments 
        add constraint FK_cid 
        foreign key (cid) 
        references groups;

    alter table groups 
        add constraint FK_owner_id 
        foreign key (owner_id) 
        references users;

    alter table groups_users 
        add constraint FK_groupFriends_id 
        foreign key (groupFriends_id) 
        references users;
	alter table groups_users 
        add constraint FK_groups_id 
        foreign key (groups_id) 
        references groups;
   
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password, username)
VALUES (1, 'ROLE_USER', 'email@email.com', true, 'Joe', 'Dirt','abcd','jay');
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password, username)
VALUES (2, 'ROLE_USER', 'gmail@gmail.com', true, 'Jane', 'Dirt','abcd','jane');

INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(1, 'sports', 'Lakers', true, 1);

INSERT INTO groups_users(groups_id, groupFriends_id)
VALUES(1,2);

    
    