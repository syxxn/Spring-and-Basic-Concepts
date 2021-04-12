# @SpringBootApplication

```java
@SpringBootApplication
public class LearningSpringBootApplication {
    
    public static void main(String[] args) { //IDE 내에서 바로 실행할 수 있어서 시간이 많이 절약된다.
        // SpringApplication.run()은 스프링 부트의 구동될 클래스를 가리킨다. (다른 클래스를 실행할 수도 있다.)
        SpringApplication.run(LearningSpringBootApplication.class, args);
    }
    
}
```



스프링부트가 클래스패스 설정, 속성 설정 및 기타 요소에 따라 빈이 자동으로 생성되도록 하는 **자동 설정**을 실행하도록 지시하고 있다. 

> 클래스 패스 : 자바에서 컴파일하기 위해 `*.class`가 모여 있는 곳을 가리킴. 라이브러리(class 파일)을 자바에게 알려주는 역할
>
> -> JDK가 제공하는 라이브러리를 사용할 수 있도록 하기 위해 설정하는 것