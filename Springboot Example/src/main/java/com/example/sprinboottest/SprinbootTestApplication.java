package com.example.sprinboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootApplication 으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성이 모두 자동으로 설정된다.
특히 이 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야만 한다.
*/
public class SprinbootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootTestApplication.class, args);
    }
    /*
    main 메소드에서 실행하는 SpringApplication.run으로 인해 내장 WAS를 실행한다.
    → 내장 WAS란, 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 이야기한다.
        이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일로 실행하면 된다.
    → 꼭 내장 WAS를 사용해야만 하는 것은 아니지만, 스프링 부트에서는 권장하고 있다.
    → 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문이다.
     */

}
