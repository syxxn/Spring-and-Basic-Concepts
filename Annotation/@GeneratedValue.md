# @GeneratedValue



### strategy = GenerationType.IDENTITY

+ 기본 키 생성을 데이터베이스에 위임
+ 즉, id값을 null로 하면 DB가 알아서 AI(auto increment)해준다 > mysql 등
+ id값을 미리 설정하지 않고 insert query를 날리면 그 때 id 값을 세팅한다.
+ 즉, id 값은 DB에 값이 들어간 이후에 알 수 있다.
+ 모아서 insert 하는 것이 불가능하다.



### strategy = GenerationType.Auto

+ 기본 설정 값
+ 다른 전략을 자동으로 지정한다.