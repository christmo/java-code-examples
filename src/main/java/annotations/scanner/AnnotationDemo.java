package annotations.scanner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by soporte on 3/27/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnotationDemo {
    String[] tags() default "";

    String createdBy() default "Mkyong";

    String lastModified() default "03/01/2014";
}
