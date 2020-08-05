FROM mysql:8.0.19

# 设置维护者
MAINTAINER seikosha "56125237@qq.com"

# 拷贝初始化sql
COPY ./src/init.sql /docker-entrypoint-initdb.d/init.sql
# 从主机复制mysql配置文件到mysql容器
COPY ./docker/mysql/mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf
# 环境编码设定为UTF-8
ENV LANG C.UTF-8