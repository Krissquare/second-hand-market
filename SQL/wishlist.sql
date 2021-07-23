DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
                               `w_Id` int(100) NOT NULL AUTO_INCREMENT,
                               `u_Account` varchar(255) DEFAULT NULL,
                               `p_Id` int(100) DEFAULT NULL,
                               PRIMARY KEY (`w_Id`),
                               foreign key(p_Id) references product(p_Id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;