# Gradle Command-Line Interface

참고 사이트 : https://docs.gradle.org/6.8.2/userguide/command_line_interface.html#sec:command_line_warnings



+ command-line interface는 gradle과 상호 작용하는 기본 방법 중 하나이다.

+ `gradle wrapper`는 운영체제에 맞춰 Gradle 빌드를 수행하도록 하는 것이다. 이 것은 프로젝트 내에 숨김속성을 가지고 있는 `gradle-wrapper.jar`를 이용해서 운영체제에 적절한 배치 스크립트를 실행하도록 한다.

  > 배치 스크립트란?
  >
  > 명령 프롬프트(cmd)의 명령들을 하나의 일괄(Batch) 처리 스크립트로 작성하여 자동화 시키는 방법
  >
  > ```
  > # 윈도우
  > > gradlew.bat [task]
  > 
  > # 리눅스 및 OSX
  > > ./gradlew [task]
  > ```



```
$ gradle [작업 이름] [-옵션 이름]
```

+ 여러 작업을 지정하는 경우 공백으로 구분해야 한다.



+ 단위 테스트 돌리기

  ```
  $ gradle test
  ```

  gradle을 사용하면, 로컬환경에서 빌드할 경우 로컬 환경에 설치된 java와 gradle 버전에 영향을 받게 된다.

  

  ```
  $ gradle test --continue
  ```

  `--continue`를 지정하고 실행하면, gradle은 첫 번째 실패가 발생하면 바로 중지하는 것이 아니라, 해당 작업의 모든 의존관계가 실패하지 않고 완료된 모든 작업을 수행한다. **발생한 각 장애는 빌드의 마지막에 보고된다.**



+ 단위 테스트는 건너뛰고 빌드하기

  ```
  $ gradle build -x test
  ```

  

+ 프로젝트 빌드

  : gradlew를 이용하여 빌드하면 로컬 환경 java와 gradle 버전과 상관 없이 새로운 프로젝트를 빌드할 수 있다.

  > `build.gradle` 에 설정된 버전으로 돌아가게 된다.

  ```
  $ gradlew build
  ```

  

+ 빌드 청소

  ```
  $ gradle clean
  ```

  `clean` 명령어를 쓰면 빌드 디렉토리의 내용을 삭제할 수 있지만, 삭제하게 되면 사전에 계산된 출력이 상실되어 이후 작업을 수행하는 데 상당한 빌드 시간이 걸린다.



