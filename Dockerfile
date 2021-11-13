FROM openjdk:8
WORKDIR /app
COPY lib /app/lib/
COPY uber-com.zuhlke.jar /app/uber-com.zuhlke.jar

ENTRYPOINT ["java","-cp", "/app/uber-com.zuhlke.jar:/app/lib/*", "zuhlke.RunTest" ]