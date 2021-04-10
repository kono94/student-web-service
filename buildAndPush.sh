mvn clean package
docker build -t kono94/spring-student-soap-service .
docker push kono94/spring-student-soap-service:latest
