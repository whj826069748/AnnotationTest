package tt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
	//列名
	String column() default "";
	//长度
	int length() default 1;
	//约束
	Constraints constraints() default @Constraints ;
}
