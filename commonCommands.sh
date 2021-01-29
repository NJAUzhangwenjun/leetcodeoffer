firewall-cmd --zone=public --add-port=80/tcp --permanent

firewall-cmd --reload

firewall-cmd --list-ports


docker run --detach \
    --hostname 119.3.229.90 \
    --publish 8081:443 --publish 8082:80 --publish 8083:22 \
    --name gitlab --restart always \
    --volume /mydocker/gitlab/config:/etc/gitlab \
    --volume /mydocker/gitlab/logs:/var/log/gitlab \
    --volume /mydocker/gitlab/data:/var/opt/gitlab e2063cf6f55c
	
	
#!/bin/bash
HOST_NAME=njauit.cn
GITLAB_DIR=`pwd`
docker stop gitlab
docker rm gitlab
docker run -d \
    --hostname njauit.cn \
    -p 8081:443 -p 8082:80 -p 8083:22 \
    --name gitlab \
    -v /mydocker/gitlab/config:/etc/gitlab \
    -v /mydocker/gitlab/logs:/var/log/gitlab \
    -v /mydocker/gitlab/data:/var/opt/gitlab \
    b508d2bca1a0
