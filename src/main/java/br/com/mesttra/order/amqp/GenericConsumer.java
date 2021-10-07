package br.com.mesttra.order.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.mesttra.order.amqp.message.BarRequestMessage;
import br.com.mesttra.order.amqp.message.KitchenRequestMessage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GenericConsumer {
	
	private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues = RabbitConfig.BAR_ORDER_QUEUE)
    public void consumerBar(@Payload BarRequestMessage bar) {
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.NOTIFICATION_KEY, bar);
		
    }
	
	@RabbitListener(queues = RabbitConfig.KITCHEN_ORDER_QUEUE)
    public void consumerkitchen(@Payload KitchenRequestMessage kitchen) {
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.NOTIFICATION_KEY, kitchen);
		
    }

}
