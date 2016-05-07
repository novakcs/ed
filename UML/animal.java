import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("65a46324-00a0-4d30-88d4-52e44181ddb8")
public class Animal {
    @objid ("f7bbedde-07d2-4def-aeff-e989613e1a6d")
    private int codigo;

    @objid ("92a99889-74dc-4729-8138-0bb1217acb9e")
    private String alias;

    @objid ("8214a8ce-4935-4432-8611-145bbc0c3bcf")
    private String especie;

    @objid ("1bca452f-e870-4b63-aa71-518acad01ee9")
    private String raza;

    @objid ("7b17c924-3873-4afc-a9bf-1749397d75fb")
    private String color_pelo;

    @objid ("2bc08dfe-d0a1-4a5b-831f-6431a1c14210")
    private String fecha_nac;

    @objid ("24abc129-f710-4d56-9f03-99c2adcf2d6f")
    private float[] pesos = new float[10];

    @objid ("2554afbf-86e4-4ed1-a526-53f228a59272")
    private float pesoactual;

    @objid ("15345ad5-f05a-494d-9293-f46666c55129")
    public Familia mascota;

    @objid ("a9f13ffd-af7d-4395-8f49-15f918247cc9")
    public List<Historial> historial = new ArrayList<Historial> ();

    @objid ("6d64020e-44d9-4041-982c-ec6ca869f5a1")
    public Calendario calendario;

    @objid ("a8b6c36e-f4e0-4f91-9332-e08e6952e245")
    public void setcodigo(int codigo) {
    }

    @objid ("4abf92d7-1e6e-40bd-b929-d0b6a2f8fae6")
    public void setalias(String alias) {
    }

    @objid ("4e8d4075-fa57-419f-9b2f-ec04433772fd")
    public void setespecie(String especie) {
    }

    @objid ("a129c333-621d-47fd-b0e9-329d07ac6c49")
    public void setraza(String raza) {
    }

    @objid ("0fde86cb-c995-4f70-b439-5798a88953d9")
    public void setcolorpelo(String colorpelo) {
    }

    @objid ("46c91ea5-ff14-4dd8-b1a2-77b34a6f26a3")
    public void setfechanacimiento(String fecha) {
    }

    @objid ("1b7b91c3-092a-46c8-837a-9f06c9f16007")
    public void anyadirpeso(float peso) {
    }

    @objid ("7841091e-2ff5-4ea7-9a3c-7f2df24e04bb")
    public int getcodigo() {
    }

    @objid ("b4bfa7c4-494d-42e1-b5ea-8bb9f76828a6")
    public String getalias() {
    }

    @objid ("9edb2819-e571-4328-85c4-7addbb54ea11")
    public String getespecie() {
    }

    @objid ("b4daffa1-2062-4c55-8ef8-c709185b144b")
    public String getraza() {
    }

    @objid ("3b664ea3-7251-4c8d-bcda-db53f33185ac")
    public String getcolorpelo() {
    }

    @objid ("c30cbb99-e12e-4011-9094-1b34ce14e053")
    public String getfechanac() {
    }

    @objid ("113f247d-0cbe-4482-b231-1929eb1d503d")
    public float getpesomedio() {
    }

    @objid ("b152059b-202c-4a85-a4e0-bb100d3d48bc")
    public float getpesoactual() {
    }

}
