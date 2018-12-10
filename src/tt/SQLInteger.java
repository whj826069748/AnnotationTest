package tt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
	//ÁÐÃû
	String column() default "";
	//Ô¼Êø
	Constraints constraints() default @Constraints ;
}
