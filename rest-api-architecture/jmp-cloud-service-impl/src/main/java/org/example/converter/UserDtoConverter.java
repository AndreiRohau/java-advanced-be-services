package org.example.converter;

import org.example.dto.UserResponseDto;
import org.example.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<User, UserResponseDto> {

  @Override
  public UserResponseDto convert(User source) {
    return UserResponseDto.builder()
        .id(source.getId())
        .name(source.getName())
        .surname(source.getSurname())
        .birthday(source.getBirthday().toString())
        .build();
  }
}
