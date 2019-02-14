package fr.univ_rennes1.istic.sit.groupe2.back_sit.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author VinYarD
 * created : 14/02/2019, 11:33
 */


public class MissionReceiver {
	
	@RabbitListener(queues = "#{missionQueue.name}")
	public void receiveMission(String json) throws InterruptedException {
		// TODO parse json data to Mission object and save() it
	}
}
