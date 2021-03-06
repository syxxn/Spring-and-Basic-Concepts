# build.gradle



**build.gradle**은 프로젝트의 라이브러리 의존성, 플러그인, 라이브러리 저장소 등을 설정할 수 있는 필드 스크립트 파일이다.



gradle 의존성 옵션에는 `implementation`, `compileOnly`, `runtimeOnly`, `annotationProcessor` 등이 있다. 

+ implementation은 구현할 때만 사용되는 것일 때 사용한다.

  ```java
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  ```

  > starter는 버전 관리를 도와주기 때문에 starter를 사용한다면, 버전을 따로 명시 해주지 않아도 된다.

+ compileOnly는 compile 시에만 빌드하고 빌드 결과물에는 포함하지 않는다. 이것은 runtime(실행 중)일 때 필요없는 라이브러리인 경우 사용한다.

  > ex ) runtime 환경에 이미 라이브러리가 제공될 때

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

  

