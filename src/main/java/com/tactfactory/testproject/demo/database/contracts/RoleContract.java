package com.tactfactory.testproject.demo.database.contracts;

public class RoleContract extends BaseContract {

	public static final String TABLE_NAME = "role";

	public static final String COL_ID = "id";
	public static final String COL_NAME = "name";

	public static final String ALIASED_COL_ID = TABLE_NAME + "." + COL_ID;
	public static final String ALIASED_COL_NAME = TABLE_NAME + "." + COL_NAME;

	public static final String[] COLS_INSERT = { COL_NAME };
	public static final String[] COLS_INSERT_ALL = { COL_NAME };

	public static final String[] COLS_SELECT = { ALIASED_COL_ID, ALIASED_COL_NAME };

	public static final String SCHEME_CREATE =
			"CREATE TABLE " + TABLE_NAME + " (" +
					COL_ID + " INT UNSIGNED NOT NULL AUTO_INCREMENT," +
					COL_NAME + " VARCHAR(20) NOT NULL," +
					"PRIMARY KEY (" + COL_ID + "));"
			;

	public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

	public static final String[] CONSTRAINTS = {};

	public RoleContract() {
		super(
				TABLE_NAME,
				COL_ID,
				ALIASED_COL_ID,
				COLS_INSERT,
				COLS_INSERT_ALL,
				COLS_SELECT,
				SCHEME_CREATE,
				DROP_TABLE,
				CONSTRAINTS);
	}
}















