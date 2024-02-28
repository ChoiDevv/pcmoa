#!/bin/bash

ps -ef | grep "pcmoa-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ];then
    echo "my-application Stop Success"
else
    echo "my-application Not Running"
fi

echo "my-application Restart!"
echo $1
nohup java -jar build/libs/{프로젝트명}-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &
출처: https://kang-james.tistory.com/entry/배포-AWS를-통한-배포-방법-알아보기EC2-서버-실행 [내 꿈을 JAVA:티스토리]