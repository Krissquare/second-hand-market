CREATE TABLE `userHead` (
                            `u_Url` varchar(100),
                            `u_Account` varchar(100) NOT NULL,
                            PRIMARY KEY (`u_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `userhead` (`u_Url`, `u_Account`) VALUES ('/images/user/default4.jpg', 'user1');
