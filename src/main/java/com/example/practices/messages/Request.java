package com.example.practices.messages;

import akka.actor.typed.ActorRef;
import lombok.Builder;
import lombok.With;

import java.util.UUID;

@Builder
public record Request<P, R>(@With UUID id, @With P payload, @With ActorRef<Response<R>> responseTo) {
}
