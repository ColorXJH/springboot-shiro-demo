--1.tb_users
-- Create table

drop table   tb_users;
drop table   tb_roles;
drop table   tb_users_roles;
drop table   tb_permissions;
drop table   tb_roles_permissions;

create table TB_USERS
(
  id       VARCHAR2(10) not null,
  username VARCHAR2(100),
  password VARCHAR2(100),
  salt     VARCHAR2(100),
  locked   NUMBER default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_USERS
  add constraint PK_TB_USERS primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


--2.TB_ROLES

  -- Create table
create table TB_ROLES
(
  id          VARCHAR2(10) not null,
  role        VARCHAR2(100),
  description VARCHAR2(100),
  available   NUMBER default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate indexes
create unique index IDX_TB_ROLES_ROLE on TB_ROLES (ROLE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_ROLES
  add constraint PK_SYS_ROLES primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

--3. TB_USERS_ROLES

-- Create table
create table TB_USERS_ROLES
(
  user_id VARCHAR2(10) not null,
  role_id VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_USERS_ROLES
  add constraint PK_TB_USERS_ROLES primary key (USER_ID, ROLE_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


--4.TB_PERMISSIONS

-- Create table
create table TB_PERMISSIONS
(
  id          VARCHAR2(10) not null,
  permission  VARCHAR2(100),
  description VARCHAR2(100),
  available   NUMBER default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate indexes
create unique index IDXINS_PERMISSION on TB_PERMISSIONS (PERMISSION)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_PERMISSIONS
  add constraint PK_SYS_PERMISSIONS primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

--5.TB_ROLES_PERMISSIONS

-- Create table
create table TB_ROLES_PERMISSIONS
(
  role_id       VARCHAR2(10) not null,
  permission_id VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_ROLES_PERMISSIONS
  add constraint PK_PISSIONS primary key (ROLE_ID, PERMISSION_ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
