package com.example.sprinboottest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository를 추가할 필요 없다.
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다. Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
