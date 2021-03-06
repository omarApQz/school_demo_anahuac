FROM openjdk
WORKDIR /root/
ARG PATH_FOLDER
ADD $PATH_FOLDER/school-0.0.1-SNAPSHOT.jar school-0.0.1-SNAPSHOT.jar
RUN rm -f /etc/localtime
RUN ln -sf /usr/share/zoneinfo/America/Mexico_City /etc/localtime
EXPOSE 8080
ARG SPRING_ENV
ENV SPRING_ENV=$SPRING_ENV
CMD java -jar school-0.0.1-SNAPSHOT.jar