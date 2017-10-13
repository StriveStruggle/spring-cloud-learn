spring-cloud-learn
#####1.服务注册中心（eureka-server）,可搭建高可用的集群配置
#####2.服务提供者（compute-service）,提供接口供调用
#####3.ribbin-consumer(客户端负载均衡，通过轮询的方式调用compute-service服务)
#####4.feign-consumer(在ribbin的基础之上，也即客户端负载均衡调用)