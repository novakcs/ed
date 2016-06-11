/* Clase empleados
Creado por David León Marín 1ºDAM- A
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmanagement;

/**
 *
 * @author David León Marín
 * 
 */
public class Employee {
    String nombre;
    String apellidos;
    String dni;
    Turn turnos[] = new Turn[7]; 
    int contador = 0; // entero que almacena el número de turnos que lleva guardados el empleado
    /**
     * Constructor que recibe el nombre y apellidos solo
     * @param aName
     * @param aSurname 
     */
    
    Employee(){
        
    }
    Employee(String aName, String aSurname)
    {
        nombre = aName;
        apellidos = aSurname;        
    }
    /**
     * Constructor que recibe el dni, el nombre y el apellido
     * @param aDNI
     * @param aName
     * @param aSurname 
     */
    Employee(String aDNI, String aName, String aSurname)
    {
        nombre = aName;
        apellidos = aSurname;
        if (compruebaDNI(aDNI)) dni = aDNI;
    }
    /**
     * Metodo para poner el nombre completo, si no recibe null
     * @param nombrenuevo 
     */
    void setName(String nombrenuevo)
    {
        nombre = (nombrenuevo== null) ? null : nombrenuevo;
    }
    /**
     * Devuelve el nombre
     * @return 
     */
    String getName()
    {
        return nombre;
    }
    /**
     * Introduce el apellido
     * @param apellidonuevo 
     */
    void setSurname(String apellidonuevo)
    {
        apellidos= (apellidonuevo == null) ? null : apellidonuevo;
    }
    /**
     * Devuelve el apellido
     * @return 
     */
    String getSurname()
    {
        return apellidos;
    }
    /**
     * Método que devuelve el nombre y apellidos, separados por una coma, 
     * si nameInUppercase está en true, devuelve el nombre en mayusculas, 
     * y si esta surnameInUpercase en true, devuelve el apellido en mayusculas
     * @param nameInUppercase
     * @param surnameInUpperCase
     * @return 
     */
    String getFullName( boolean nameInUppercase, boolean surnameInUpperCase)
    {
        String nombrecompleto = "";
        if (nombre != null) {
            if(nameInUppercase)
                {
                    nombrecompleto = nombre.toUpperCase();
                }        
            else
                {
                    nombrecompleto = nombre;
                }
        }

        // Agrego la coma sólo si ni nombre ni apellidos estan vacios
        
        if (nombre != null && apellidos != null) {
            nombrecompleto += ", ";
        }
        
        
        // Ahora los apellidos
        if (apellidos != null) {
                if(surnameInUpperCase)
            {
                nombrecompleto += apellidos.toUpperCase();
            }
                else
            {
                nombrecompleto += apellidos;
            }
        }

        // Y una vez agregado todo lo devuelvo
        return nombrecompleto;
    }
    /**
     * Metodo para introducir el dni, antes comprueba que el dni sea válido con el método "compruebaDNI"
     * @param aDNI 
     */
    void setDNI(String aDNI){
        if (compruebaDNI(aDNI)) dni = aDNI;
        
    }
    /**
     * Comprueba que el dni sea válido y devuelve true si lo es y false si no
     * @param dni
     * @return 
     */
    private boolean compruebaDNI(String dni)
    {
        boolean valido = false;
        // Compruebo que dni no esté vacío
        if (dni != null) {
            // Compruebo que tiene 8 numeros más letra, es decir, 9 carácteres.
            if (dni.length() == 9) {
                int numero;
                char letra;

                // Compruebo que los 8 primeros sean números y si lo es, lo guardo en la variable numeros
                boolean todonumeros = true;
                for (int i=0; i<8; i++) {

                     if(!Character.isDigit(dni.charAt(i))){
                           todonumeros = false;   
                           break;
                     } 
                }
                // Sí son todo numeros, lo guardo en variable
                if(todonumeros){
                    numero = Integer.parseInt(dni.substring(0,8));

                    // La letra ni compruebo que sea letra, ya que no lo considero necesario, ya que para empezar no están todas las letras en el dni
                    // La almaceno y luego, sea lo que sea, si es coincide con lo que toca, bien, si no, pues no lo guardo
                    letra = dni.charAt(8);
                    
                    // Array de los carácteres con las letras del dni
                    char[] letraDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};  
                    
                    //Ahora compruebo que la letra sea válida, si lo es, almaceno el DNI (Compruebo restando 32 al char introducido, para ver si lo ha puesto en minúsculas y también darlo como válido
                    if(letra == letraDni[numero%23] || letra - 32 == letraDni[numero%23] ){ 
                        // Sí coincide cambio valido a true
                        valido = true;                        
                    }
                }               
            }            
        } 
        // Devuelvo si es válido o no
        return valido;
    }
    /**
     * Devuelve el dni del empleado
     * @return 
     */
    String getDNI()
    {
        return dni;
    }
    /**
     * Agrega un turno al empleado, antes comprueba que no tenga 7 turnos agregados ya
     * @param turno 
     */
    void addTurn(Turn turno){
        if (turno != null) {
            if(contador < 7){
                turnos[contador] = turno;
                contador++;
            }   
        }          
    }
    /**
     * Borra un turno al empleado, recibe el nombre del día,
     * lo busca con el metodo "encontrarPosicionTurno" y si existe lo borra
     * @param aDay 
     */
    void removeTurn(String aDay){
        int posicion = encontrarPosicionTurno(aDay);
        if (posicion > -1 ) {
            for (int i = posicion; i < contador -1; i++) {
                turnos[i] = turnos[i+1];
            }   
            turnos[contador-1] = null;
            contador--;
        }   
    }
    /**
     * Busca la posición de un turno por el nombre del día 
     * Si no está devuelve -1
     * @param aDay
     * @return 
     */
    int encontrarPosicionTurno(String aDay){
        for (int i = 0; i < contador; i++) {
            if (turnos[i].getDay().equals(aDay.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Devieñve el número de turnos que hay gaurdados en forma de entero
     * @return 
     */
    int getTurnCount(){
        return contador;
    }
    
    Turn getTurnAt(int anIndex){
        if(anIndex >= contador){
            return null;
        }
        else{
            return turnos[anIndex];
        }
    }   
    /**
     * Devuelve el array de turnos guardado hasta ahora
     * Lo devuelvo justo de los turnos que hayan, no devuelvo el array con espacios vacíos
     * Si tiene 0 turnos, devuelvo null
     * @return 
     */
    Turn[] getTurns(){
        if (contador > 0) {
            Turn[] turnosTemporal = new Turn[contador];
            for (int i = 0; i < contador; i++) {
                turnosTemporal[i] = turnos[i]; 
            }
            return turnosTemporal;
        }
        else return null;
    }
}
