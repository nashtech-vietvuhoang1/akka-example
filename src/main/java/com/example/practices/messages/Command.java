package com.example.practices.messages;

import akka.actor.typed.ActorRef;

public interface Command extends Message {
  ActorRef<Result> responseTo();
}
