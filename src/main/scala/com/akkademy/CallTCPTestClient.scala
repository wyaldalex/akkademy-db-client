package com.akkademy

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.akkademy.messages.{GetRequest, SetRequest}

object CallTCPTestClient extends App {

  private implicit val system = ActorSystem("system")

  object DummyClientActor {
    case class SendKey(key: String, value: Object)
  }
  class DummyClientActor extends Actor {
    import DummyClientActor._
    override def receive: Receive = {
      case SendKey(key,value) => {
       val remoteDb = context.actorSelection("akka.tcp://akkademy@127.0.0.1:2554/user/akkademy-db")
       remoteDb ! SetRequest(key,value)
      }
    }
  }

  import DummyClientActor._
  val dummyClient = system.actorOf(Props[DummyClientActor], "dummyClient")
  dummyClient ! SendKey("123", new Integer(123))

}
