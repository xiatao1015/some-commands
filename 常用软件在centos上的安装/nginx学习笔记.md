# Nginx(CentOS 8)

## 安装

### 编译安装

```shell
$ tar -zxvf nginx-1.22.0.tar.gz 
$ cd nginx-1.22.0/
$ ./configure --prefix=/usr/local/nginx  # 安装到指定的路径下
$ yum install -y pcre-devel  # 缺少的依赖
$ make && make install
```

###  一些常用命令

```shell
$ cd /usr/local/nginx/sbin
$ ./nginx					# 启动
$ ./nginx -s stop			# 快速停止
$ ./nginx -s quit			# 在退出前，完成已经接受的连接请求
$ ./nginx -s reload			# 重新加载配置
```

### 设置开机自启动配置文件

```shell
$ vim /usr/lib/systemd/system/nginx.service
```

```shell
[Unit]
Description=nginx - web server
After=network.target remote-fs.target nss-lookup.target

[Service]
Type=forking
PIDFile=/usr/local/nginx/logs/nginx.pid
ExecStartPre=/usr/local/nginx/sbin/nginx -t -c /usr/local/nginx/conf/nginx.conf
ExecStart=/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
ExecReload=/usr/local/nginx/sbin/nginx -s reload
ExecStop=/usr/local/nginx/sbin/nginx -s stop
ExecQuit=/usr/local/nginx/sbin/nginx -s quit
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

```shell
$ systemctl daemon-reload  # 重新加载系统服务
$ systemctl start nginx    # 启动nginx
$ systemctl status nginx   # 查看状态
$ systemctl enable nginx.service   # 开机自启动
```

