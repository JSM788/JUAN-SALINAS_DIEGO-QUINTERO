package dh.backend.service;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;
import java.util.Set;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrar(Odontologo odontologo){

        return odontologoIDao.registrar(odontologo);
    }

    public Set<Odontologo> listar(){

        return odontologoIDao.listar();
    }
}
