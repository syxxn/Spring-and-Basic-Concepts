# @WithMockUser



```java
@Test
@WithMockUser(value = "helloDiary", password = "1234")
public void 즐겨찾기추가() throws Exception {
    Integer id = addDiary("helloDiary", "1234");
    mvc.perform(patch("/bookmark/" + id + "?bookmark=true"))
            .andExpect(status().isNoContent());
}
```



위처럼 사용하는 `@WithMockUser`는 지정한 사용자 이름, 패스워드, 권한으로 UserDetails를 생성한 후 보안 컨텍스트를 로드한다. 계정이 없어도 새로 만든다.

> Security context : 접근 권한을 관리하는 데 사용 / (아직 정확한 정의는 모르겠으나 대충 새로 user 정보를 만들어서 토큰을 만든다는 느낌인 듯함)



