/*
 * Clase "property" del proyecto "propertyshop"
 * En esta clase está el creador de objetos "Property" con sus atributos y todos sus métodos get y set
 */
package propertyshop;

/**
 *
 * @author David León Marín
 */
public class Property {    
    String nombre;
    String direccion;
    double metrosConstr;
    double metrosUtiles;
    String nombreProp;
    String direccionProp;
    int precio; 
    
    /**
     * 
     * @param se recibe el nombre, si no está vacío se almacena en minúsculas 
     */
    void setName(String nuevoNombre){
        nombre = (nuevoNombre == null) ? null : nuevoNombre.toLowerCase();
    }    
    
    
    /**
     * 
     * @return devuelve el nombre tal cual se ha almacenado
     */
    String getName(){ return nombre; }
    
    
    /**
     * 
     * @param Se almacena la nueva dirección en mayusculas, si no está vacío. 
     */
    void setAddress(String nuevaDireccion){
         direccion = (nuevaDireccion == null) ? null : nuevaDireccion.toUpperCase();
    }   
    
    
    /**
     * 
     * @return Devuelve la dirección del inmueble
     */
    String getAddress(){ return direccion; }
    
    
    /**
     * 
     * @param metrosConstruidos Recibe los metros y si es mayor de 0 lo almacena, si no, no hace nada.
     */
    void setConstructedSurface(double metrosConstruidos){
        if (metrosConstruidos > 0)
        {
            metrosConstr = metrosConstruidos;
        }
    }    
    
    /**
     * 
     * @return Devuelve los metros construidos
     */
    double getConstructedSurface(){ return metrosConstr; }
    
    /**
     * 
     * @param metrosUtil Recibe los metros útiles y si es mayor que 0 los almacena
     */
    void setAvailableSurface(double metrosUtil){
        if (metrosUtil > 0)
        {
            metrosUtiles = metrosUtil;
        }
    } 
    
    /**
     * 
     * @return Devuelve los metros útiles
     */
    double getAvailableSurface(){ return metrosUtiles; }
    
    /**
     * 
     * @param propietario Recibe y si no está vacío almacena el nombre del propietario
     */
    void setOwner(String propietario){
           nombreProp = (propietario == null) ? null : propietario;
    }    
    
    /**
     * 
     * @return Devuelve el nombre del propietario
     */
    String getOwner(){ return nombreProp; }
    
    /**
     * 
     * @param direProp Recibe la dirección del propietario y si no está vacio lo almacena
     */
    void setOwnerAdress(String direProp){
    direccionProp = (direProp == null) ? null : direProp;
    }    
    
    /**
     * 
     * @return Devuelve la dirección del propietario
     */
    String getOwnerAdress(){ return direccionProp; }
    
    /**
     * 
     * @param precioNuevo Recibe el precio y si es mayor de 0 lo almacena
     */
    void setPrice(int precioNuevo){
        if(precioNuevo > 0)
        {
            precio = precioNuevo;
        }
    }    
    
    /**
     * 
     * @return Devuelve el precio
     */
    int getPrice(){ return precio; }
}
