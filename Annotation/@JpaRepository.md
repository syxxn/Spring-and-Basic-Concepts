# @JpaRepository



- JpaRepository<Entity, Id> 인터페이스
  - @Repository가 없어도 빈으로 등록해 준다.



@JpaRepository를 사용하지 않으면 아래와 같이 일일이 구현하고, 테스트 해봐야 한다.

```java
@Repository
@Transactional
pulbic class PostRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Post add(Post post) {
		entityManager.persist(post);
		return post;
	}

	public void delete(Post post) {
		entityManager.remove(post);
	}

}
```



하지만 @JpaRepository를 사용함으로써 아주 간단하게 repository를 사용할 수 있다.

```java
public interface PostRepository extends JpaRepository<Post, Long> {
}
```



+ JpaRepository를 기능이 많지만, 보통 모든 기능을 사용하는 것이 아니기 때문에 일반적으로 @CrudRepository를 자주 사용하는 편이다.