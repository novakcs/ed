import java.util.ArrayList;
import java.util.List;


public class Familia {
    private int codigo;
    private String apellido;
    private transient String cuenta_bancaria;
    private String direccion;
    private String telefono; 

    public List<Persona> miembro = new ArrayList<Persona> ();


    public int getcodigo() {return codigo;}

    public String getapellido() {return apellido;}

    public String getcuenta() {return cuenta;}

    public String getdireccion() {return direccion;}

    public String gettelefono() {return telefono;}

    public void setcodigo(int codigo) {}

    public void setapellido(String apellido) {}

    public void setcuenta(String cuenta) {}

    public void setdireccion(String direccion) {}

    public void settelefono(String telefono) {}

}
