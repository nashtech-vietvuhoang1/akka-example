package com.example.practices.actors;

import akka.actor.testkit.typed.javadsl.ActorTestKit;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import com.example.practices.messages.Hello;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;
import java.util.UUID;

import static org.junit.Assert.*;

public class HelloBehaviorTest {

  static final ActorTestKit testKit = ActorTestKit.create();

  @BeforeClass
  public static void setUpTest() throws Exception {
  }

  @AfterClass
  public static void tearDownTest() throws Exception {
    testKit.shutdownTestKit();
  }

  @Test
  public void testSayHello() {

    ActorRef<Hello> hello = testKit.spawn(HelloBehavior.create(), "hello-behavior");

    TestProbe<Hello> probe = testKit.createTestProbe();

    var helloMessage = Hello.builder().id(UUID.randomUUID()).message("Hello world").build();
    // var replyMessage = helloMessage.withMessage("Hi there");

    hello.tell(helloMessage);
  }
}