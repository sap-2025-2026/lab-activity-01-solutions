package mvc_03_dist_mom;

import com.rabbitmq.client.*;

/**
 * 
 * To run a container version of Rabbitmq broker on localhost:
 * 
 * docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
 *

 * 
 */
public class MyRemoteViewMain {

	private final static String EXCHANGE_NAME = "mvc";

	public static void main(String[] argv) throws Exception {

		MyRemoteView view = new MyRemoteView();
		view.display();

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	    String queueName = channel.queueDeclare().getQueue();
	    channel.queueBind(queueName, EXCHANGE_NAME, "");


		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			view.notifyModelUpdated(Integer.parseInt(message));
		};
	    
		channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });	    
		System.out.println("Remote Viewer installed. ");
	}
}
