FROM oracle/glassfish

RUN yum -y install java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5

COPY docker-entrypoint.sh /_entrypoint.sh
RUN sed -i 's/\r//' _entrypoint.sh
ENTRYPOINT ["/_entrypoint.sh"]

EXPOSE 4848 8080

CMD ["asadmin", "start-domain", "-v"]