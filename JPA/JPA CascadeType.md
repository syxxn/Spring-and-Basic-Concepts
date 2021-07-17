# JPA CascadeType



+ Casecade란 엔티티의 상태 변화를 연관 엔티티에 전파시키는 것이다.
+ 부모 자식 관계에 있는 도메인에 적용할 수 있다.

```java
@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
private List<Seat> seats; 
```



### Entity의 상태

1. Transient : 객체를 생성하고, 값을 주어도 JPA나 hibernate가 그 객체에 관해 아무것도 모르는 상태. 즉, 데이터베이스와 매핑된 것이 아무것도 없다.

   > 객체를 생성하고 수정한 상태.

2. Persistent : 저장을 하고 나서, JPA가 관리하는 상태가 된다.

   > save()한다고 바로 db에 반영되는 것은 아니다. JPA가 persistent 상태로 관리하고 있다가 후에 반영한다.

   > + 1차 캐시
   > + Dirty Checking(변경사항 감지, 상태를 추적하여 변화가 없는 경우에는 반영하지 않음)
   > + Write Behind(최대한 늦게, 필요한 시점에 DB에 적용)

3. Detached : JPA가 더 이상 관리하지 않는 상태. JPA가 제공해주는 기능들을 사용하고 싶다면, 다시 persistent 상태로 돌아가야 한다.

4. Removed : JPA가 관리하는 상태이긴 하지만, 실제 commit이 일어날 때, 삭제가 일어난다.



### Cascade 종류

+ Cascade의 default는 null이다.

+ CascadeType.ALL

  > 모든 Cascade를 적용한다.

+ CasecadeType.PERSIST

  > 엔티티를 생성하고, 연관 엔티티를 추가하였을 때 persist()를 수행하면 연관 엔티티도 함께 persist()가 수행된다.

+ CasecadeType.MERGE

  > 연관 엔티티의 추가 및 수정 이후 부모 엔티티가 merge()를 수행하게 되면 변경사항이 모두 반영된다.

+ CasecadeType.REMOVE

  > 삭제 시 연관된 엔티티도 같이 삭제된다.

+ CasecadeType.DETACH

  > 부모 엔티티가 detach()를 수행하게 되면, 연관된 엔티티도 detach() 상태가 되어 변경사항이 반영되지 않는다.





####  