# 🚀 1. 빌드 스테이지: Gradle로 Spring Boot JAR 빌드
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app

# Gradle 캐시 활용을 위한 설정
COPY build.gradle settings.gradle /app/
COPY gradle /app/gradle
RUN gradle clean --no-daemon

# 전체 프로젝트 복사 후 빌드
COPY . /app
RUN gradle clean build -x test --no-daemon

# 🚀 2. 실행 스테이지: JAR만 복사해서 실행
FROM eclipse-temurin:17-jdk
WORKDIR /app

# 빌드 결과물 JAR 복사
COPY --from=builder /app/build/libs/certistage-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
