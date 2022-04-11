package mamc.demospringbjdbc.repositories.sql;

import javax.swing.text.DefaultEditorKit;
import java.util.List;

public class SqlQueries {
    private static final String INSERT= "INSERT";
    private static final String UPDATE= "UPDATE";
    private static final String  SELECT = "SELECT";
    private static final String DELETE = "DELETE";
    private static final String CREATE="CREATE";
    private static final String SET= "SET";
    private static final String DROP= "DROP";
    private static final String FROM = "FROM";
    private static final String WHERE ="WHERE";
    private static final String ALL = "*";
    private static final String COUNT = "COUNT";
    private static final String IN = "IN";
    private static final String INTO = "INTO";
    private static final String VALUES = "VALUES";
    private static final String OPEN_PARENTH = "(";
    private static final String CLOSE_PARENTH = ")";
    private static final String EQUALS = "=";



    private String saveQuery(String table, List<String> values) {
      return INSERT + INTO + table + VALUES + OPEN_PARENTH + values + CLOSE_PARENTH;
    }


}
