package fr.univ_rennes1.istic.sit.groupe2.back_sit.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author VinYarD
 * created : 14/02/2019, 11:33
 */


public class PositionReceiver {
	
	@RabbitListener(queues = "#{positionQueue.name}")
	public void receivePosition(String json) throws InterruptedException {
		// TODO parse json data to Position object and save() it
	}
}
