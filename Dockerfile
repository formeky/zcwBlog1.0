# 基础镜像使用java
FROM java:8
# 将jar包添加到容器中并更名为app.jar
ADD *.jar app.jar
# 运行jar包
ENTRYPOINT ["java","-jar","/app.jar"]