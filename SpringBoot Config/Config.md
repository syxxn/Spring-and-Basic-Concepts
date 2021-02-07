# Config



```
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .sessionManagement().disable()
                .formLogin().disable()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/").permitAll()
                    .antMatchers(HttpMethod.GET, "/post/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/post").permitAll();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}
```



CORS는 `cross-origin resource sharing`의 줄임말로, 직역하면 교차 출처 리소스 공유라고 해석할 수 있다. 여기서 '교차 출처'라는 것은 '다른 출처'를 의미하는 것이다.

