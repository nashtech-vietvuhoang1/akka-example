package com.example.practices.messages;

import lombok.Builder;
import lombok.With;

import java.util.Objects;
import java.util.UUID;

@Builder
public record FailureResult(@With UUID id, @With UUID requestId, @With Throwable error) implements Result {
  @Override
  public boolean isSuccess() {
    return Objects.isNull(error);
  }

  public FailureResult(UUID id, UUID requestId, Throwable error) {
    this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
    this.requestId = Objects.requireNonNull(requestId);
    this.error = error;
  }
}
