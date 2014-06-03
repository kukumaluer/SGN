   create sequence hibernate_sequence minvalue 1000;
    create table users (
        user_type 	varchar(31) not null,
        id		 	integer not null,
        email 		varchar(255) unique not null,
        enabled 	boolean not null,
        first_name 	varchar(255), 
        last_name 	varchar(255),
        password 	varchar(255),
        primary key (id)
    );
    create table comments (
        cid			integer not null,
        post 		varchar(500),
        time 		timestamp,
        post_by 	integer,
        group_id	integer,
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
    
    create table group_friend_id(
    	id			integer not null,
    	group_id	integer not null,
    	friend_id	integer not null,
   		primary key(id)
    );
    
    create table notifications (
        id 					integer not null,
        friend_to_add_id 	integer,
        adding_group_id 	integer,
        notify_user_id 		integer,
        primary key (id)
    );
    
    
    	
    alter table comments 
        add constraint fk_post_by 
        foreign key (post_by) 
        references users;

    alter table comments 
        add constraint FK_post_by_id 
        foreign key (group_id) 
        references groups;

    alter table groups 
        add constraint FK_owner_id 
        foreign key (owner_id) 
        references users;

    alter table group_friend_id 
        add constraint FK_friendId_id 
        foreign key (friend_id) 
        references users;
	
    alter table group_friend_id 
        add constraint FK_groups_id 
        foreign key (group_id) 
        references groups;
        
     alter table notifications 
        add constraint FK_notify_user_id 
        foreign key (notify_user_id) 
        references users;
   
        
      alter table notifications 
        add constraint FK_friend_to_add_id 
        foreign key (friend_to_add_id) 
        references users;
        
     alter table notifications 
        add constraint FK_adding_group_id 
        foreign key (adding_group_id) 
        references groups;
        
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (1, 'ROLE_USER', 'email@email.com', true, 'Joe', 'Dirt','abcd');
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (2, 'ROLE_USER', 'gmail@gmail.com', true, 'Jane', 'Dirt','abcd');
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (3, 'ROLE_USER', 'email@gmail.com', true, 'Bob', 'Doe','abcd');

INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (4, 'ROLE_USER', 'mike@email.com', true, 'Mike', 'Holloway','abcd');
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (5, 'ROLE_USER', 'yuze@email.com', true, 'Yuze', 'Hao','abcd');
INSERT INTO users(id,user_type,email,enabled, first_name, last_name, password)
VALUES (6, 'ROLE_USER', 'song@email.com', true, 'Song', 'Xiao','abcd');




INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(1, 'sports', 'Lakers', true, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(2, 'sports', 'Dodgers', true, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(3, 'sports', 'Nets', true, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(4, 'sports', 'Knicks', true, 1);

INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(5, 'sports', 'Clippers', false, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(6, 'sports', 'Thunder OKC', false, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(7, 'sports', 'Jets', false, 1);
INSERT INTO groups(id, category, group_name, isPublic, owner_id) 
VALUES(8, 'sports', 'Packers', false, 1);



INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(1,1,2);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(2,1,1);

INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(3,2,3);

INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(4,2,1);

INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(5,3,1);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(6,4,1);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(7,5,1);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(8,6,1);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(9,7,1);
INSERT INTO group_friend_id(id, group_id, friend_id)
VALUES(10,8,1);

INSERT INTO comments(cid, post, time, post_by, group_id )
VALUES(1, 'Lakers rule', current_timestamp, 2, 1);
INSERT INTO comments(cid, post, time, post_by, group_id )
VALUES(2, 'Lakers suck', current_timestamp, 3, 1);
    
    