package actor.actor_test;

import java.time.Duration;

import akka.actor.AbstractActor;

/**
 * 
 * @author Manzarul
 *
 */
public class SecondActor extends AbstractActor{

	@Override
	public Receive createReceive() {
		return receiveBuilder()
			      .match(String.class, s -> {
			    	  System.out.println("Received String message: {}" +s);
			    	 System.out.println(sender().path());
			    	// ActorMainApp.system.terminate();
			    	 // After receiving message from Demo1Actro running a actor scheduler job.
			    	 ActorMainApp.system.scheduler().schedule(Duration.ZERO, Duration.ofSeconds(3),()->{System.out.println("do some task");}, ActorMainApp.system.dispatcher());
			      })
			      .matchAny(o -> System.out.println("Unknown message received" ))
			      .build();
	}
	
	}
