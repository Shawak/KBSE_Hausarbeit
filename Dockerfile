FROM oracle/glassfish

COPY docker-entrypoint.sh /_entrypoint.sh
RUN sed -i 's/\r//' _entrypoint.sh
ENTRYPOINT ["/_entrypoint.sh"]

EXPOSE 4848 8080

CMD ["asadmin", "start-domain", "-v"]