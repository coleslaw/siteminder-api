#!/bin/bash
echo "   ********** Init Database: Start **********************"
service mysql start

#ps ax | grep mysql

mysql --version


mysql -uroot  -e "create database hospitality-dev"

mysql -uroot   imperial < /mysql/init_dump.sql

#mysql -uroot -e "select * from imperial.schema_version"

echo "   ********** Init Database: End ************************"

