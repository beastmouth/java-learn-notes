## 执行docker相关命令，提示permission denied解决方法

`Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get http://%2Fvar%2Frun%2Fdocker.sock/v1.26/images/json: dial unix /var/run/docker.sock: connect: permission denied`



### 原因：

Manage Docker as a non-root user
The docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo. The docker daemon always runs as the root user.
**If you don’t want to use sudo when you use the docker command, create a Unix group called docker and add users to it.** When the docker daemon starts, it makes the ownership of the Unix socket read/writable by the docker group.



### 解决方法：

`sudo groupadd docker     #添加docker用户组
sudo gpasswd -a $USER docker     #将登陆用户加入到docker用户组中
newgrp docker     #更新用户组`

然后重新登陆用户

便可以解决该问题