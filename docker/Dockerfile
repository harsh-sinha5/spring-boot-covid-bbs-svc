FROM openjdk:11
RUN mkdir -p /Users/bbs-svc/
ADD bbsrv-0.0.1-SNAPSHOT.jar /Users/bbs-svc/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh