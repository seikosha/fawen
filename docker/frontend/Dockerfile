# 使用安装了最新node版本的的linxu环境
FROM node:latest
RUN npm config set registry https://registry.npm.taobao.org
RUN npm install coffeescript -g
RUN npm install -g vue-cli
RUN npm install
# 向nginx暴露8080端口
EXPOSE 8080