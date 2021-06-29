### @RequiredArgsConstructor

초기화 되지 않은 `final` 필드와 `@NotNull` 어노테이션이 붙은 필드에 대한 생성자 생성

`@NonNull`이 붙어 있는 필드들은 null-check가 추가적으로 생성되며, 파라미터에서 null 값이 들어온다면 생성자에서 NPE가 발생한다.



### @AllArgsConstructor

모든 필드 값을 파라미터로 받는 생성자를 만들어준다.

`@NonNull` 어노테이션이 붙어 있는 필드는 생성자 내에서 null-check 로직을 자동으로 생성해 준다.



### @NoArgsConstructor

파라미터가 없는 기본 생성자 생성한다.

+ 주의점

  1. 필드들이 final로 생성되어 있는 경우에는 필드를 초기화 할 수 없어 생성자를 만들 수 없고 에러가 발생한다. -> 이때는 `@NoArgsConsturctor(force=true)`로 final 필드를 0, false, null 등으로 초기화를 강제로 시켜 생성자를 만들 수 있다.
  2. `@NonNull`같이 필드에 제약 조건이 설정되어 있는 경우, 생성자 내 null-check 로직이 생성되지 않는다.

+ 기본 생성자가 필요 없는 클래스면 final을 붙이는 게 낫다.
+ Request에서는 대부분 기본 생성자를 필요로 하지 않고, Response에서도 테스트에서 검증(ObjectMa하는 상황이 아니면 필요 없다. -> 그런 필드에는 final을 붙여주는 것이 좋다.



#### 생성자 관련 어노테이션을 사용할 때 주의사항

1. static 필드들은 스킵된다.
2. 파라미터의 순서는 클래스에 있는 필드 순서에 맞춰서 생성하기 때문에 주의해야 한다.