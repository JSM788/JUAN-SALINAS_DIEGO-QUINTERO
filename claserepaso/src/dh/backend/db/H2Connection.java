package dh.backend.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    public static Logger logger = Logger.getLogger(H2Connection.class);

    private final static String DB_JD8C_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/db_clinica_odontologica;INIT=RUNSCRIPT FROM 'create.sql'";

    private final static String DB_USER = "sa";

    private final static String DB_PASS = "sa";

    public Connection conectarConBaseDeDatos() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }
        return connection;
    }

    public void cargarElControlador(){
        try {
            Class.forName(this.DB_JD8C_DRIVER);
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class! " + ex.getMessage());
            System.exit(1);
        }
    }
}



