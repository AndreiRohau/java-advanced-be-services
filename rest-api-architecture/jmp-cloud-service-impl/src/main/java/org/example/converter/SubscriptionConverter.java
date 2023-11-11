package org.example.converter;

import lombok.RequiredArgsConstructor;
import org.example.dto.SubscriptionRequestDto;
import org.example.entity.Subscription;
import org.example.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class SubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

  @Override
  public Subscription convert(SubscriptionRequestDto source) {
    return Subscription.builder()
        .id(source.getId())
        .user(User.builder().id(source.getUserId()).build())
        .startDate(LocalDate.now())
        .build();
  }
}
