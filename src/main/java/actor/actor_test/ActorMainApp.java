package actor.actor_test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author Manzarul
 * Main class to demonstrate , how to create actor system and then
 * send a message to an actor actor.tell method. this method is basically
 * for tell and forgot.
 *
 */
public class ActorMainApp 
{
	// here we are creation an actor system with name testActor
	// it can be created with any name or you can create it without name as well
	public static ActorSystem system = ActorSystem.create("testActor");
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ActorRef demoActor = system.actorOf(Props.create(FirstActor.class));
        demoActor.tell("test message", ActorRef.noSender());
        System.out.println("now u are free to do other work.");
    }
}
