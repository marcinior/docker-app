FROM java:8
LABEL maintainer='Marcin Bobel'
COPY ./mysql-connector.jar mysql-connector.jar
COPY ./mysql.java mysql.java
RUN ["javac", "mysql.java"]
