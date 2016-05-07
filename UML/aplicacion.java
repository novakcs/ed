import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fcf6d7bb-6b80-4d99-a876-e745712c0c97")
public class Aplicacion {
    @mdl.prop
    @objid ("729997ff-de96-49c2-b70f-07678032e406")
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

    @objid ("21f3d4b4-35c4-4e76-bfc4-35e63b73d2bf")
    public List<Familia> cliente = new ArrayList<Familia> ();

}
