# Docker Example

---
도커컨테이너 환경 구성에 필요한 샘플 Repository

---

## 1. Docker 란?

`컨테이너를 사용하여 각각의 프로그램을 분리된 환경에서 실행 및 관리할 수 있는 툴`

Docker를 사용하면 아래와 같은 장점이 있음

- 매번 귀찮은 **설치 과정을 일일이 거치지 않아도 된다.**
- **항상 일관되게** 프로그램을 설치할 수 있다. (버전, 환경 설정, 옵션, 운영 체제 등)
- 각 프로그램이 독립적인 환경에서 실행되기 때문에 **프로그램 간에 서로 충돌이 일어나지 않는다.**

## 2. Container & Image

- container : 독립적인 컴퓨터 환경을 구성해서, 각 환경에 프로그램을 별도로 설치할 수 있게 만든 개념
- image : 프로그램을 실행하는 데 필요한 설치 과정, 설정, 버전 정보 등을 포함하고 있음. 즉, 프로그램을 실행하는 데 필요한 모든 것을 포함


```
참고사이트

* Docker CLI → compose.yml로 변환
https://www.composerize.com/

* compose.yml → Docker CLI로 변환
https://www.decomposerize.com/

```
## 3. Dockerfile & Docker compose CLI

✅ Dockerfile을 바탕으로 이미지 빌드하기
```
$ docker build -t [이미지명] .
```

✅ Docker compose CLI
```
$ docker compose up -d --build

$ docker compose down

$ docker compose logs
```


## 4. 자주 쓰는 Docker CLI

✅ 이미지 가져오기

```
$ docker pull [이미지명:태그명]

$ docker pull nginx
$ docker pull nginx:latest 
```

✅ 다운받은 모든 이미지 조회
```
$ docker image ls
```

✅ 이미지 삭제
```
$ docker image rm -f [이미지ID / 이미지명]
```

✅ 컨테이너 조회
```
$ docker ps (현재 실행중인 컨테이너)
$ docker ps -a (전체 컨테이너 조회)
```

✅ 컨테이너 실행/중단

- Volume이 필요한 경우, Docker hub의 Reference를 확인하도록 한다

```
$ docker run --name [컨테이너명] 
    -d 
    -p [Host Port]:[Container Port] 
    -v [호스트의 디렉토리 절대경로]:[컨테이너의 디렉토리 절대경로]
    -e [컨테이너 환경변수] 
    [이미지명:태그]
$ docker run --name myWebServer -d -p 4000:80 nginx 

$ docker stop [컨테이너명/컨테이너ID]
```

✅ 컨테이너 삭제
```
$ docker rm -f [컨테이너명/컨테이너ID]

$ docker rm $(docker ps -qa)  (중지되어있는 모든 컨테이너 삭제)
```

✅ 컨테이너 내부 접속
```
$ docker exec -it [컨테이너 ID] bash
```