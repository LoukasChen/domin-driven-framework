# 领域驱动业务框架
## 分层架构：
### client（客户端层）：声明对外暴露的RPC接口，尽量不要依赖三包jar包。
### common（公共层）：应用内部定义的常量类、枚举、统一异常、AOP等。
### core（核心层）：Manager类定义、流程编排、上下文初始化、幂等处理、分布式锁处理。
### domain（领域层）：业务的领域模型、业务扩展点的定义和实现。
### infrastructure（基础设施层）：外部依赖注入和防腐。如：RPC接口的Wrapper定义、Redis资源注入、MyBatis注入等。
### service（服务层）：实现client层的API接口，调用core的manager类，出入参的模型转换。
### start（启动层）：容器启动模块（Spring Boot等）。