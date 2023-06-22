package com.example.practices.messages;

import akka.actor.typed.ActorRef;
import lombok.Builder;
import lombok.With;

import java.util.Objects;
import java.util.UUID;

@Builder
public record StartPingCommand(@With UUID id, @With Integer times, @With ActorRef<Message> pingTo) implements Message {
  public StartPingCommand(UUID id, Integer times, ActorRef<Message> pingTo) {
    this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
    this.pingTo = Objects.requireNonNull(pingTo);
    this.times = Objects.isNull(times) ? 1 : times;
  }
}
