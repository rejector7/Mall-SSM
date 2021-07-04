**Project Architecture**


* entity: for database
* dto: data transfer object: for front-backend data transfer
* mbg: mybatis generator


**Mybatis**

* mapper.xml (s): mapping repo methods to sql: O-R mapping
* mapper 接口: repo
* model: entity
* generatorConfig.xml: 控制生成mapper等文件的配置文件
* Generator.java: 通过generatorConfig来生成代码

* 其他：自动生成器一般只能生成单表查询，对于多表查询等还需要手写mapper。

* xml文件存放于resouce目录
* java文件存放于java目录


