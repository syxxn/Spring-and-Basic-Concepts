# BaseEntity 만들기



```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
		
		@CreatedDate 
		private LocalDateTime createdDate;

		@LastModifiedDate 
		private LocalDateTime modifiedDate;
    
}
```



+ @MappedSuperclass

  JPA Entity 클래스들이 이 클래스를 상속할 경우 `BaseTimeEntity`의 필드도 칼럼으로 인식하도록 한다.

+ @EntityListeners(AuditingEntityListener.class)

  Auditing 기능 추가 - 자동으로 값을 넣어준다

  > 이거 없으면 @CreatedDate, @LastModifiedDate 쓸 수 없음

+ @CreatedDate

  엔티티가 생성되어 저장될 때 시간이 자동 저장된다.

+ @LastModifiedDate

  조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.