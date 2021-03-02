# @Value



```java
@RequiredArgsConstructor
@Service
public class ApplicantServiceManager implements ApplicantService {

    @Value("${tmap.app.key}")
    private String appKey;
    
} // 비즈니스 로직
```



```java
tmap.app.key = asdf.asdf.asdf //property 파일
```



@Value의 장점은 PropertySource를 사용하여 다양한 프로퍼티 파일을 쉽게 불러들여서 값을 지정할 수 있다는 장점이 있다.

