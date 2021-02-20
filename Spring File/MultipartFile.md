# MultipartFile



MultipartFile이란 사용자가 업로드한 File을 핸들러에서 손쉽게 다룰 수 있도록 도와주는 매개변수 중 하나입니다.

> Handler란, 클라이언트의 요청을 처리하는 주체로 스프링에서는 Controller나 HttpRequestHandler 등을 말한다.

MultipartFile 매개변수를 사용하기 위해서는 MultipartResolver Bean이 등록되어 있어야 하는데, Spring Boot를 사용한다면 별도의 설정 없이 사용할 수 있다.



MultipartFile을 사용한 file 업로드 방법으로는 `@RequestParam MultipartFile`을 사용하는 것이 있다.

```java
@PostMappring("/file")
public void uploadFile(@RequestParam("file") MultipartFile file) {
    String fileName = file.getOriginalFileName(); //업로드 한 파일의 실제 이름
    byte[] data = file.getBytes(); //파일의 실제 내용
}
```

이 방법의 경우, 서버는 클라이언트의 HTTP 요청 메세지에 포함된 파라미터들을 모두 분리해서 컨트롤할 수 있기 때문에, file 데이터를 직접 다룰 수 있다는 장점이 있지만, 다른 파라미터들과 함께 받는다면 코드가 조금 지저분해질 수도 있다는 단점이 있다.





