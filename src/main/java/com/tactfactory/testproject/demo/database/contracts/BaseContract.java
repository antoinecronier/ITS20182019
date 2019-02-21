package com.tactfactory.testproject.demo.database.contracts;

public abstract class BaseContract {

	private String tableName;
	private String colId;
	private String aliasedColId;
	private String[] colsInsert;
	private String[] colsInsertAll;
	private String[] colsSelect;
	private String schemeCreate;
	private String dropTable;
	private String[] constraints;

	public String getTableName() {
		return tableName;
	}

	public String getColId() {
		return colId;
	}

	public String getAliasedColId() {
		return aliasedColId;
	}

	public String[] getColsInsert() {
		return colsInsert;
	}

	public String[] getColsInsertAll() {
		return colsInsertAll;
	}

	public String[] getColsSelect() {
		return colsSelect;
	}

	public String getSchemeCreate() {
		return schemeCreate;
	}

	public String getDropTable() {
		return dropTable;
	}

	public String[] getConstraints() {
		return constraints;
	}

	public BaseContract(String tableName, String colId, String aliasedColId, String[] colsInsert,
			String[] colsInsertAll, String[] colsSelect, String schemeCreate, String dropTable, String[] constraints) {
		super();
		this.tableName = tableName;
		this.colId = colId;
		this.aliasedColId = aliasedColId;
		this.colsInsert = colsInsert;
		this.colsInsertAll = colsInsertAll;
		this.colsSelect = colsSelect;
		this.schemeCreate = schemeCreate;
		this.dropTable = dropTable;
		this.constraints = constraints;
	}
}
