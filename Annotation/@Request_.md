# @Request_



### @RequestMapping

+ 어떤 URL을 어떤 메소드가 처리할 지 mapping해주는 어노테이션이다
+ 보통 클래스 위에 기본 url을 설정해 줄 때 사용한다.
+ 클래스와 메소드 레벨 모두에서 사용할 수 있다.

> 대부분의 경우, 메소드 레벨에서는HTTP 메소드 특정 변형 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 또는 @PatchMapping 중 하나를 사용하는 것을 선호 한다

- 어떤 경로를 한 메서드에 처리하고 싶다면, 배열로 경로 목록을 지정하면 됨

```
public class Ne{
	@RequestMapping({'/main','/index'})
    //보통 URI를 설정 해주는데, 괄호 안에 꼭 "문자열"
	public String list(ModeMap model){
	}
}
```

#### @PostMapping

: Post의 HTTP(S) request를 처리함

```
@PostMapping("/message/{messageId}")
    public void readMessage(@PathVariable Integer messageId) {
        messageService.readMessage(messageId);
    }
```

#### @PutMapping

: Put의 HTTP(S) request를 처리함

```
@PutMapping
public TokenResponse refreshToken(@RequestHeader("X-Refresh-Token") String refreshToken){
        return authService.refreshToken(refreshToken);
}
```

#### @GetMapping

: @GetMapping 어노테이션이 있는 메소드는 주어진 URI 표현식과 일치하는 HTTP 요청을 처리함

```
@GetMapping("/{boardId}")
public BoardContentResponse getBoardContent(@PathVariable Integer boardId) {
    return boardService.getBoardContent(boardId);
}
```

#### @DeleteMapping

: Delete의 HTTP(S) request를 처리함

```
@DeleteMapping("/{boardId}")
    public void deleteBoardContent(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
    }
```



### @RequestBody

+ 요청이 온 데이터를 바로 클래스로 매핑하기 위한 어노테이션이다.
+ 주로 요청 메소드가 Post일 때 사용한다.



### @RequestHeader

+ Request의 header 값을 가져올 수 있다.

  `@RequestHeader(value="Accept-Language")String acceptLanguage` 이런 식으로 사용한다.



### @RequestParam

+ @PathVariable과 비슷한 것으로, Request의 parameter에서 데이터를 가져온다.

  > @PathVariable은 ("/{id}") 이런식으로 쓸 때
  >
  > @RequestParam은 ?id= 이런식으로 쓸 때

+ 일반적인 String 처리에 유용하다. 

+ 이름=값 양식 필드와 함께 사용된다.



### @RequestPart 

+ Request로 온 MultipartFile을 바인딩해준다

  > 데이터 바인딩이란 요청에서 받아온 값을 변수에 넣어주는 것이다.
  > 스프링 프레임워크에서 바인딩이란, 모델클래스(entity, serviceImpl)의 프로퍼티(dto)에 값을 넣는 것을 말한다.

  `@RequestPart("file")MultipartFile file` 이런식으로 사용한다.

+ json/xml과 같이 모델 매핑이 필요한 경우 유용하다.

+ 주로 파일에 이용되는데, @RequestParam으로 바꿔 사용해도 무관하다.

  

> @RequestParam vs @RequestPart
>
> '주요 차이점은 메서드 인수가 String이 아닌 경우 @RequestParam은 등록된 Converter 또는 PropertyEditor를 통한 유형 변환에 의존하는 반면 @RequestPart는 요청 파트의 'Content-Type' 헤더를 고려하여 HttpMessageConverters에 의존한다는 것입니다. '
>
> ⇒ 아무튼 얘네 둘은 각자가 의존하는 것이 다른건데, 잘 모르겠다. 둘다 Query String으로 `?name=` 이런식으로 값을 받는애들이다.

