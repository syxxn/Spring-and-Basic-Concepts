# File Basic



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
      //스프링 부트에서는 임시 파일을 만들어서 처리하는데, 여기서 지정한 크기보다 작으면 임시파일을 만들지 않는다.
  spring.servlet.mulipart.location: C:/Temp 
      // 임시파일을 저장할 위치 / 기본값은 System.getProperty("java.io.tmpdir");로 확인할 수 있다. / 파일은 손수 지워줘야 하기 때문에 관리 용이를 위해.
  spring.servlet.mulipart.max-file-size: 500MB //업로드할 파일의 최대 크기 / 기본값 1MB
  spring.servlet.mulipart.max-request-size: 515MB //업로드 할 때 요청의 최대 크기 / 기본값 10MB
      
  file.upload-dir: /uploads    
  ```

  > max-file-size는 각각 파일의 최대 크기를 말하는 것이고, max-request-size는 요청하는 모든 파일을 합친 크기를 말한다.