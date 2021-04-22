package com.example.sprinboottest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor //롬복 어노테이션은 길이 순으로 나열한다.
@Entity //주요 어노테이션을 클래스에 가깝게 둔다.
public class Posts { //실제로 디비와 매칭될 클래스
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 큐칙. `GenerationType.IDENTITY`를 추가해야만 AI가 됨.
    private Long id; //웬만하면 Entity의 PK는 Long타입의 AI를 추천함.

    @Column(length = 500, nullable = false) //기본 값 외에 추가로 변경이 필요한 옵션이 있을 때 @Coluumn을 붙인다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //굳이 칼럼이라고 선언하지 않아도 Entity 클래스의 필드는 모두 칼럼이 된다.
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) { //앤티티 클래스에서는 절대 setter 메소드를 만들지 않음
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //→ setter가 없는데 값을 디비에 어떻게 삽입해요? : 기본적인 구조는 생성자를 통해 값을 채우는 것이고, 대부분은 @Builder를 사용한다.
    //빌더를 사용하면 어떤 필드에 어떤 값을 채워 넣어야할지 명확하게 인지할 수 있기 때문이다.
}
