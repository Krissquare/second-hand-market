#docker打包镜像
FROM java:8
MAINTAINER wzp<1017151406@qq.com>
COPY readme.txt /usr/local/readme.txt
COPY *.jar /app.jar

ENV MYPATH /usr/local
WORKDIR $MYPATH

CMD ["--server.port=8080"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]