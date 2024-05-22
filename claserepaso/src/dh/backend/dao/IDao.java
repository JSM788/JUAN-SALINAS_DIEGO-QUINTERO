package dh.backend.dao;
import java.util.List;
import java.util.Set;

public interface IDao <T>{
    T registrar(T t);
    Set<T> listar();
}
