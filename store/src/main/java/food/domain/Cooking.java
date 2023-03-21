package food.domain;

import food.StoreApplication;
import food.domain.Replaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String menu;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Replaced replaced = new Replaced(this);
        replaced.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptorreplace(AcceptorreplaceCommand acceptorreplaceCommand) {
        Accept accept = new Accept(this);
        accept.publishAfterCommit();
    }

    public void start() {
        StartMenu startMenu = new StartMenu(this);
        startMenu.publishAfterCommit();
    }

    public void finish() {
        WriteStatus writeStatus = new WriteStatus(this);
        writeStatus.publishAfterCommit();
    }

    public static void roadAboutMenu(Order order) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(order.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
