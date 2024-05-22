
package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.db.GeneradorDeSentencias;
import dh.backend.db.H2Connection;
import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private final static H2Connection jdbc = new H2Connection();

    private final static String TABLE = "odontologos";


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        jdbc.cargarElControlador();
        try(Connection conexion = jdbc.conectarConBaseDeDatos();
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO "+ TABLE + "(numero_matricula, nombre, apellido) " +
                    "VALUES(?, ?, ?)")){

            String s = generarInsertParaTodosLosCampos();
            stmt.setString(1, odontologo.getNumeroMatricula());
            stmt.setString(2, odontologo.getNombre());
            stmt.setString(3, odontologo.getApellido());
            stmt.executeUpdate();
            LOGGER.info("Los datos del odontólogo se cargaron exitosamente");
        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
        return odontologo;
    }

    @Override
    public Set<Odontologo> listar() {
        jdbc.cargarElControlador();
        Set<Odontologo> odontologos = new HashSet<>();
        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM "+ TABLE)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNumeroMatricula(rs.getString(2));
                odontologo.setNombre(rs.getString(3));
                odontologo.setApellido(rs.getString(4));
                odontologos.add(odontologo);
            }
            LOGGER.info("Listando los Odontólogos Finalizada");
        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
        return odontologos;
    }

    private String generarInsertParaTodosLosCampos(){

        return GeneradorDeSentencias.generarInsert(TABLE, List.of("id", "numero_matricula", "nombre", "apellido"));
    }
}
