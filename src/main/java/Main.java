import com.mk.tutorials.hibernate.User;
import com.mk.tutorials.hibernate.UserController;
import com.mk.tutorials.hibernate.UserControllerImpl;
import org.hibernate.HibernateException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(new Configuration().configure().getProperties()).build();

        UserController controller = new UserControllerImpl(serviceRegistry);


        try {
            User user = new User();
            user.setDoj(new Date());
            user.setFirstname("Changed");
            user.setLastname("Hibernate");
            user.setUsername("hibernate");

            controller.createOrUpdate(user);
            controller.getAllUsers().forEach(u -> {
                System.out.println(u.getFirstname());
            });


        } catch (HibernateException exception) {
            System.out.println("problem creating session factory!");
        } finally {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
}
