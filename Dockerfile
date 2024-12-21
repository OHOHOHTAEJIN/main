# 1. OpenJDK 이미지에서 빌드 단계
FROM openjdk:17-jdk-slim AS build

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드 파일 복사
COPY main/build/libs/*.jar app.jar

# 컨테이너를 8001번 포트로 하겠다.
EXPOSE 8001

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]