**20210707**

* mybatis重新生成代码时，需要先清空xml等文件，否则会重复生成。
* 测试接口时，暂时去掉security依赖，否则会产生unauthorized。

* Swaggerui：swagger3使用的库与之前不同，另外网址为/swagger-ui/

**20210709**

* redis内存数据库用于验证码的生成，保存，管理。但还不算所谓的缓存。
* spring提供缓存，由多种机制，包括redis等，todo。

* LOGGER： todo。


**20210714**

Security

* SecurityConfig
    * httpSecurity configure
        * JWTFilter
            * 继承OncePerRequestFilter接口
            * 实现doFilterInternal方法
            * 验证token
            * 成功则设置用户权限
        * ExceptionHandler
    * auth configure
        * 实现UserDetailsService接口的类
        * 实现loadUserByUsername方法
        * 返回实现了UserDetails接口的类的对象
            * 其中包括用户名，密码，权限等。
        * 这个对象会在http configure中使用
    
* 需要在config中配置 swagger无需授权访问，否则打不开swagger
* 遇到一个bug
    * /permission/adminId postman测试成功，swagger失败。
        * 该接口只需登陆即可，不需要权限。
    * 但是其余需要权限的反而都能测试成功。
    

**20210922**

关于运行测试，需要登录用户名密码。
