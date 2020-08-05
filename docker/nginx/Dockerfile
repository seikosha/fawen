FROM nginx
# 对外暴露端口
EXPOSE 80 8000
# 移除nginx容器的default.conf文件
RUN rm /etc/nginx/conf.d/default.conf
# 把主机的nginx.conf文件复制到nginx容器的/etc/nginx文件夹
ADD ./docker/nginx/nginx.conf  /etc/nginx/conf.d/
# 设置维护者信息
MAINTAINER seikosha "56125237@qq.com"