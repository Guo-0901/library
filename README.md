# Library

一个基于 Spring Boot 的图书管理 REST API，用于练习后端分层与工程规范。

## 技术栈
- Spring Boot 4.1.1 / Java 17
- Spring Data JPA + MySQL
- Bean Validation（参数校验）
- Spring AOP（日志切面）

## 功能
- 图书增删改查
- 统一响应格式（`Result`）
- 全局异常处理（业务异常 / 校验异常）
- 声明式事务

## 接口
| 方法 | 路径 | 说明 |
|---|---|---|
| GET | /library | 查询全部 |
| GET | /library/{id} | 按 id 查询 |
| POST | /library | 新增 |
| PUT | /library/{id} | 修改 |
| DELETE | /library/{id} | 删除 |

## 本地运行
1. 创建 MySQL 数据库 `library`
2. 设置环境变量 `DB_PASSWORD`
3. `mvn spring-boot:run`