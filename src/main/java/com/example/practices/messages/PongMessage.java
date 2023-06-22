package com.example.practices.messages;

import lombok.Builder;
import lombok.With;

import java.util.Objects;
import java.util.UUID;

@Builder
public record PongMessage(@With UUID id, @With UUID requestId, @With String message) implements Result {

  public PongMessage(UUID id, UUID requestId, String message) {
    this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
    this.requestId = Objects.requireNonNull(requestId);
    this.message = message;
  }

  @Override
  public boolean isSuccess() {
    return true;
  }

  @Override
  public Throwable error() {
    return null;
  }

  @Override
  public String toString() {
    return "PongMessage{" +
        "id=" + id +
        ", requestId=" + requestId +
        ", message='" + message + '\'' +
        '}';
  }
}
