package br.com.mesttra.order.amqp.message;

import java.util.List;

import br.com.mesttra.order.entity.KitchenItem;
import br.com.mesttra.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KitchenRequestMessage {

    private List<KitchenItem> items;

    private String orderId;
    
    private OrderStatus barStatus;

}
