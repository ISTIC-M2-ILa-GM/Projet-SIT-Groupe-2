package fr.univ_rennes1.istic.sit.groupe2.back_sit.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.MissionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.PositionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author VinYarD
 * created : 14/02/2019, 11:33
 */


public class MissionReceiver {
	
	Logger log = Logger.getLogger(MissionReceiver.class.getName());
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private MissionDao missionDao;
	
	@RabbitListener(queues = "#{missionQueue.name}")
	public void receiveMission(String json) throws InterruptedException {
		try {
			Mission mission = objectMapper.readValue(json, Mission.class);
			missionDao.save(mission);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
