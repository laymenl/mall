# mall



# application.yml

application.yml在gitignore中，避免数据库、文件路径等自定义配置冲突

在此给出示例：

```
server:
  port: 8083
spring:
#  图片上传，静态资源映射,此处static-path-pattern暂时不支持自定义，可以改static-locations
  mvc:
    static-path-pattern: /storage/fetch/**
  resources:
    static-locations: file:F:\Documents\Works@cskaoyan\07 Project2\storage
  http:
    multipart:
      enabled=true
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mall
    username: root
    password: 123456
mybatis:
  type-handlers-package: com.cskaoyan.typehandler
pagehelper:
  helper-dialect: mysql
#springboot默认日志级别是info
logging:
  level:
    com.cskaoyan.mapper: debug
    com.cskaoyan.service: warn
# 自定义变量，用于StorageController中配置本地图片的存储位置
storage:
  path: F:\Documents\Works@cskaoyan\07 Project2\storage
```

# 公共接口

## admin/storage/create

需要在application.yml中配置

配置项：

``` 
spring:
#  图片上传，静态资源映射,此处static-path-pattern暂时不支持自定义，可以改static-locations
  mvc:
    static-path-pattern: /storage/fetch/**
  resources:
    static-locations: file:F:\Documents\Works@cskaoyan\07 Project2\storage
```

```
# 自定义变量，用于StorageController中配置本地图片的存储位置
storage:
  path: F:\Documents\Works@cskaoyan\07 Project2\storage
```

storage.path 要和 spring.resources.static-locations中的路径一致。