FROM maven:3.5-jdk-8-alpine
RUN ls -l
WORKDIR /usr/src/Agents_e5a
COPY . /usr/src/Agents_e5a/
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8080
CMD ["java", "-jar", "target/agents_e5a-0.0.1.jar"]