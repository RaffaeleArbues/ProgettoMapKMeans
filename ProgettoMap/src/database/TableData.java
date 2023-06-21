package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import database.TableSchema.Column;

public class TableData {
	DbAccess db;

	public TableData(DbAccess db) {
		this.db = db;
	}
	public List<Example> getDistinctTransazioni(String table) throws SQLException, EmptySetException {
		// to do
		/* 
		 * copiare algoritmo del costruttore di Data per memorizzare tuple distinte:
		 * estrarre tuple della tabella e metterle in un TreeSet
		 * dopo, creare una List<Example> di tipo ArrayList a partire dal TreeSet
		 * List<Example> = new ArrayList<Example>(TreeSet)
		*/
		// eccezione EmptySetException da lanciare se ResultSet è vuoto
		return null;
	}

	public Set<Object> getDistinctColumnValues(String table, Column column) throws SQLException {
		// to do
		/* 
		 * a partire dalla table che gli passiamo cicliamo sulla column che gli passiamo
		 * e aggiungiamo i valori distinti di quella colonna ad un Set
		 * che poi restituiremo
		 * nel PDF c'è scritto di scegliere quale Set utilizzare, secondo me un TreeSet,
		 * che esegue automaticamente i controlli sui duplicati, è il più opportuno
		 */
		return null;
	}

	public Object getAggregateColumnValue(String table, Column column, QUERY_TYPE aggregate) throws SQLException, NoValueException {
		// to do
		/*
		 * onest non ho capit
		 */
		return null;
	}
}
