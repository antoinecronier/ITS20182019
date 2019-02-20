package com.tactfactory.testproject.demo.database.contracts;

public class RoleContract {

	public static final String TABLE_NAME = "role";

	public static final String COL_ID = "id";
	public static final String COL_NAME = "name";

	public static final String ALIASED_COL_ID = TABLE_NAME + "." + COL_ID;
	public static final String ALIASED_COL_NAME = TABLE_NAME + "." + COL_NAME;

	public static final String[] COLS_INSERT = { COL_NAME };
	public static final String[] COLS_SELECT = { ALIASED_COL_ID, ALIASED_COL_NAME };

	public static final String SCHEME_CREATE =
			"CREATE TABLE " + TABLE_NAME + " (" +
					COL_ID + " INT UNSIGNED NOT NULL AUTO_INCREMENT," +
					COL_NAME + " VARCHAR(20) NOT NULL," +
					"PRIMARY KEY (" + COL_ID + "));"
			;

	public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

	public static final String[] CONSTRAINTS = {};
}
