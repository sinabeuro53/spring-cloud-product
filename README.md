# sinabeuro53 portfolio

## Developer Info
```
개발자명: 이한석
연락처: 010-9329-9597
이메일: sinabeuro53@naver.com
```

### Site Url
```
http://3.143.68.95:8150/
```

### Used Skill
```
Backend
 - Java(11)
 - Spring Boot, JPA, Querydsl
 - Gradle, Maven
 - Junit5, Mockito
 
Front
 - JS(ES6+)
 - Vue.js, Vuex, VueRouter 
 - Axios, Jquery
 - Tailwind CSS
 - NPM
 
DevOps
 - PostgreSQL
 - AWS, EC2
 - Docker
 
IDE
 - IntelliJ, Visual Studio
```

### Project Info
```
 개발 시작일 2022.03.03~
 gradle submodule 을 활용하여 프론트, 백엔드를 서브모듈화하여 개발했습니다. 
 프론트는 frontend 디렉토리에 백엔드는 office_backend 디렉토리에 위치합니다.
 frontend는 Vue-cli을 이용해서 Single Page Application로 구성되어있습니다.
 프론트 반응형 웹 디자인 90% 정도 적용되어있습니다.
 
 database는 로컬 DB를 사용하며, 제가 보유한 컴퓨터에 DB가 존재합니다.
 그래서 DB 성능과 server 통신이 그렇게 좋지는 않습니다. 
 배포 서버의 조회 속도가 그리 좋지 않아도 너그럽게 봐주셨으면 감사하겠습니다.
 
 dev branch 에서 개발을 하고 prod branch 에 반영합니다.
 배포 서버에는 prod branch 코드를 반영합니다.
```

### Project Local Run Step
```
로컬로 프로잭트를 실행하는 방법은 다음과 같습니다.
(※주의 로컬 PC에 node와 npm이 설치되어있어야함)
1. terminal 접속
2. git checkout dev
3. cd frontend
4. npm i
5. npm install --save jquery
6. npm run build

프론트 설치가 끝났으면 gradle로 실행하면 됩니다.
7. Gradle Tasks -> build -> build
8. Gradle Tasks -> application -> bootRun

마지막으로 좋게 봐주시면 감사하겠습니다!
```


