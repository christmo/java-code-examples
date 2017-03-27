package annotations.scanner;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * Created by soporte on 3/27/17.
 */
public class MainScanner {

    public static void main(String[] args) {

        //System.out.println(ClasspathHelper.forJavaClassPath());
        //System.out.println(ClasspathHelper.forClassLoader(Thread.currentThread().getContextClassLoader()));
        System.out.println(ClasspathHelper.forPackage("annotations.scanner"));

        Reflections reflections = new Reflections("annotations.scanner");
        /*Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forClassLoader(Thread.currentThread().getContextClassLoader()))
        );*/
        Set<Class<?>> types = reflections.getTypesAnnotatedWith(AnnotationDemo.class);


        //Set<Class<? extends SomeType>> subTypes = reflections.getSubTypesOf(SomeType.class);

        //Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SomeAnnotation.class);

        System.out.println(types.size());

        for(Class<?> clazz: types){
            System.out.println(clazz.getCanonicalName());
        }
    }

}
