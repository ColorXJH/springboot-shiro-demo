--tb_users
insert into tb_users (ID, USERNAME, PASSWORD, SALT, LOCKED)
values ('1', 'ColorXJH', '12345678', '1', 0);

insert into tb_users (ID, USERNAME, PASSWORD, SALT, LOCKED)
values ('2', 'DearBear', '6603300', '2', 0);

insert into tb_users (ID, USERNAME, PASSWORD, SALT, LOCKED)
values ('3', 'MissBear', '123456', '3', 0);


--tb_roles
insert into tb_roles (ID, ROLE, DESCRIPTION, AVAILABLE)
values ('1', 'admin', '管理员', 1);

insert into tb_roles (ID, ROLE, DESCRIPTION, AVAILABLE)
values ('2', 'user', '用户', 1);

insert into tb_roles (ID, ROLE, DESCRIPTION, AVAILABLE)
values ('3', 'mang', '操作员', 1);

insert into tb_roles (ID, ROLE, DESCRIPTION, AVAILABLE)
values ('4', 'guide', '游客', 1);


--tb_users_roles
insert into tb_users_roles (USER_ID, ROLE_ID)
values ('1', '1');

insert into tb_users_roles (USER_ID, ROLE_ID)
values ('1', '2');

insert into tb_users_roles (USER_ID, ROLE_ID)
values ('1', '3');

insert into tb_users_roles (USER_ID, ROLE_ID)
values ('1', '4');

insert into tb_users_roles (USER_ID, ROLE_ID)
values ('2', '3');

insert into tb_users_roles (USER_ID, ROLE_ID)
values ('2', '4');

--tb_permissions
insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('1', 'add', '增', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('2', 'query', '查', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('3', 'delete', '删', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('4', 'edit', '改', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('5', 'seek', '找', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('6', 'read', '读', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('7', 'write', '写', 1);

insert into tb_permissions (ID, PERMISSION, DESCRIPTION, AVAILABLE)
values ('8', 'opt', '操作', 1);


--tb_roles_permissions
insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('1', '1');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('1', '2');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('2', '3');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('2', '4');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('3', '5');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('3', '6');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('4', '7');

insert into tb_roles_permissions (ROLE_ID, PERMISSION_ID)
values ('4', '8');