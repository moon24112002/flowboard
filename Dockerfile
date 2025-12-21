# ---------- BUILD STAGE ----------
FROM oraclelinux:9 AS build

WORKDIR /app

# Install Java only (NO system Maven needed)
RUN dnf install -y java-21-openjdk-devel && dnf clean all

# Copy Maven wrapper + config first
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build
RUN ./mvnw clean package -Dmaven.test.skip=true


# ---------- RUNTIME STAGE ----------
FROM oraclelinux:9

WORKDIR /app

RUN dnf install -y java-21-openjdk && dnf clean all

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
