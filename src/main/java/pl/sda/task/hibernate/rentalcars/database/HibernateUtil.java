package pl.sda.task.hibernate.rentalcars.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    // Uchwyt do jedynej instancji klasy HibernateUtil ---> Singleton Pattern (anti-pattern)
    public final static HibernateUtil INSTANCE = new HibernateUtil();

    //Uchwyt czyli referencja --> sessionFactory, tworzenie obiektu (operator new) jest ukryte w .build() ---> Builder Pattern
    private final SessionFactory sessionFactory;

    // Konstruktor bezargumentowy - w 12 lini wywołujemy go czyli przy wczytywaniu klasy
    // (pole statyczne są inicilizowane przy wczytywaniu/ładowaniu klasy)
    // EAGER
    // While lazy loading delays the initialization of a resource,
    // eager loading initializes or loads a resource as soon as the code is executed.
    // Eager loading also involves pre-loading related entities referenced by a resource.
    private HibernateUtil() {
        // Jest nie mutowalny, a uchwyt finalowy - przypisany niezmiennie dokładnie raz (final) tylko w konstruktorze
        // (pole finalne - najpóźniej przypisujemy w konstruktorze).
        // https://docs.jboss.org/hibernate/core/3.5/api/org/hibernate/SessionFactory.html
        // this dla czytelności
        this.sessionFactory = loadConfigFile();
    }

    private SessionFactory loadConfigFile() {
        // Załaduj plik konfiguracyjny: hibernate.cfg.xml
        // (jeśli nie podam nazwy pliku to załaduje plik hibernate.cfg.xml - domyślna nazwe plik, można podać inną nazwe)
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        // Metadane to dane które opisują dane
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        // Na podstawie metadanych z pliku konfiguracyjnego tworzymy fabrykę sesji
        return metadata.getSessionFactoryBuilder().build();
    }

    // Geter zwracający pole sessionFactory
    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
