package com.akkademy

import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
import com.akkademy.messages.{GetRequest, SetRequest}

import scala.concurrent.duration._

class SClient(remoteAddress: String) {
  private implicit val timeout = Timeout(10 seconds)
  private implicit val system = ActorSystem("LocalSystem")
  private val remoteDb = system.actorSelection("akka.tcp://akkademy@127.0.0.1:2554/user/akkademy-db")
  println("did it even tried to connect? " + remoteDb.pathString)

  def  set(key: String , value: Object) = {
    remoteDb ? SetRequest(key,value)
  }
  def get(key: String)  = {
    remoteDb ? GetRequest(key)
  }

}
