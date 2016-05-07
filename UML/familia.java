import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("110c0c8b-e769-4c7a-9a1b-c4491bb26c15")
public class Familia {
    @objid ("f5096328-91a4-47ad-917a-842404c60fab")
    private int codigo;

    @objid ("963b546d-6ab1-4076-bf3f-a50f8a4a6dc0")
    private String apellido;

    @objid ("ed7b12db-fef9-46bb-8a42-aee24bd72b8e")
    private transient String cuenta_bancaria;

    @objid ("434a6b57-4466-4c69-8504-37310f367609")
    private String direccion;

    @objid ("8b76ae75-acf0-4bec-822e-35ed07db73ef")
    private String telefono;

    @mdl.prop
    @objid ("c88c151f-81d7-4567-b28e-0552f0a1c20e")
    private String JavaProperty;

    @mdl.propgetter
    public String getJavaProperty() {
        // Automatically generated method. Please do not modify this code.
        return this.JavaProperty;
    }

    @mdl.propsetter
    public void setJavaProperty(String value) {
        // Automatically generated method. Please do not modify this code.
        this.JavaProperty = value;
    }

    @objid ("13ed211b-fae2-4bec-887e-ab11c2907c08")
    public List<Persona> miembro = new ArrayList<Persona> ();

    @objid ("e255bbbc-3876-4432-807e-a3058838ab3f")
    public int getcodigo() {
    }

    @objid ("99d805e4-055d-4424-94ac-657bde63284b")
    public String getapellido() {
    }

    @objid ("417a92aa-5cfe-4d4e-8709-82062117bfcb")
    public String getcuenta() {
    }

    @objid ("3756fb5b-4262-4402-81f6-1a1a1ca2acca")
    public String getdireccion() {
    }

    @objid ("3f57b90d-0436-46c8-87c1-bc74e4b9df66")
    public String gettelefono() {
    }

    @objid ("6c370d4f-5509-4350-9759-7f1e948778fe")
    public void setcodigo(int codigo) {
    }

    @objid ("103d751c-ceed-41b5-adcd-de061ccfe6b1")
    public void setapellido(String apellido) {
    }

    @objid ("4492dda0-a6d7-4c65-827a-34f02a4a9c6e")
    public void setcuenta(String cuenta) {
    }

    @objid ("ef16ebeb-da25-461a-958d-0e05390da027")
    public void setdireccion(String direccion) {
    }

    @objid ("468b0133-241a-4a54-beae-3091fa36438e")
    public void settelefono(String telefono) {
    }

    @objid ("298adbe8-fb5a-4242-8b0d-ea6bf4a3354a")
    int getCodigo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.codigo;
    }

    @objid ("052b1929-f074-4149-a950-4ae19cd3af13")
    void setCodigo(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.codigo = value;
    }

    @objid ("ba51a82a-f36d-447d-b7ad-765c381b71c9")
    String getApellido() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.apellido;
    }

    @objid ("3a371567-1517-4826-95bb-c66aa7beff3f")
    void setApellido(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.apellido = value;
    }

    @objid ("fd5e66ea-dcb6-4c9f-9732-d9e0bee829cb")
    String getCuenta_bancaria() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.cuenta_bancaria;
    }

    @objid ("d0ea0037-29b1-4d5c-8227-8db391f68c80")
    void setCuenta_bancaria(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.cuenta_bancaria = value;
    }

    @objid ("32cfe202-4394-44ac-8c0a-b6dca81548e5")
    String getDireccion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.direccion;
    }

    @objid ("12195f96-87a3-4fa8-a101-f6e3f4237c0b")
    void setDireccion(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.direccion = value;
    }

    @objid ("c49fbbd7-7cbb-4189-ad2f-4b81e8b6dcf2")
    String getTelefono() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.telefono;
    }

    @objid ("7e9006ef-80a6-4479-a452-914b972d5e8d")
    void setTelefono(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.telefono = value;
    }

}
