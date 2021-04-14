##拉取镜像
FROM openjdk:8-alpine

#作者
MAINTAINER hhf@123.com

##暴露端口
EXPOSE 8001

ADD /target/dandan-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT \
java \
-jar \
/app.jar \