package com.example.practices.messages;

import akka.actor.typed.ActorRef;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.util.Objects;
import java.util.UUID;

@Builder
public record PingCommand(@With UUID id, @With String message,
                          @NonNull @With ActorRef<Result> responseTo) implements Command {

  public PingCommand(UUID id, String message, ActorRef<Result> responseTo) {
    this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
    this.message = message;
    this.responseTo = Objects.requireNonNull(responseTo);
  }

  @Override
  public String toString() {
    return "PingCommand{" +
        "id=" + id +
        ", message='" + message + '\'' +
        '}';
  }
}
