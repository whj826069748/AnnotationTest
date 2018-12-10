package tt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
	//是否是主键 默认不是主键
	boolean primaryKey() default false;
	//是否唯一 默认不是唯一
	boolean union() default false;
	//是否允许未null 默认允许为空
	boolean allowNull() default true;
}
