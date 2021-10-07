package br.com.mesttra.order.amqp.message;

import java.util.List;

import br.com.mesttra.order.entity.BarItem;
import br.com.mesttra.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarRequestMessage {

    private List<BarItem> barItems;

    private String orderId;
    
    private OrderStatus barStatus;
}
