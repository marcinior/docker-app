FROM java:8
LABEL maintainer='Marcin Bobel'
COPY ./mysql-connector-java-5.1.6.jar mysql-connector-java-5.1.6.jar
COPY ./mysql.java mysql.java
RUN ["javac", "mysql.java"]
