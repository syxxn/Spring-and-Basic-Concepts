# @Transactional



트랜잭션이란, 데이터베이스의 상태를 변경시키는 작업 또는 한번에 수행되어야 하는 연산들을 의미한다.

이런 트랜잭션 작업이 끝나면 `commit`, `rollback`이 되어야 하는데, 이런 작업을 자동으로 해주는 것이 `@Transactional`이다.



객체가 변경되었을 때 `begin`, `commit`을 자동으로 수행해주며, 예외를 발생시키면, `rollback`처리를 자동으로 수행해준다.

>  만약 @Transactional을 사용하지 않는다면, 직접 save했던 데이터를 직접 복구 시켜놔야 한다.

