# 1. Java 17 JDK 기반 이미지 사용
FROM eclipse-temurin:17-jdk-alpine

# 2. 애플리케이션 실행 시 사용할 임시 디렉토리 생성
VOLUME /tmp

# 3. 빌드된 JAR 파일의 위치 지정
ARG JAR_FILE=target/*.jar

# 4. JAR 파일을 컨테이너 내부로 복사
COPY ${JAR_FILE} app.jar

# 5. 컨테이너 시작 시 JAR 파일 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]