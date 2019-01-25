FROM java:openjdk-8-jdk
MAINTAINER Vuong Nguyen <vuongnq00291@gmail.com>

ENV APP_HOME=/opt/app/


# Install startup and shutdown scripts
RUN mkdir $APP_HOME
ADD target/insurance-assignment.jar $APP_HOME
ADD extconfig/** $APP_HOME
ADD app_service /etc/init.d
RUN chmod a+x /etc/init.d/app_service

# Expose and start SSHD
EXPOSE 8080
#CMD ["/bin/bash", "-c", "service app_service start"]

#Health check
RUN apt-get install -y curl
HEALTHCHECK CMD curl --fail http://web.element.in:8080
