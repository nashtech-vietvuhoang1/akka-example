package com.example.practices.actors;

import akka.actor.testkit.typed.javadsl.ActorTestKit;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import com.example.practices.messages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.*;

public class PingActorTest {

  static final ActorTestKit testKit = ActorTestKit.create();

  @BeforeClass
  public static void setUpTest() throws Exception {
  }

  @AfterClass
  public static void tearDownTest() throws Exception {
    testKit.shutdownTestKit();
  }
  @Test
  public void testPingAndPong_withThreadSleep_showFullLog() throws InterruptedException {

    ActorRef<Message> ping = testKit.spawn(PingActor.create(), "ping-actor");
    ActorRef<Message> pong = testKit.spawn(PongActor.create(Duration.ofMillis(500)), "pong-actor");

    ping.tell(StartPingCommand.builder().times(10).pingTo(pong).build());

    Thread.sleep(5000);

    ping.tell(StopPingActorCommand.builder().build());

    testKit.stop(ping);
    testKit.stop(pong);
  }

  @Test
  public void testHandle_PongMessage() {

    ActorRef<Message> ping = testKit.spawn(PingActor.create(), "ping-actor");

  }

}