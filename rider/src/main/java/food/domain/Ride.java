package food.domain;

import food.RiderApplication;
import food.domain.DeliveryMenu;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Ride_table")
@Data
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryMenu deliveryMenu = new DeliveryMenu(this);
        deliveryMenu.publishAfterCommit();
    }

    public static RideRepository repository() {
        RideRepository rideRepository = RiderApplication.applicationContext.getBean(
            RideRepository.class
        );
        return rideRepository;
    }

    public void finish() {
        Finish finish = new Finish(this);
        finish.publishAfterCommit();
    }

    public void regi() {}

    public static void loadDeliveryInfo(StartMenu startMenu) {
        /** Example 1:  new item 
        Ride ride = new Ride();
        repository().save(ride);

        */

        /** Example 2:  finding and process
        
        repository().findById(startMenu.get???()).ifPresent(ride->{
            
            ride // do something
            repository().save(ride);


         });
        */

    }
}
