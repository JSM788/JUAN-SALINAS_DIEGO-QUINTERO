package dh.backend.test;
import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Clase para testear Odontologo")
public class OdontologoTest {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    private Logger LOGGER =  Logger.getLogger(OdontologoTest.class);

    @Test
    public void registrarOdontologo(){

        // DADO
        LOGGER.info("Test ListaOdontólogos Inicio");
        Odontologo odontologo1 = new Odontologo("AAA1", "Wilson", "Bernal");
        Odontologo odontologo2 = new Odontologo("AAA2", "Estela", "Lopez");
        Odontologo odontologo3 = new Odontologo("AAA3", "Wilder", "Bernal");
        Odontologo odontologo4 = new Odontologo("AAA4", "Celeste", "Bernal");
        Odontologo odontologo5 = new Odontologo("AAA5", "Isai", "Bernal");

        // CUANDO
        odontologoService.registrar(odontologo1);
        odontologoService.registrar(odontologo2);
        odontologoService.registrar(odontologo3);
        odontologoService.registrar(odontologo4);
        odontologoService.registrar(odontologo5);

        Set<Odontologo> odontologos = odontologoService.listar();

        for(Odontologo o: odontologos){
            System.out.println("Odontólogo ---> Nombre: " + o.getNombre()
                    + ", Apellido: " + o.getApellido()
                    + ", NroMatricula: " + o.getNumeroMatricula());
        }

        assertEquals(odontologos.size(),5);

        System.out.println(odontologos);

    }
}
