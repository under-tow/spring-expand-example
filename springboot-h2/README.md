# SpringBoot整合h2数据库

### 1. POM依赖
h2为嵌入式数据库，不需要单独部署，需要在pom中引入h2依赖即可
```xml    
  <dependency>    <groupId>com.h2database</groupId>      
<artifactId>h2</artifactId>    <scope>runtime</scope>  </dependency>  
```

### 2. 配置文件

#### 配置数据库
h2有两个模式 ，可以在配置文件的url控制
- 磁盘模式
- 内存模式

#### 配置sql初始化
程序启动后，h2数据库随之创建并启动，可以在启动时指定sql文件初始化

```yml  
spring:  
  # 可选（引入jpa时可以防止初始化冲突，酌情配置）  
#  jpa:  
#    hibernate:  
#      ddl-auto: none # 关闭 Hibernate 的自动建表功能，避免与 schema.sql 冲突  
  sql:  
    init:  
#      mode: embedded # 嵌入式数据库时才执行初始化脚本 (h2磁盘模式不认为是嵌入式数据库，不会初始化)  
      mode: always # 启动始终执行  
      schema-locations: classpath:schema.sql # 用于执行表结构初始化，默认为：classpath:schema.sql，也可以自定义路径  
#      data-locations: classpath:data.sql # 数据初始化 sql，默认为：classpath:data.sql，也可以自定义路径  
  h2:  
    console:  
      enabled: true  
      path: /h2-console # h2 控制台地址  
  datasource:  
    # 磁盘模式，保存路径在jar同级的data目录  
#    url: jdbc:h2:file:./springboot-h2/data/myh2db;  
    # 内存模式  
    url: jdbc:h2:mem:test-db  
    driver-class-name: org.h2.Driver  
    username: admin  
    password: 123456
```

### 3. 访问web界面
http://localhost:8080/h2-console/