# File Basic



+ Multipart란 클라이언트가 요청을 보낼 때, http 프로토콜의 바디 부분에 데이터를 여러 부분으로 나누어 보내는 것을 말한다.

  > http 프로토콜은 `상태라인`, `헤더`, `공백`, `바디`로 구성되어 있다.

  + 보통 파일을 전송할 때 사용한다.



+ mulipart/form-data

  + content-type

  + 이 방식은 `<form>` 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용함
  + 모든 문자를 인코딩하지 않음으로 명시함

  ```html
  <form method"post" encType="multipart/form-data">
  	<input type="file" />
  </form>
  ```

  



+ Spring Boot application.properties

  ```java
  spring.servlet.mulipart.enabled: true // multipart 업로드 허용 여부
  spring.servlet.mulipart.file-size-threshould: 2KB
      //업로드하는 파일이 임시 파일로 저장되지 않고 메모리에서 바로 스트림으로 전달되는 크기의 한계
  spring.servlet.mulipart.location: C:/Temp 
      // 임시파일을 저장할 위치 / 기본값은 System.getProperty("java.io.tmpdir");로 확인할 수 있다. / 파일은 손수 지워줘야 하기 때문에 관리 용이를 위해.
  spring.servlet.mulipart.max-file-size: 500MB //업로드할 파일의 최대 크기 / 기본값 1MB
  spring.servlet.mulipart.max-request-size: 515MB //업로드 할 때 요청의 최대 크기 / 기본값 10MB
      
  file.upload-dir: /uploads    
  ```

  > max-file-size는 각각 파일의 최대 크기를 말하는 것이고, max-request-size는 요청하는 모든 파일을 합친 크기를 말한다.



+ Multipart 지원 기능을 이용하려면 `MultipartResolver`를 스프링 설정 파일에 등록해 주어야 한다. 하지만 SprintBoot에서는 자동으로 Bean을 등록해주기 때문에 별도의 설정없이 사용할 수 있다.