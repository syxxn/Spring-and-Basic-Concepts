# BusinessException과 RuntimeException



먼저 오류와 예외에 대한 개념을 짚고 넘어가자면,

오류는 시스템에 비정상적인 상황이 생겼을 때 발생한다. 이는 개발자가 미리 예측하여 처리할 수 없다. 

예외는 개발자가 구현한 로직에서 발생하는 것으로, 미리 예측하여 처리할 수 있다.



```java
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{ //BusinessException은 RuntimeExcepton의 자식이다.

    private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
```



RuntimeException은 말 그대로 실행 중에 발생하며 시스템 환경적으로나 입력이 잘못된 경우, 혹은 의도적으로 프로그래머가 잡아내기 위한 조건 등에 부하할 때 발생되게 만든다.

-> 자바에서 일어나는 모든 예외를 잡는다.(너무 방대함) -> 커스텀 Exception handler를 만들어준다.



BusinessException은 커스텀 Exception중에 하나이다.