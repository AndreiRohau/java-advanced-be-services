package org.example.converter;

import org.example.dto.UserRequestDto;
import org.example.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserConverter implements Converter<UserRequestDto, User> {

  @Override
  public User convert(UserRequestDto source) {
    return User.builder()
        .id(source.getId())
        .name(source.getName())
        .surname(source.getSurname())
        .birthday(LocalDate.parse(source.getBirthday()))
        .build();
  }
}
