# CURL (Client URL)

CURL이란 서버와 통신할 수 있는 커맨드 명령어 툴이다. 웹개발에 매우 많이 사용되고 있는 오픈소스이다.

URL에 임의의 데이터를 전송하기 위하여 명령 줄 도구와 스크립트에서 사용할 수 있는 라이브러리를 제공한다.

CURL은 수 많은 프로토콜을 지원한다는 장점이 있으며, 

> DICT, FILS, Telnet, SMTP, SCP, HTTP, HTTPS, Gopher, FTP, LDAP, POP3, POP3S ...

다음 명령어로 설치할 수 있다.

```
sudo apt-get install curl
```



### 요청 보내기

| 명령어 | 의미                                                         |
| ------ | ------------------------------------------------------------ |
| -i     | 응답 헤어 출력(옵션 없으면 응답 본문만 출력)                 |
| -v     | 중간 처리 과정, 오류 메세지, 요청 메세지와 응답 메세지를 헤더와 본문을 포함해 전체 출력 |
| -X     | 요청 메소드를 지정(옵션 없으면 기본값은 GET)                 |
| -H     | 요청 헤더를 지정                                             |
| -d     | 요청 본문을 지정(옵션 없으면 요청 본문 없음)                 |

ex)

```
$ curl -H "Content-Type: application/json"
$ curl -G http://webisfree.com/action?test=ok
$ curl -XPOST http://webisfree.com -d title="hello"
```

