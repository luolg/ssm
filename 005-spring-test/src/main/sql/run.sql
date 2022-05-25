create database test;


CREATE TABLE `sys_role` (
                            `id` int(55) NOT NULL AUTO_INCREMENT,
                            `roleName` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            `roleDesc` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into `sys_role` (`id`, `roleName`, `roleDesc`) values('1','boss','big boss');
insert into `sys_role` (`id`, `roleName`, `roleDesc`) values('2','cto','tech leader');
insert into `sys_role` (`id`, `roleName`, `roleDesc`) values('3','engineer','dev');
insert into `sys_role` (`id`, `roleName`, `roleDesc`) values('4','qa','test case');





CREATE TABLE `sys_user` (
                            `id` int(55) NOT NULL AUTO_INCREMENT,
                            `username` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            `email` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            `password` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            `phoneNum` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                            KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

insert into `sys_user` (`id`, `username`, `email`, `password`, `phoneNum`) values('17','jack','jack@jack','jack123','111');
insert into `sys_user` (`id`, `username`, `email`, `password`, `phoneNum`) values('18','rose','rose@rose','rose123','222');
insert into `sys_user` (`id`, `username`, `email`, `password`, `phoneNum`) values('19','gang','gang@gang','gang123','333');





CREATE TABLE `sys_user_role` (
                                 `userId` varchar(55) CHARACTER SET latin1 DEFAULT NULL,
                                 `roleId` varchar(55) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `sys_user_role` (`userId`, `roleId`) values('17','1');
insert into `sys_user_role` (`userId`, `roleId`) values('17','2');
insert into `sys_user_role` (`userId`, `roleId`) values('17','3');
insert into `sys_user_role` (`userId`, `roleId`) values('17','4');
insert into `sys_user_role` (`userId`, `roleId`) values('18','2');
insert into `sys_user_role` (`userId`, `roleId`) values('18','3');
insert into `sys_user_role` (`userId`, `roleId`) values('19','4');
