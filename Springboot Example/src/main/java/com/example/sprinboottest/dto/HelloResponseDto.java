package com.example.sprinboottest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //final 또는 @NotNull이 붙은 필드가 포함된 생성자를 생성한다.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
