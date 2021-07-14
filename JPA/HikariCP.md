# HikariCP

Hikari는 Springboot 2.0부터 기본으로 설정되어 있는 높은 성능을 자랑하는 DB 커넥션 풀이다.



웹 애플리케이션의 경우 다수의 사용자가 데이터베이스에 접근해야 하는 상황이 생겼을 때, 사용자들이 요청할 때마다 연결을 만들고 해제하는 과정을 진행하면 비효율적이다. 따라서 커넥션 풀을 이용하여 미리 연결을 만들어 놓고 필요한 사용자가 요청시 미리 만들어놓은 커넥션을 주는 방식이 더욱 효과적이다.



### Connection Pool

Connection Pool이란, Pool(저장소) 속에 DB와의 연결을 미리 만들어 두고, DB에 접근 시 Pool에 남아있는 커넥션 중 하나를 받아와서 사용한 뒤 반환하는 기법을 말한다.

<img src="https://linked2ev.github.io/assets/img/devlog/201908/cp-s1.png" alt="image info" style="zoom:50%;" />

