package chapter10;

import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;

/**
 * Created by gd on 2/11/2019.
 */
public class Ch10Utils {
    public static <T> void listAttributes(EntityType<T> entityType) {
        for (Attribute<? super T, ?> attribute : entityType.getAttributes()) {
            System.out.println(attribute.getName() + " " +
            attribute.getJavaType().getName() + " " +
            attribute.getPersistentAttributeType());
        }
    }
}
