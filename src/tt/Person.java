package tt;

@DBTable(name = "PERSON")
public class Person {

	@SQLString(column = "id", length = 10, constraints = @Constraints(allowNull = false, primaryKey = true) )
	private String id;

	@SQLString(column = "name", length = 20, constraints = @Constraints(allowNull = false) )
	private String name;

	@SQLInteger(column = "age", constraints = @Constraints(allowNull = true) )
	private String age;

}
