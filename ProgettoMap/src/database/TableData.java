package database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.spi.DirStateFactory.Result;

import database.TableSchema.Column;

public class TableData {
	DbAccess db;

	public TableData(DbAccess db) {
		this.db = db;
	}

	/**
	 * Ricava lo schema di "table", va a estrarre tutti i dati contenuti in table e va a inserire in una lista di example solo le tuple distinte.
	 */
	public List<Example> getDistinctTransazioni(String table) throws SQLException, EmptySetException {
		TableSchema schema = new TableSchema(db, table); 
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();

		ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + table);
		Set<Example> distinctTuples = new TreeSet<Example>();

		while (resultSet.next()) {
			Example e = new Example();
			for (int i = 0; i<schema.getNumberOfAttributes(); i++) {
				if (schema.getColumn(i).isNumber()) {
					e.add(resultSet.getFloat(schema.getColumn(i).getColumnName()));
				} else {
					e.add(resultSet.getString(schema.getColumn(i).getColumnName()));
				}
			}
			distinctTuples.add(e);
		}
		resultSet.close();
		List<Example> distinctTransazioni = new ArrayList<Example>(distinctTuples);
		// eccezione EmptySetException da lanciare se ResultSet è vuoto
		return distinctTransazioni;
	}

	/**
	 * Restituisce un Set di valori distinti di una specifica colonna.
	 */
	public Set<Object> getDistinctColumnValues(String table, Column column) throws SQLException {
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT " + column.getColumnName() + 
		" FROM " + table + " ORDER BY " + column.getColumnName() + " ASC");

		Set<Object> distinctColumns = new TreeSet<Object>();
		while (resultSet.next()) {
			distinctColumns.add(resultSet.getObject(column.getColumnName()));
		}
		resultSet.close();
		return distinctColumns;
	}

	/**
	 * Restituisce il risultato della query_type applicato alla colonna column della tabella table.
	 */
	public Object getAggregateColumnValue(String table, Column column, QUERY_TYPE aggregate) throws SQLException, NoValueException {
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT " + aggregate + "(" 
		+ column.getColumnName() + ") FROM " + table);
		return resultSet;
	}
}
