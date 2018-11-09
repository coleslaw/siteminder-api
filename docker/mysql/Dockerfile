FROM mysql:5.7

ADD my.cnf /etc/mysql/my.cnf
CMD ["mysqld", "--datadir=/var/lib/mysql", "--user=mysql"]

#ADD 1-init_backend_db_dump.sql /docker-entrypoint-initdb.d/1-init_backend_db_dump.sql
ADD 99-grant_permission.sql /docker-entrypoint-initdb.d/99-grant_permission.sql

#RUN chmod 755 /docker-entrypoint-initdb.d/1-init_backend_db_dump.sql
RUN chmod 755 /docker-entrypoint-initdb.d/99-grant_permission.sql
RUN chmod 755 /var/lib/mysql

#ADD init.sh /mysql/init.sh
#RUN chmod 755 /mysql/init.sh
#RUN /mysql/init.sh