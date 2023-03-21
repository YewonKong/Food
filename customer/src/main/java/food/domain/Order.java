package food.domain;

import food.CustomerApplication;
import food.domain.Cancle;
import food.domain.Order;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String store;

    private String menu;

    private String address;

    private String cutomerId;

    @PostPersist
    public void onPostPersist() {
        Order order = new Order(this);
        order.publishAfterCommit();

        Cancle cancle = new Cancle(this);
        cancle.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void canSearch(DeliveryMenu deliveryMenu) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryMenu.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void canSearch(Finish finish) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(finish.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
