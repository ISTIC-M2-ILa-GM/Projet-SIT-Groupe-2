package fr.univ_rennes1.istic.sit.groupe2.back_sit.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.MissionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.PositionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Position;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author VinYarD
 * created : 14/02/2019, 11:33
 */


public class PositionReceiver {
	
	Logger log = Logger.getLogger(MissionReceiver.class.getName());
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private PositionDao positionDao;
	
	@RabbitListener(queues = "#{positionQueue.name}")
	public void receivePosition(String json) throws InterruptedException {
		try {
			Position mission = objectMapper.readValue(json, Position.class);
			positionDao.save(mission);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
