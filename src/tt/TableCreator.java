package tt;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TableCreator {

	public String createTable(String clazzName) throws Exception {

		Class<?> clazz = Class.forName(clazzName);
		// �жϴ�������У��Ƿ����@DBTableע��
		DBTable db = clazz.getAnnotation(DBTable.class);
		if (null == db) {
			// ˵���������в�����@DBTable
			System.out.println(clazzName + "�в�����@DBTableע��");
		}
		// ����
		String tableName = db.name();
		StringBuilder sb = new StringBuilder();
		// ��ȡ�����������еĳ�Ա�ֶ�
		Field[] fieldArr = clazz.getDeclaredFields();
		for (Field field : fieldArr) {

			Annotation[] ann = field.getDeclaredAnnotations();

			// �ж��ֶ��Ƿ���@SQLStringע��
			if (ann[0] instanceof SQLString) {
				SQLString sqlString = (SQLString) ann[0];
				if (sqlString != null) {
					String column = sqlString.column();
					int length = sqlString.length();
					Constraints constraints = sqlString.constraints();
					sb.append(column.toUpperCase()).append(" ").append("VARCHAR(").append(length).append(")")
							.append(dealWithConstraints(constraints) + ",\r\n");
				}
			}
			// �ж��ֶ��Ƿ���@SQLIntegerע��
			if (ann[0] instanceof SQLInteger) {
				SQLInteger sqlInteger = (SQLInteger) ann[0];
				if (sqlInteger != null) {
					String column = sqlInteger.column();
					Constraints constraints = sqlInteger.constraints();
					sb.append(column.toUpperCase()).append(" ").append("INT")
							.append(dealWithConstraints(constraints) + ",\r\n");
				}
			}

		}

		String str = sb.toString().substring(0, sb.toString().lastIndexOf(",")) + "\r\n";
		String finSb = "CREATE TABLE " + tableName + "(\r\n" + str + ");";

		return finSb;

	}

	public String dealWithConstraints(Constraints constraints) throws Exception {
		StringBuilder sb = new StringBuilder();
		boolean allowNull = constraints.allowNull();
		boolean primaryKey = constraints.primaryKey();
		boolean union = constraints.union();
		if (!allowNull) {
			sb.append(" NOT NULL");
		}
		if (primaryKey) {
			sb.append(" PRIMARY KEY");
		}
		if (union) {
			sb.append(" UNION");
		}
		return sb.toString();

	}

	public static void main(String[] args) throws Exception {
		/**
		 * �������� Table Creation SQL for com.zejian.annotationdemo.Member is :
		 * CREATE TABLE MEMBER( ID VARCHAR(50) NOT NULL PRIMARY KEY, NAME
		 * VARCHAR(30) NOT NULL, AGE INT NOT NULL, DESCRIPTION VARCHAR(150) );
		 */
		TableCreator tc = new TableCreator();
		System.out.println(tc.createTable("tt.Person"));
	}

}
