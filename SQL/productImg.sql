DROP TABLE IF EXISTS `productImg`;
CREATE TABLE `productImg`
(
    `p_Id` int(100),
    `p_href` varchar(255),
    PRIMARY KEY (`p_Id`,`p_href`),
    foreign key(p_Id) references `product`(`p_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;