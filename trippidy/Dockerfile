FROM payara/server-full:6.2023.11-jdk17

USER root
ENV PAYARA_ARGS --debug
#COPY postgresql-42.5.4.jar /tmp
#RUN echo 'cd /tmp' >> $POSTBOOT_COMMANDS

RUN apt-get update && apt-get install curl -y
RUN curl -o /tmp/postgresql-42.5.4.jar -sO https://jdbc.postgresql.org/download/postgresql-42.5.4.jar

#RUN echo 'apt-get install curl' >> $POSTBOOT_COMMANDS
#RUN echo 'curl -o /tmp/postgresql-42.5.4.jar -sO https://jdbc.postgresql.org/download/postgresql-42.5.4.jar' >> $POSTBOOT_COMMANDS

RUN echo 'add-library /tmp/postgresql-42.5.4.jar' >> $POSTBOOT_COMMANDS
RUN echo 'create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --driverclassname org.postgresql.Driver --restype javax.sql.DataSource --property user=admin:password=admin:URL="jdbc\\:postgresql\\://db/postgres" trippidyPool' >> $POSTBOOT_COMMANDS
RUN echo 'ping-connection-pool trippidyPool' >> $POSTBOOT_COMMANDS
RUN echo 'create-jdbc-resource --connectionpoolid trippidyPool jdbc/trippidy' >> $POSTBOOT_COMMANDS
#RUN echo 'create-auth-realm --classname=com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm --property jaas-context=jdbcRealm:datasource-jndi=jdbc/onlineedu:user-table=user_account:user-name-column=username:password-column=password:group-table=user_account:group-name-column=role:digestrealm-password-enc-algorithm=SHA-256:encoding=Base64 onlineEduRealm' >> $POSTBOOT_COMMANDS
#COPY deployment/*.war $DEPLOY_DIR