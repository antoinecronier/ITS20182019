package com.tactfactory.testproject.demo.database.contracts;

public class UserContract {

	public static final String TABLE_NAME = "user";

	public static final String COL_ID = "id";
	public static final String COL_FIRSTNAME = "firstname";
	public static final String COL_LASTNAME = "lastname";
	public static final String COL_LOGIN = "login";
	public static final String COL_PASSWORD = "password";

	public static final String FK_COL_ROLE_ID = "roleid";

	public static final String ALIASED_COL_ID = TABLE_NAME + "." + COL_ID;
	public static final String ALIASED_COL_FIRSTNAME = TABLE_NAME + "." + COL_FIRSTNAME;
	public static final String ALIASED_COL_LASTNAME = TABLE_NAME + "." + COL_LASTNAME;
	public static final String ALIASED_COL_LOGIN = TABLE_NAME + "." + COL_LOGIN;
	public static final String ALIASED_COL_PASSWORD = TABLE_NAME + "." + COL_PASSWORD;

	public static final String ALIASED_FK_COL_ROLE_ID = TABLE_NAME + "." + FK_COL_ROLE_ID;

	public static final String[] COLS_INSERT = {
			COL_FIRSTNAME,
			COL_LASTNAME,
			COL_LOGIN,
			COL_PASSWORD
			};

	public static final String[] COLS_INSERT_ALL = {
			COL_FIRSTNAME,
			COL_LASTNAME,
			COL_LOGIN,
			COL_PASSWORD,
			FK_COL_ROLE_ID
			};

	public static final String[] COLS_SELECT = {
			ALIASED_COL_ID,
			ALIASED_COL_FIRSTNAME,
			ALIASED_COL_LASTNAME,
			ALIASED_COL_LOGIN,
			ALIASED_COL_PASSWORD,
			ALIASED_FK_COL_ROLE_ID
			};

	public static final String SCHEME_CREATE =
			"CREATE TABLE " + TABLE_NAME + " (" +
					COL_ID + " INT UNSIGNED NOT NULL AUTO_INCREMENT," +
					COL_FIRSTNAME + " VARCHAR(255) NOT NULL," +
					COL_LASTNAME + " VARCHAR(255) NOT NULL," +
					COL_LOGIN + " VARCHAR(255) NOT NULL," +
					COL_PASSWORD + " VARCHAR(255) NOT NULL," +
					FK_COL_ROLE_ID + " INT UNSIGNED," +
					"PRIMARY KEY (" + COL_ID + "));"
			;

	public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

	public static final String[] CONSTRAINTS = {
			"ALTER TABLE " + TABLE_NAME + " ADD CONSTRAINT " +
				"FK_" + TABLE_NAME + "_" + FK_COL_ROLE_ID + "_" + RoleContract.TABLE_NAME +
				" FOREIGN KEY (" + FK_COL_ROLE_ID +
				") REFERENCES " + RoleContract.TABLE_NAME + "(" + RoleContract.COL_ID + ")"
				};
}










