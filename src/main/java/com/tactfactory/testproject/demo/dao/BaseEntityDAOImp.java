package com.tactfactory.testproject.demo.dao;

import java.util.List;

import com.tactfactory.testproject.demo.database.DBManager;
import com.tactfactory.testproject.demo.database.contracts.BaseContract;
import com.tactfactory.testproject.demo.entities.base.BaseEntity;

public abstract class BaseEntityDAOImp<T extends BaseEntity> implements BaseEntityDAO<T> {

	protected DBManager manager = new DBManager();
	private BaseContract baseContract;

	public BaseEntityDAOImp(BaseContract baseContract) {
		this.baseContract = baseContract;
	}

	@Override
	public Boolean delete(T item) {
		Boolean result = false;

		StringBuilder builder = new StringBuilder();
		builder.append("DELETE ");
		builder.append(" FROM ");
		builder.append(baseContract.getTableName());
		builder.append(" WHERE ");
		builder.append(baseContract.getColId());
		builder.append(" = ");
		builder.append(item.getId());

		Integer changedLine = manager.dbDDLRequest(builder.toString());

		if (changedLine != null) {
			if (changedLine == 1) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public Boolean delete(List<T> items) {
		Boolean result = true;

		for (T item : items) {
			if (!delete(item)) {
				result = false;
			}
		}

		return result;
	}

	@Override
	public void createTable() {
		manager.dbDDLRequest(baseContract.getSchemeCreate());
	}

	@Override
	public void deleteTable() {
		manager.dbDDLRequest(baseContract.getDropTable());
	}


}
