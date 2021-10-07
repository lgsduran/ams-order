package br.com.mesttra.order.entity;

import br.com.mesttra.order.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private String id;

    @NonNull
    private String waiter;

    @NonNull
    private Integer tableNo;

    @NonNull
    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL)
    private List<BarItem> barItems;

    @NonNull
    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL)
    private List<KitchenItem> kitchenItems;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private OrderStatus barStatus;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private OrderStatus kitchenStatus;

}