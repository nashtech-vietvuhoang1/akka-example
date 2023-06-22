package com.example.practices.actors;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.example.practices.messages.Hello;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloBehavior extends AbstractBehavior<Hello> {
  private HelloBehavior(ActorContext<Hello> context) {
    super(context);
  }

  static Behavior<Hello> create() {
    return Behaviors.setup(HelloBehavior::new);
  }

  @Override
  public Receive<Hello> createReceive() {
    return newReceiveBuilder().onMessage(Hello.class, message -> {
      log.info("HelloBehavior {}", message);
      return Behaviors.same();
    }).build();
  }
}
