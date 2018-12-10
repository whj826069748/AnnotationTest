package tt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
	//�Ƿ������� Ĭ�ϲ�������
	boolean primaryKey() default false;
	//�Ƿ�Ψһ Ĭ�ϲ���Ψһ
	boolean union() default false;
	//�Ƿ�����δnull Ĭ������Ϊ��
	boolean allowNull() default true;
}
