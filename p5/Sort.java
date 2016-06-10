/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author David
 */
public class Sort {
    private List<Integer> lista = new ArrayList<Integer>();
    
    static DecimalFormat df = new DecimalFormat("0.000000"); 
    static int cantidad;
    Random numAleatorio = new Random();
    static Random r = new Random();
    
    public void llenarListaAleatoria(){
        for (int i = 0; i < 1000; i++) {  //HAGO LA LISTA DE UN TAMAÑO DE 1000
            lista.add(numAleatorio.nextInt(10000)); // Metos números hasta el 10000
        }
    }
    public void llenarListaOrdenada(){
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
        }
    }
    
    public void llenarListaInversa(){
        for (int i = 1000; i > 0; i--) {
            lista.add(i);
        }
    }
    public void llenarListaIguales(){
        for (int i = 0; i < 1000; i++) {
            lista.add(10);
        }
    }
    public void vaciarLista(){
        lista.clear();
    }
    
    public int[] BubbleSort(){
        int temp;
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
               
        if (lista.size()>1) // compruebo que sea mayor de 1 la lista para que no de error en caso contrario
        {
            
            datos[1]++; // acceso (if de abajo)
            for(int i = lista.size()-1; i >= 0; i--) {
                for(int j = 0; j < i; j++) {
                    datos[0]++; // comparaciones
                    datos[1] += 2; // accesos (por el if a continuación)
                    if(lista.get(j) > lista.get(j + 1)) {
                        datos[2]++; // swaps
                        temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        datos[1] += 4; // accesos con el swap
                    }
                }
            }        
            return datos;
        }
        else return datos;
    }
    
    public int[] SelectionSort(){
        int temp;
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
               
        if (lista.size()>1) // compruebo que sea mayor de 1 la lista para que no de error en caso contrario
        {
            // declare an int variable to hold value of index at which the element
            // has the smallest value
            int smallestIndex;

            // declare an int variable to hold the smallest value for each iteration
            // of the outer loop
            int smallest;

            // for each index in the array list
            datos[1]++; // accesos
            for (int curIndex = 0; curIndex < lista.size(); curIndex++) {

                    /* find the index at which the element has smallest value */
                    // initialize variables
                    datos[1]++; // accesos
                    smallest = lista.get(curIndex);
                    smallestIndex = curIndex;
                    datos[1]++; // accesos
                    for (int i = curIndex + 1; i < lista.size(); i++) {
                        datos[0]++; // comparaciones
                        datos[1]++; // accesos
                        if (smallest > lista.get(i)) {
                                // update smallest
                                datos[1]++; // accesos
                                smallest = lista.get(i);
                                smallestIndex = i;
                        }
                    }

                    /* swap the value */
                    // do nothing if the curIndex has the smallest value
                    datos[0]++; // comparaciones
                    if (smallestIndex == curIndex)
                            ;
                    // swap values otherwise
                    else {
                        temp = lista.get(curIndex);
                        lista.set(curIndex, lista.get(smallestIndex));
                        lista.set(smallestIndex, temp);
                        datos[1] += 4; // accesos
                        datos[2]++; // swaps
                    }
		}      
            return datos;
        }
        else return datos;  
    }
    
    public int[] InsertionSort(){
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
               
        if (lista.size()>1) // compruebo que sea mayor de 1 la lista para que no de error en caso contrario
        {
            datos[1]++; // accesos
            for(int i=1;i<lista.size();i++){
                datos[1]++; // accesos
                int key = lista.get(i);

                for(int j= i-1;j>=0;j--){
                    datos[0]++; // comparaciones
                    datos[1]++; // accesos
                    if(key<lista.get(j)){
                        // Shifting Each Element to its right as key is less than the existing element at current index
                        datos[1]+=2; // accesos
                        datos[2]++; // swaps
                        lista.set(j+1,lista.get(j));

                        // Special case scenario when all elements are less than key, so placing key value at 0th Position
                        datos[0]++; // comparaciones
                        if(j==0){
                            datos[1]++; // accesos
                            lista.set(0, key);
                        }
                    }else{
                        // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                        datos[1]++; // accesos
                        lista.set(j+1,key);
                        break; // You need to break the loop to save un necessary iteration
                    }
                }
        } 
            return datos;
        }
        else return datos;
    }
    
    public int[] QuickSort(){
        int temp;
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
               
        if (lista.size()>1) // compruebo que sea mayor de 1 la lista para que no de error en caso contrario
        {
            recursiveQuickSort(lista,0,lista.size()-1, datos);
            
            return datos;
        }
        else return datos;
    }
    void recursiveQuickSort(List<Integer> arr, int left, int right, int[] datos) {
          int index = partition(arr, left, right, datos);
          datos[0]++; // comparaciones
          if (left < index - 1)
                recursiveQuickSort(arr, left, index - 1, datos);
          datos[0]++; // comparaciones
          if (index < right)
                recursiveQuickSort(arr, index, right, datos);
    }
    
    int partition(List<Integer> arr, int left, int right, int[] datos){
              int i = left, j = right;
              int tmp;
              int pivot = arr.get((left + right) / 2);

              while (i <= j) {
                  datos[0]++; // comparaciones                  
                    while (arr.get(i) < pivot){
                        i++;
                        datos[0]++; // comparaciones
                        datos[1]++; // accesos
                    }
                    datos[1]++; // accesos El del while que no entra
                    datos[0]++; // comparaciones La del while que no entra   
                    while (arr.get(j) > pivot){
                        datos[0]++; // comparaciones
                        datos[1]++; // accesos
                        j--;
                    }
                    datos[0]++; // comparaciones La del while que no entra 
                    datos[1]++; // accesos el del while que no entra
                    datos[0]++; // comparaciones La del siguiente if
                    if (i <= j) {
                        
                          tmp =  arr.get(i);
                          arr.set(i, arr.get(j));
                          arr.set(j, tmp);
                          i++;
                          j--;
                          datos[1]+= 4; // accesos
                          datos[2]++; // swaps
                    }
              }
              datos[0]++; // comparaciones // La del while que no entra en él
              return i;
        }
    
    public int[] MergeSort(){
        int temp;
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
               
        if (lista.size()>1){ // compruebo que sea mayor de 1 la lista para que no de error en caso contrario        
            recursiveMergeSort(lista,datos);            
            return datos;
        }
        else return datos;
    }
    
    public static List<Integer> recursiveMergeSort( List<Integer> values, int[] datos)
        {
            datos[0]++; // comparaciones
            datos[1]++; // accesos
            if (values.size() ==1){
                return values;
            }
            else {
                datos[1]++; // accesos
                int mid= values.size()/2;
                List<Integer> left= new ArrayList<Integer>(mid);
                datos[1]++; // accesos
                List<Integer> right=new ArrayList<Integer>(values.size()-mid);

               for (int i = 0; i < mid; i++) {
                   datos[1]++; // accesos
                   left.add(values.get(i));
                   } 

               for (int i = mid; i < values.size(); i++) {
                   datos[1]++; // accesos
                   right.add(values.get(i));
               } 
               
               left=recursiveMergeSort(left, datos); 
               right=recursiveMergeSort(right, datos);
               merge(left,right,values, datos);
            }
               return values;
        }


        public static void merge(List<Integer>left,List<Integer>right,List<Integer>values, int[] datos)
        {
            int i1=0;// left Index
            int i2=0;// right Index
            //int InputIndex=0;


            datos[1]++; // accesos
            for (int i = 0; i < values.size(); i++) {
                datos[0]++; // comparaciones
                datos[1]++; // accesos
                if(i1==left.size()){
                    datos[1]+=2; // accesos
                    values.set(i, right.get(i2));
                    i2++;
                }
                else{
                    datos[0]++; // comparaciones
                    datos[1]++; // accesos
                    if (i2==right.size()){
                        datos[1]+=2; // accesos
                        values.set(i,left.get(i1));
                        i1++;
                    }
                    else{
                        datos[0]++; // comparaciones
                        datos[1]+=2; // accesos
                        if (left.get(i1)<=right.get(i2)) {
                            datos[1]+=2; // accesos
                            values.set(i,left.get(i1));
                            i1++;
                        }
                        else {
                            datos[0]++; // comparaciones
                            datos[1]+=2; // accesos
                            if (left.get(i1)>=right.get(i2)) {
                            datos[1]+=2; // accesos
                            values.set(i, right.get(i2));
                            i2++;
                            }
                        }
                    }
                }
            }
        }
        
    public int[] BusquedaBinaria(int numeroabuscar, int tamanyo){
        int inicio = 0;
        int fin = tamanyo;
        int pos;
        int[] datos = new int[2]; // aquí voy guardando comparaciones y accesos.
        while (inicio <= fin) {
            datos[0]++; // comparaciones (este es del while)
            pos = (inicio+fin) / 2;
            datos[0]++; // comparaciones
            datos[1]+= 2; // accesos Le sumo 2 y si entra en el primer if, le descuento 1, pues ya no va a hacer más comprobaciones.
            if ( lista.get(pos) == numeroabuscar ){
                datos[1]--; //le resto 1, pues ya no va a entrar en el elseif
                break;                
            }
            else if ( lista.get(pos) < numeroabuscar ) {
                inicio = pos+1;
            } 
            else {
                fin = pos-1;
            }          
        }
        datos[0]++; // comparaciones - Le sumo uno de la ultima comparación del while y que no ha entrado
        return datos;
    }
    
    public int[] BusquedaSecuencial(int numeroabuscar, int tamanyo){
        int[] datos = new int[2];
        for (int i = 0; i < tamanyo; i++) {
            datos[0]++; // comparaciones
            datos[1]++; // accesos
            if (lista.get(i) == numeroabuscar) {
                break;                
            }
        }
        return datos;
    }
    public void ImprimirDatos(int[] datos,double tiempo){
                
        System.out.print(df.format(tiempo/1000000) + " ms");
        System.out.format("%16d", datos[0]);
        System.out.format("%21d", datos[1]);
        System.out.format("%14d", datos[2]);
        System.out.println();
    }
    
    public void RunTimes(){
        double tiempo_inicio, tiempo;         

        
        int veces = 1000; 
        int[] datos = new int[3]; // aquí guardaré los datos de cada búsqueda: 0=comparaciones, 1=accesos, 2=swaps
        
        System.out.println("\n\n\nVECES QUE SE VA A EJECUTAR CADA TEST PARA LUEGO SACAR LA MEDIA Y ASÍ QUE RESULTE MÁS FIABLE: " + veces);
        System.out.println("\nTipo de búsqueda                                 Tiempo         Comparaciones          Accesos         Swaps");
        System.out.print("Bubble sort DESORDENADA                       "); 

        /*
            Test Ordenacion burbuja, desordenada
        */
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaAleatoria();
            tiempo_inicio = System.nanoTime();
            datos = BubbleSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion burbuja, ordenada
        */
        System.out.print("Bubble sort ORDENADA                          ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaOrdenada();
            tiempo_inicio = System.nanoTime();
            datos = BubbleSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
    ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion burbuja, Inversa
        */
        System.out.print("Bubble sort INVERSA                           ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaInversa();
            tiempo_inicio = System.nanoTime();
            datos = BubbleSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion burbuja, IGUALES
        */
        System.out.print("Bubble sort IGUALES                           ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaIguales();
            tiempo_inicio = System.nanoTime();
            datos = BubbleSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        ImprimirDatos(datos, tiempo);
        
        // CAMBIO DE MÉTODO DE ORDENACIÓN
        System.out.println("\u001B[31m" + "------------------------------------------------------------------------------------------------------------");
        
        
        System.out.print("\u001B[0m" + "Selection sort DESORDENADA                    "); 

        /*
            Test Ordenacion selección, desordenada
        */
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaAleatoria();
            tiempo_inicio = System.nanoTime();
            datos = SelectionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion  seleccion ordenada
        */
        System.out.print("Selection sort ORDENADA                       ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaOrdenada();
            tiempo_inicio = System.nanoTime();
            datos = SelectionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion  seleccion, Inversa
        */
        System.out.print("Selection sort INVERSA                        ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaInversa();
            tiempo_inicio = System.nanoTime();
            datos = SelectionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion seleccion, iguales
        */
        System.out.print("Selection sort IGUALES                        ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaIguales();
            tiempo_inicio = System.nanoTime();
            datos = SelectionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        vaciarLista();
        
        // CAMBIO DE MÉTODO DE ORDENACIÓN
        System.out.println("\u001B[31m" + "------------------------------------------------------------------------------------------------------------");
        
        
        System.out.print("\u001B[0m" + "Insertion sort DESORDENADA                    "); 

        /*
            Test Ordenacion insercion, desordenada
        */
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaAleatoria();
            tiempo_inicio = System.nanoTime();
            datos = InsertionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion insercion ordenada
        */
        System.out.print("Insertion sort ORDENADA                       ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaOrdenada();
            tiempo_inicio = System.nanoTime();
            datos = InsertionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion insercion Inversa
        */
        System.out.print("Insertion sort INVERSA                        ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaInversa();
            tiempo_inicio = System.nanoTime();
            datos = InsertionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion insercion, iguales
        */
        System.out.print("Insertion sort IGUALES                        ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaIguales();
            tiempo_inicio = System.nanoTime();
            datos = InsertionSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        vaciarLista();
        
        
        // CAMBIO DE MÉTODO DE ORDENACIÓN
        System.out.println("\u001B[31m" + "------------------------------------------------------------------------------------------------------------");
        
        
        System.out.print("\u001B[0m" + "Quick sort DESORDENADA                        "); 

        /*
            Test Ordenacion quick, desordenada
        */
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaAleatoria();
            tiempo_inicio = System.nanoTime();
            datos = QuickSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion quick ordenada
        */
        System.out.print("Quick sort ORDENADA                           ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaOrdenada();
            tiempo_inicio = System.nanoTime();
            datos = QuickSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion quick Inversa
        */
        System.out.print("Quick sort INVERSA                            ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaInversa();
            tiempo_inicio = System.nanoTime();
            datos = QuickSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion Quick, iguales
        */
        System.out.print("Quick sort IGUALES                            ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaIguales();
            tiempo_inicio = System.nanoTime();
            datos = QuickSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
      
        // CAMBIO DE MÉTODO DE ORDENACIÓN
        System.out.println("\u001B[31m" + "------------------------------------------------------------------------------------------------------------");
        
        
        System.out.print("\u001B[0m" + "Merge sort DESORDENADA                        "); 

        /*
            Test Ordenacion merge, desordenada
        */
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaAleatoria();
            tiempo_inicio = System.nanoTime();
            datos = MergeSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion merge ordenada
        */
        System.out.print("Merge sort ORDENADA                           ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaOrdenada();
            tiempo_inicio = System.nanoTime();
            datos = MergeSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion merge Inversa
        */
        System.out.print("Merge sort INVERSA                            ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaInversa();
            tiempo_inicio = System.nanoTime();
            datos = MergeSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test Ordenacion merge, iguales
        */
        System.out.print("Merge sort IGUALES                            ");
        tiempo = 0;
        for (int i = 0; i < veces; i++) {
            llenarListaIguales();
            tiempo_inicio = System.nanoTime();
            datos = MergeSort(); 
            tiempo += System.nanoTime() - tiempo_inicio;
            // Ahora vacio y relleno de nuevo la lista
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            vaciarLista();
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        ImprimirDatos(datos, tiempo);
        
        /*
            Test búsqueda Binaria
        */
        
        System.out.println("\n\nTiempos de búsqueda                              Tiempo        Comparaciones             Accesos ");
        System.out.print("BINARIA                                       "); 
        tiempo = 0;
        llenarListaOrdenada(); // La creo ordenada para saber siempre donde está el número que busco y los tiempos sean totalmente fiables
        int numero = 950; // Buscaré este.
        int tamanyo = lista.size(); // Calculo el tamaño aquí para que no afecte a los tiempos
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            datos = BusquedaBinaria(numero, tamanyo);
            tiempo += System.nanoTime() - tiempo_inicio;
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        System.out.print(df.format(tiempo/1000000) + " ms");
        System.out.format("%16d", datos[0]);
        System.out.format("%21d", datos[1]);
        System.out.println();

                System.out.print("SECUENCIAL                                    "); 
        tiempo = 0;

        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            datos = BusquedaSecuencial(numero, tamanyo);
            tiempo += System.nanoTime() - tiempo_inicio;
        }
        // Ahiora lo divido entre las veces que paso el test
        tiempo = tiempo/veces;
        // Imprimo
        System.out.print(df.format(tiempo/1000000) + " ms");
        System.out.format("%16d", datos[0]);
        System.out.format("%21d", datos[1]);
        System.out.println();
        vaciarLista();

    }   
    
    public void RunTests(){
        System.out.println("\n\nVAMOS A COMPROBAR QUE FUNCIONAN BIEN TODOS LOS ALGORITMOS.");
        System.out.println("Método                       Aleatoria      Ordenada     Inversa      Iguales");
        System.out.print("BUBBLE SORT:                     ");
        
        vaciarLista();
        llenarListaAleatoria();
        cantidad = lista.size(); // Compruebo el tamaño antes de ordenar, luego lo comparo con el de después de ordenar, para asegurarme de que no pierde ningún dato
        BubbleSort();
        ComprobarOrdenacion();
        System.out.print("            ");
        vaciarLista();
        llenarListaOrdenada();
        cantidad = lista.size();
        BubbleSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaInversa();
        cantidad = lista.size();
        BubbleSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaIguales();
        cantidad = lista.size();
        BubbleSort();
        ComprobarOrdenacion();

        System.out.print("\nSELECTION SORT:                  ");
        vaciarLista();
        llenarListaAleatoria();
        cantidad = lista.size();
        SelectionSort();
        ComprobarOrdenacion();
        System.out.print("            ");
        vaciarLista();
        llenarListaOrdenada();
        cantidad = lista.size();
        SelectionSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaInversa();
        cantidad = lista.size();
        SelectionSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaIguales();
        cantidad = lista.size();
        SelectionSort();
        ComprobarOrdenacion();
        
        System.out.print("\nINSERTION SORT:                  ");
        vaciarLista();
        llenarListaAleatoria();
        cantidad = lista.size();
        InsertionSort();
        ComprobarOrdenacion();
        System.out.print("            ");
        vaciarLista();
        llenarListaOrdenada();
        cantidad = lista.size();
        InsertionSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaInversa();
        cantidad = lista.size();
        InsertionSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaIguales();
        cantidad = lista.size();
        InsertionSort();
        ComprobarOrdenacion();
        
        System.out.print("\nQUICK SORT:                      ");
        vaciarLista();
        llenarListaAleatoria();
        cantidad = lista.size();
        QuickSort();
        ComprobarOrdenacion();
        System.out.print("            ");
        vaciarLista();
        llenarListaOrdenada();
        cantidad = lista.size();
        QuickSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaInversa();
        cantidad = lista.size();
        QuickSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaIguales();
        cantidad = lista.size();
        QuickSort();
        ComprobarOrdenacion();
        
        System.out.print("\nMERGE SORT:                      ");
        vaciarLista();
        llenarListaAleatoria();
        cantidad = lista.size();
        MergeSort();
        ComprobarOrdenacion();
        System.out.print("            ");
        vaciarLista();
        llenarListaOrdenada();
        cantidad = lista.size();
        MergeSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaInversa();
        cantidad = lista.size();
        MergeSort();
        ComprobarOrdenacion();
        System.out.print("           ");
        vaciarLista();
        llenarListaIguales();
        cantidad = lista.size();
        MergeSort();
        ComprobarOrdenacion();
        System.out.println();
        
    }

    public void ComprobarOrdenacion(){
        boolean valido = true;
        if (cantidad != lista.size()) { // Compruebo que el temaño del array sea igual antes que después de haber ordenado
            valido = false;
        }
        else{
            for (int i = 0; i < lista.size()-1; i++) {
                if (lista.get(i) > lista.get(i+1)) { 
                    valido = false;
                    break;
                }
            } 
        }       
        if(valido) System.out.print("OK");
        else System.out.print("NO");
    }
}
