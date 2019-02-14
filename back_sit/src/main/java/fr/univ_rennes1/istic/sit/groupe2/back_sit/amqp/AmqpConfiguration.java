package fr.univ_rennes1.istic.sit.groupe2.back_sit.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author VinYarD
 * created : 14/02/2019, 11:30
 */

@Configuration
public class AmqpConfiguration {
	
	@Bean
	public DirectExchange direct() {
		return new DirectExchange("sit.all");
	}
	
	@Bean
	public Queue positionQueue() {
		return new Queue("position");
	}
	
	@Bean
	public Queue missionQueue() {
		return new Queue("mission");
	}
	
	@Bean
	public Binding binding1a(DirectExchange direct,
													 Queue positionQueue) {
		return BindingBuilder.bind(positionQueue)
				.to(direct)
				.with("position");
	}
	
	@Bean
	public Binding binding1b(DirectExchange direct,
													 Queue missionQueue) {
		return BindingBuilder.bind(missionQueue)
				.to(direct)
				.with("mission");
	}
	
	@Bean
	public MissionReceiver missionReceiver() {
		return new MissionReceiver();
	}
	
}
