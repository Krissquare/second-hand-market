DROP TABLE IF EXISTS `userHead`;
CREATE TABLE `userHead`
(
    `u_Url`     varchar(100),
    `u_Account` varchar(100) NOT NULL,
    PRIMARY KEY (`u_Account`),
    foreign key(u_Account) references `user`(`u_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `userhead` (`u_Url`, `u_Account`)
VALUES ('/images/user/default2.jpg', 'admin');
INSERT INTO `userhead` (`u_Url`, `u_Account`)
VALUES ('/images/user/default4.jpg', 'user1');
INSERT INTO `userhead` (`u_Url`, `u_Account`)
VALUES ('/images/user/default4.jpg', 'user2');
INSERT INTO `userhead` (`u_Url`, `u_Account`)
VALUES ('/images/user/default4.jpg', 'user3');

