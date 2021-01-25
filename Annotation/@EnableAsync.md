# @EnableAsync



외부 API에 작업 요청하고 외부 API 서버에서 요청을 처리하는데 오랜시간이 걸리는 경우 **비동기 방식**으로 처리하면 효율적이다.



자바에서 **비동기 처리**를 쓰려면 간단히 설정 클래스에 `@EnableAsync`를 추가해주면 된다.

> @Async는 두 가지 제약사항이 있다.
>
> 1. public 메소드에만 적용해야 한다.
> 2. 셀프호출(같은 클래스 안에서 async 메소드 호출)은 작동하지 않음.
>
> -> 메소드가 public이어야 프록시가 될 수 있고, 셀프호출은 프록시를 우회하고 해당 메소드를 직접 호출하지 않기 때문이다.

> 그래서 프록시가 뭐냐고?
>
> 보안상의 이유로 직접 통신할 수 없는 두 점 사이에서 통신을 할 경우 대리로 통신을 수행하는 것을 말한다.



`@EnableAsync` 애노테이션을 사용하면 `SimpleAsyncTaskExecutor`를 사용하도록 설정되어 있다. `SimpleAsyncTaskExecutor`는 매번 쓰레드르 생성하는 방식이기때문에 설정을 오버라이딩해서 사용하는게 좋다.