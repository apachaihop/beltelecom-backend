package net.btc.microservices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import net.btc.microservices.entities.Network;
import net.btc.microservices.entities.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: implement all access from this class?
//TODO: try to use local EM
public class DataBase {

    public static void main(String[] args) throws IllegalAccessException {
        List<Network> networks = new ArrayList<>();
        networks.add(new Network("net1", "url1"));
        networks.add(new Network("net2", "url3"));
        networks.add(new Network("net3", "url3"));
        User user = new User(null, 123L, "Name", "desc", networks);

        //Temporarily ignores List's etc.
        System.out.println(getObjectQueryString(user));
    }

    //Get SQL query string from any object (no array/collection fields pls). For what? Because I can :)
    public static String getObjectQueryString(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();

        StringBuilder sql = new StringBuilder("SELECT ");

        Field[] fields = Arrays.stream(objectClass.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers())).toArray(Field[]::new);

        for (Field field : fields) {
            sql.append(field.getName()).append(", ");
        }

        sql.delete(sql.length() - 2, sql.length() - 1);
        sql.append("FROM ").append(objectClass.getSimpleName()).append("s WHERE 1=1 ");

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);

            //TODO: make Network field check
            if (value != null)
            {
                sql.append("AND ").append(field.getName());

                if (value instanceof String val && !val.isBlank()) {
                    if (val.equals("null"))
                        sql.append(" IS NULL ");
                    else
                        sql.append(" = '").append(value).append("' ");
                }
                else sql.append(" = ").append(value).append(' ');
            }
        }

        return sql.toString();
    }

    public static List<?> getObjectQueryResult(EntityManager entityManager, Object object) {
        if (object == null) throw new NullPointerException("Object is null");

        String sql;

        try {
            sql = DataBase.getObjectQueryString(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //entityManager = MicroServicesApplication.getEntityManager();

        Query query = entityManager.createNativeQuery(sql);

        return query.getResultList();
    }

    public static void persistObject(EntityManager entityManager, Object object) {
        entityManager = MicroServicesApplication.getEntityManager();

        if (entityManager == null) {
            System.out.println("Error: entityManager is null. Interrupt persisting");
            return;
        }

        entityManager.getTransaction().begin();

        entityManager.persist(object);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
