## Docker
#### 一、常用指令
~~~~
service docker start    //启动docker

docker search mysql     //查找并安装镜像
docker pull mysql:5.6

docker images | grep mysql //查找本地镜像

docker run
-d 标识是让 docker 容器在后台运行。
-p 标识通知 Docker 将容器内部使用的网络端口映射到我们使用的主机上。
–name 定义一个容器的名字，如果在执行docker run时没有指定Name，那么deamon会自动生成一个随机数字符串当做UUID。
-e 设置环境变量，或者覆盖已存在的环境变量。
例如：docker run –name mysql -p 3306:3306 -e
MYSQL_ROOT_PASSWORD=123456 -d mysql/mysql-server:5.6
含义：容器的名字为mysql，将容器的3306端口映射到本机的3306端口，mysql数据库的密码为123456
，运行的镜像为mysql/mysql-server:latest

配置tomcat docker run -it -d -p 7899:8080 tomcat:版本号
-p 表示端口号，前一个7890是指我们访问tomcat时的端口号（宿主机端口），
后一个8080是tomcat启动的一个容器在docker中运行的端口号。

docker ps
-a 查看已经创建的容器
-s 查看已经启动的容器

docker start (stop) con_name 启动（停止）容器名为con_name的容器。
docker rm(rmi) con_name 删除容器（镜像）名为con_name的容器（镜像）。
~~~~



