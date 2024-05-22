package dh.backend.model;
import java.util.StringJoiner;

public class Odontologo {

        private int id;
        private String numeroMatricula;
        private String nombre;
        private String apellido;


        public Odontologo(){};
        public Odontologo(String numeroMatricula, String nombre, String apellido) {
            this.numeroMatricula = numeroMatricula;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumeroMatricula() {
            return numeroMatricula;
        }

        public void setNumeroMatricula(String numeroMatricula) {
            this.numeroMatricula = numeroMatricula;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Odontologo.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("numeroMatricula='" + numeroMatricula + "'")
                    .add("nombre='" + nombre + "'")
                    .add("apellido='" + apellido + "'")
                    .toString();
        }
    }