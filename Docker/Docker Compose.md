# Docker Compose

+ Docker Compose는 다수의 컨테이너를 쉽게 운용하기 위한 도구이다.

+ Docker Compose는 yaml 포맷으로 작성되며, 여러 개의 컨테이너의 실행을 한 번에 관리 할 수 있게 해준다.

  쉽게 말해 명령어를 하나씩 입력하지 않아도 한번 저장 해 두면 간편하게 사용할 수 있는 것이다.



### Docker-compose.yml

```yaml
version: '3'

services:
  pear:
    image: pear
    build: .
    ports:
      - "8005:8080"
    volumes:
      - /home/hong/projects/user_backend_v2/log:/logs/*.log
    networks:
      - redis-network
    environment:
      - DB_URL=${DB_URL}
      - DB_USERNAME=${DB_USERNAME}
      - DB_PASSWORD=${DB_PASSWORD}
  redis:
    image: redis
    container_name: redis-server
    ports:
      - "6380:6379"
    volumes:
      - /home/hong/projects/user_backend_v2/data
    networks:
      - redis-network
networks:
  redis-network:
```

+ `version` : docker-compose 버전, 현재는 3을 많이 쓰는 듯함

+ `services: [컨테이너이름]` : 하고 싶은 거 넣으면 된다.

  + `image` : 도커 이미지 이름이다. 처음 만들 때는 하고 싶은 이름으로 하고, 로컬에 없으면 Docker hub에서 가져온다. 
  + `build: .` : 해당 위치에서 이미지를 빌드한다는 의미이다. `./`는 현재 위치(docker-compose가 있는 위치)
  + `port : "[외부포트]:[내부포트]"` : 외부포트는 아파트 주소라고 생각하고, 내부포트는 호수 정도로 생각하면 될 듯 하다. 호수가 같더라도 아파트 주소가 다르면 다른집인 것이다.
  + `volumes:[프로젝트 실행 중 로그 파일 저장할 위치]` : 로그파일을 저장할 경우 하고 싶은 위치를 선택하여 작성하면 된다. 로그파일을 저장하지 않을 경우 작성하지 않아도 된다.
  + `networks: [네트워크 이름]` : 이 이미지가 연결할 네트워크를 설정해 주는 것이다. 이 예시에서는 redis 이미지와 pear 이미지가 서로 상호작용해야 하기 때문에 네트워크를 설정해준 것이다.
  + `environment : [키]=[밸류]` : 서비스 내에서 사용하는 환경변수를 작성한다.

+ `redis` :

  + redis는 Docker hub에 이미 올라가 있기 때문에 이미지 이름은 꼭 `redis`로 작성해야 한다. 

  + container_name은 컨테이너 이름을 설정하는 것으로, 설정하고 싶은 것으로 하면 된다.

  + redis에서 volumes는 데이터를 저장할 위치를 지정하는 것이므로 필수로 작성해야 한다.

  + redis 이미지 설정은 각 프로젝트마다 설정해 주는 것이 일반 적이다. 

    > redis 접근에 대한 이해가 안갈 땐 mysql로 치환해서 생각하면 이해하기 쉽다. mysql에 접속할 때 여러 유저가 접속할 수도 있고, 한 사람만 접속할 수도 있는 것이다. 하지만 각각의 db에 영향을 주지 않도록 하기 위해 각각 설정해주는 것 같다.

+ `networks` : 

  + 밖에 있는 networks는 네트워크를 생성하기 위해 설정하는 것이다.
  + 다른 컨테이너와 공유할 컨테이너가 있을 때만 사용한다. 밑에 네트워크를 생성하면, 뒤에 있는 이미지들의 정보를 담아 구성한다.
  + 이 예시를 보면, pear도 하나의 컨테이너이고, redis도 하나의 컨테이너이다. 이 두 컨테이너를 연결하기 위해서 네트워크를 구성한 것이다.