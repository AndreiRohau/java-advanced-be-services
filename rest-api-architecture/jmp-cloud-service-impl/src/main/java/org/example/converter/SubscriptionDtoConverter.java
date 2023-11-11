package org.example.converter;

import org.example.dto.SubscriptionResponseDto;
import org.example.entity.Subscription;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDtoConverter implements Converter<Subscription, SubscriptionResponseDto> {

  @Override
  public SubscriptionResponseDto convert(Subscription source) {
    return SubscriptionResponseDto.builder()
        .id(source.getId())
        .userId(source.getUser().getId())
        .startDate(source.getStartDate().toString())
        .build();
  }
}
