# build.gradle



**build.gradle**은 프로젝트의 라이브러리 의존성, 플러그인, 라이브러리 저장소 등을 설정할 수 있는 필드 스크립트 파일이다.



gradle 의존성 옵션에는 `implementation`, `compileOnly`, `runtimeOnly`, `annotationProcessor` 등이 있다. 

+ implementation은 구현할 때만 사용되는 것일 때 사용한다.

  ```java
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  ```

  > starter는 버전 관리를 도와주기 때문에 starter를 사용한다면, 버전을 따로 명시 해주지 않아도 된다.

compile은 모듈이 수정되었을 때 직간접적으로 의존하고 있는 모든 모듈들이 다시 컴파일 된다. 또한 연결된 모든 모듈의 API가 노출되게 된다.

반대로 implementation은 모듈이 수정되었을 때 직업 의존하고 있는 모듈만 다시 컴파일 되게 되며, 연결된 모듈들의 API가 노출되지 않는다.

따라서 implementation은 빠르고, 모듈들의 API들을 노출시키지 않을 수 있기 때문에 implementation이 추천된다. **compile과 implementation은 바꿔서 사용할 수 있다**.
> spring boot 2.5x 부터는 compile 명령어가 지원되지 않는다. -> implementation을 사용


+ compileOnly는 compile 시에만 빌드하고 빌드 결과물에는 포함하지 않는다. 이것은 runtime(실행 중)일 때 필요없는 라이브러리인 경우 사용한다.

  > ex ) runtime 환경에 이미 라이브러리가 제공될 때
  >
  > -> lombok 같은 경우, @Getter를 사용하면 getter 메소드를 만들어서 저장한다. 따라서 runtime때는 롬복이 필요 없다.

  ```java
  compileOnly 'org.projectlombok:lombok'
  ```

+ runtimeOnly는 runtime(실행 중)일 때만 사용한다.

  ```java
  runtimeOnly 'mysql:mysql-connector-java'
  ```

+ annotationProcessor은 소스에 주석을 달기만 하면 코드를 생성하는 것이다.

  ```java
  annotationProcessor 'org.projectlombok:lombok'
  ```

+ testImplementation은 테스트 시에만 사용한다.

  ```java
  testImplementation 'com.h2database:h2'
  ```

  

```
spring-boot-starter-web

 -  Spring MVC를 사용한 RESTful서비스를 개발하는데 사용.
 
spring-boot-starter-test

 - Junit, Hamcrest, Mockito를 포함하는 스프링 어플리케이션을 테스트 가능하도록 한다.
 
 spring-boot-starter-web-services
 - SOAP(Simple Object Access Protocol) 서비스 개발 시 사용함
```

