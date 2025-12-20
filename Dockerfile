FROM oraclelinux:9

RUN dnf install -y java-25-openjdk && \
    dnf clean all

COPY target/*.jar app.jar

EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]
