import com.epf.Persistance.Config_BDD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnexion {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config_BDD.class);

        DataSource dataSource = context.getBean(DataSource.class);

        // Test de la connexion à la base de données
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connexion réussie à la base de données");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données :" + e.getMessage());
        }
    }

}
