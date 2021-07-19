# Optional<>

Optional은 반환값이 '없음'을 나타내는 것이 주 목적이다.



Optional<T> 클래스는 Integer나 Double 클래스처럼 T 타입의 객체를 포장해 주는 래퍼 클래스이다. 따라서 Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있다.

이러한 Optional 객체를 사용하면 예상하지 못했던 NPE를 방지할 수 있다.



[Optional 메소드]

+ get() :  Optional 객체에 저장된 값을 반환함

+ isPresent() : 저장된 값이 존재하면 true를 반환하고, 값이 존재하지 않으면 false를 반환한다.

+ orElse() : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 값을 반환한다.

  > 값이 있든 없든 실행된다.

+ orElseGet() : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 람다 표현식의 결괏값을 반환한다.

  > 값이 없을 때만 실행된다.

+ orElseThrow() : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 예외를 발생시킨다.



단순히 값 또는 null을 얻을 목적이라면 Optional 대신 null 비교를 사용하는 것이 좋다. 

```java
return status != null ? status : READY;
```



또한, 컬렉션은 null이 아니라 비어있는 컬렉션을 반환하는 것이 좋을 때가 많다. 따라서 Optional로 감싸서 반환하지 말고 비어있는 컬렉션을 반환하는 것이 좋다.

```java
List<Member> members = team.getMembers();
return members != null ? members : Collections.emptyList();
```

```
public interface MemberRepository<Member, Long> extends JpaRepository {
    List<Member> findAllByNameContaining(String part); 
}
```



Optional에 담길 값이 int, long, double이라면 박싱/언박싱이 발생하게끔하지 말고, OptionalInt, OptionalLong, OptionalDouble을 사용하자.