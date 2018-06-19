package actor.actor_test;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * @author Manzarul
 * This actor will be called from main method and it will invoke createReceive method.
 * here we have the check of message type , if type instance of String then do cretain operation
 * else do some thing else.
 *
 */
public class FirstActor extends AbstractActor{
     // getting reference of another actor.  
	 ActorRef demoActor = ActorMainApp.system.actorOf(Props.create(SecondActor.class));
	@Override
	public Receive createReceive() {
		return receiveBuilder()
			      .match(String.class, s -> {
			    	  System.out.println("Received String message: {}" +s);
			    	 System.out.println(sender().path());
			    	 // giving command to another actor for performing some operations.
			    	 demoActor.tell("some new messgae", ActorRef.noSender());
			      })
			      .matchAny(o -> System.out.println("Unknown message received" ))
			      .build();
	}

}
