
通过注解的方式使用mybatis，配置两个数据源


环境准备：
1.创建两个库
库1：chaochao
spring.datasource.db1.url=jdbc:mysql://10.95.121.32:3306/chaochao
spring.datasource.db1.username=root
spring.datasource.db1.password=123456
spring.datasource.db1.driver-class-name=com.mysql.jdbc.Driver

库2：chaochao2
spring.datasource.db2.url=jdbc:mysql://10.95.121.32:3306/chaochao2
spring.datasource.db2.username=root
spring.datasource.db2.password=123456
spring.datasource.db2.driver-class-name=com.mysql.jdbc.Driver

2.创建表
库1：chaochao 中创建表t_user

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


库2：chaochao2 中创建表t_company

DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




