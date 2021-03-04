# @TimeToLive



캐시 메모리를 사용할 때 주의해야 할 것은 캐싱할 정보의 선택, 유효기간(Time To Live, TTL) 설정, 갱신시점이다.

> 캐싱(caching)은 캐시 메모리 영역으로 데이터를 가져와서 접근하는 방식을 말한다.



@Indexed는 해당 redis의 데이터를 찾도록 도와주는 것이고, @TimeToLive는 해당 redis 데이터 파기하는 기간을 설정하는 것이다. 

```java
	@Id
    private String email;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long refreshExp;
```



redis에 기본 파기 시간을 따로 설정하지 않을 때에는 @TimeToLive를 붙여야 한다.