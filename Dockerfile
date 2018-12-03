FROM java:8
LABEL maintainer='Marcin Bobel'
COPY ./mysql-connector-java-8.0.13.jar mysql-connector-java-8.0.13.jar
COPY ./mysql.java mysql.java
RUN javac mysql.java
