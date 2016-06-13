import java.util.ArrayList;
import java.util.List;



public class Animal {    
    private int codigo;
    private String alias;
    private String especie;
    private String raza;
    private String color_pelo;
    private String fecha_nac;
    private float[] pesos = new float[10];
    private float pesoactual;

    public Familia mascota;
    public List<Historial> historial = new ArrayList<Historial> ();
    public Calendario calendario;

    public void setcodigo(int codigo) {}

    public void setalias(String alias) {}

    public void setespecie(String especie) {}

    public void setraza(String raza) {}

    public void setcolorpelo(String colorpelo) {}

    public void setfechanacimiento(String fecha) {}

    public void anyadirpeso(float peso) {}

    public int getcodigo() {return codigo;}

    public String getalias() {return alias;}

    public String getespecie() {return especie;}

    public String getraza() {return raza;}

    public String getcolorpelo() {return color_pelo;}

    public String getfechanac() {return fecha_nac}

    public float getpesomedio() {
	if(pesos.lenght() >0){
		float pesos = 0;
		for(i=0, i<pesos.lenght(), i++){
			pesos+= pesos[i];
	    	}
		return pesos/pesos.lenght();
	}
	else return 0;

    public float getpesoactual() {return pesoactual;}

}
