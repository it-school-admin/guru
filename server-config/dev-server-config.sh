#https://urvanov.ru/2015/07/15/%D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-java-apache-tomcat-%D0%B8-postgresql-%D0%B2-linux-%D0%B5/#installingPostgreSQL


apt-get update
wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | sudo apt-key add -
echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | sudo tee /etc/apt/sources.list.d/bellsoft.list
sudo apt-get update
sudo apt-get install bellsoft-java11

#check java_home


apt-get install tomcat9
#CATALINA_BASE=/var/lib/tomcat9
#CATALINA_HOME=/usr/share/tomcat9
nano /etc/systemd/system/multi-user.target.wants/tomcat9.service
#add JAVA_HOME=/usr/lib/jvm/bellsoft-java11-amd64

#http://services.it-school.su:8080/

apt-get install tomcat9-docs
apt-get install tomcat9-examples
apt-get install tomcat9-admin


nano /var/lib/tomcat9/conf/tomcat-users.xml
service tomcat9 restart

#https://websofter.ru/zapusk-servera-tomcat-8-na-portu-80-pod-linux/
iptables -t nat -A PREROUTING -p tcp -m tcp --dport 80 -j REDIRECT --to-ports 8080
iptables -t nat -A PREROUTING -p udp -m udp --dport 80 -j REDIRECT --to-ports 8080


apt-get install postgresql

sudo -u postgres psql
#CREATE ROLE gurudbuser LOGIN PASSWORD 'guruDbUser';
#CREATE DATABASE gurudb;
#ALTER DATABASE gurudb OWNER TO gurudbuser;
#\q

nano /etc/postgresql/12/main/postgresql.conf
#listen_addresses = '*'

nano /etc/postgresql/12/main/pg_hba.conf
#host    all             all              0.0.0.0/0                       md5

#https://bigbinary.com/blog/configure-postgresql-to-allow-remote-connection

service postgresql restart

#JNDI
#https://javarush.ru/groups/posts/2650-ispoljhzovanie-jndi-v-java
#https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#PostgreSQL

#https://jdbc.postgresql.org/download.html

cd /usr/share/tomcat9/lib

wget https://jdbc.postgresql.org/download/postgresql-42.2.18.jar

nano /var/lib/tomcat9/conf/context.xml

service tomcat9 restart