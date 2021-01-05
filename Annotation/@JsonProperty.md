# @JsonProperty



@JsonProperty 어노테이션은 객체의 **JSON 변환시 key의 이름을 개발자가 원하는 대로 설정할 수 있도록** 해주는 것이다.



이 어노테이션을 사용하기 위해서는 jackson 의존성 주입이 필요하다.

```java
compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.11.2'
```



```java
@JsonProperty("access-token")
private String accessToken;

@JsonProperty("refresh-token")
private String refreshToken;
```