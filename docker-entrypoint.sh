#!/bin/bash
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
# 
# Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
if [[ -z $ADMIN_PASSWORD ]]; then
  ADMIN_PASSWORD=$(date| md5sum | fold -w 8 | head -n 1)
  echo "##########GENERATED ADMIN PASSWORD: $ADMIN_PASSWORD  ##########"
fi
echo "AS_ADMIN_PASSWORD=" > /tmp/glassfishpwd
echo "AS_ADMIN_NEWPASSWORD=${ADMIN_PASSWORD}" >> /tmp/glassfishpwd
asadmin --user=admin --passwordfile=/tmp/glassfishpwd change-admin-password --domain_name domain1
asadmin start-domain
echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" > /tmp/glassfishpwd
asadmin --user=admin --passwordfile=/tmp/glassfishpwd enable-secure-admin

# create the connection pool by cli
asadmin start-database
asadmin --user=admin --passwordfile=/tmp/glassfishpwd create-jdbc-connection-pool --datasourceclassname org.apache.derby.jdbc.ClientDataSource --restype javax.sql.DataSource --property portNumber=1527:password=Administrator:user=Administrator:serverName=localhost:databaseName=SuperCar:connectionAttributes=\;create\\=true SuperCarPool

# ping it once to trigger the create=true
asadmin --user=admin --passwordfile=/tmp/glassfishpwd ping-connection-pool SuperCarPool

# deploy
cp /app/supercar-1.0.war /glassfish5/glassfish/domains/domain1/autodeploy/supercar.war

asadmin --user=admin stop-domain
rm /tmp/glassfishpwd
exec "$@"