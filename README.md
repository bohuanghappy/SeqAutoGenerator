分布式环境中生成稳定，可靠的全局唯一id，在flicker全局唯一id的基础上，引入zookeeper来区别不同应用程序所需要的id

要求：
采用spring boot实现，jdk1.8
1. 两个数据库
Seq0, Seq1

表创建规则

Seq0

`CREATE TABLE order2 (
     id bigint(20) unsigned NOT NULL auto_increment,
     stub char(1) NOT NULL default '',
     PRIMARY KEY (id),
     UNIQUE KEY stub (stub)
) ENGINE=MyISAM auto_increment=200
`

Seq1

`
CREATE TABLE order2 (
     id bigint(20) unsigned NOT NULL auto_increment,
     stub char(1) NOT NULL default '',
     PRIMARY KEY (id),
     UNIQUE KEY stub (stub)
) ENGINE=MyISAM auto_increment=201
`
2. 在zookeeper上配置对应的token节点，节点数据为order2

3. 访问url: http:localhost:8080/seq/service/token


