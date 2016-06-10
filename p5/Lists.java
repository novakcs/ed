/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.text.*;
/**
 *
 * @author David
 */
public class Lists {
    private ArrayList<Integer> miarraylist = new ArrayList<Integer>();
    private LinkedList<Integer> milinkedlist = new LinkedList<Integer>();
      
    public  void llenarListas(){

        
        for (int i = 0; i < 1000; i++) {            
            miarraylist.add(i); 
            milinkedlist.add(i); 
       }
    }
    
    private void agregar_final_arraylist(int valor){ 
        miarraylist.add(valor);
    }
    private void agregar_final_linkedlist(int valor){
        milinkedlist.add(valor);
    }
    private void agregar_inicio_arraylist(int valor){
        miarraylist.add(0,valor);
    }
    private void agregar_inicio_linkedlist(int valor){
        milinkedlist.addFirst(valor);
    }
    private void agregar_mitad_arraylist(int posicion, int valor){ // calculo antes la posición para no tener que perder tiempo averiguandola dentro del método
        miarraylist.add(posicion, valor);
    }
    private void agregar_mitad_linkedlist(int posicion, int valor){
        milinkedlist.add(posicion, valor);
    }
    private void borrar_final_arraylist(int posicion){ 
        miarraylist.remove(posicion);
    }
    private void borrar_final_linkedlist(int posicion){
        milinkedlist.remove(posicion);
    }
    private void borrar_inicio_arraylist(){
        miarraylist.remove(0);
    }
    private void borrar_inicio_linkedlist(){
        milinkedlist.remove(0);
    }
    private void borrar_mitad_arraylist(int posicion){
        miarraylist.remove(posicion);
    }
    private void borrar_mitad_linkedlist(int posicion){
        milinkedlist.remove(posicion);
    }
    /*
    AL PRINCIPIO HABÍA HECHO 6 MÉTODOS PARA BORRAR POR VALOR, PERO CLARO, SE HACEN DEMASIADOS ACCESOS AL ARRAY PARA CALCULAR EL ÚLTIMO VALOR
    ASÍ QUE HAGO UNO QUE RECIBA EL VALOR A BORRAR QUE LO HE CALCULADO EN RUNTIMES ANTES DE CONTAR EL TIEMPO
    
    private void borrar_valor_final_arraylist(){
        miarraylist.remove(Object miarraylist.get(miarraylist.size()-1)); 
    }
    private void borrar_valor_final_linkedlist(){
        milinkedlist.remove(Object milinkedlist.get(milinkedlist.size()-1));
    }
    private void borrar_valor_principio_arraylist(){
        miarraylist.remove(Object miarraylist.get(0));
    }
    private void borrar_valor_principio_linkedlist(){
        milinkedlist.remove(Object milinkedlist.get(0));
    }
    private void borrar_valor_mitad_arraylist(){
        miarraylist.remove(Objectmiarraylist.get(miarraylist.size()/2));
    }
    private void borrar_valor_mitad_linkedlist(){
        milinkedlist.remove(Object milinkedlist.get(milinkedlist.size()/2));
    }    
    
    */
    private void borrar_valor_arraylist(Object valor){
        miarraylist.remove(valor);
    }
    private void borrar_valor_linkedlist(Object valor){
        milinkedlist.remove(valor);
    }
    private void vaciar_arraylist(){
        miarraylist.clear();
    }
    private void vaciar_linkedlist(){
        milinkedlist.clear();
    }
    private void buscar_con_funciones_arraylist(int numeroabuscar){
        int posicion = miarraylist.indexOf(numeroabuscar); 
    }
    private void buscar_con_funciones_linkedlist(int numeroabuscar){
        int posicion = milinkedlist.indexOf(numeroabuscar);
    }
    private void buscar_implementado_arraylist(int numeroabuscar){
        for(int i = 0; i < miarraylist.size(); i++) {
            if (miarraylist.get(i) == numeroabuscar) {
                break;
            } 
        }
    }
    private void buscar_implementado_linkedlist(int numeroabuscar){
        for(int i = 0; i < milinkedlist.size(); i++) {
            if (milinkedlist.get(i) == numeroabuscar) {
                break;
            } 
        }
    }
    private void busqueda_binaria_arraylist(int numeroabuscar){
        int inicio = 0;
        int fin = miarraylist.size() - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( miarraylist.get(pos) == numeroabuscar )
              break;
            else if ( miarraylist.get(pos) < numeroabuscar ) {
         inicio = pos+1;
            } else {
         fin = pos-1;
            }          
        }
    }
    
    private void busqueda_binaria_linkedlist(int numeroabuscar){
        int inicio = 0;
        int fin = milinkedlist.size() - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( milinkedlist.get(pos) == numeroabuscar )  
              break;
            else if ( milinkedlist.get(pos) < numeroabuscar ) {
         inicio = pos+1;
            } else {
         fin = pos-1;
            }          
        }
    }
    
    // RUNTIMES //
    public void RunTimes(){
        double tiempo_inicio, tiempo_array, tiempo_linked;         

        DecimalFormat df = new DecimalFormat("0.000000"); 
        int veces = 1000; // Las veces que voy a repetir los test para que sean más fiables
        System.out.println("VECES QUE SE VA A EJECUTAR CADA TEST PARA LUEGO SACAR LA MEDIA Y ASÍ QUE RESULTE MÁS FIABLE: " + veces);
        //Lleno las listas
        llenarListas();
        
        System.out.println("\nTest                                                        ArrayList        LinkedList ");
        // Test 1 - Voy a pasar el test 100 veces y dividir el tiempo entre 100 para que sea más fiable
        tiempo_array = 0;
        int numero = 1001;
        int posicion = miarraylist.size();// calculo la ultima posicion para agregar luego de borrar (no le resto 1, porque despues de haber agregado tiene uno más)
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_final_arraylist(numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Ahora elimino de nuevo el último dato, para que el tiempo sea lo más exacto posible, siempre agrega el dato 1000.
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            borrar_final_arraylist(posicion);
        }
        tiempo_linked = 0;
        posicion = milinkedlist.size();
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_final_linkedlist(1001); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo borro
            borrar_final_linkedlist(posicion);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
                
        System.out.print("Test 1: Agregar un elemento al final                        ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 2
        
        tiempo_array = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_inicio_arraylist(numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Ahora elimino
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            borrar_inicio_arraylist();
        }
        tiempo_linked = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_inicio_linkedlist(numero); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo borro
            borrar_inicio_linkedlist();
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 2: Agregar un elemento al inicio                       ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 3
        // Calculo la mitad
        posicion = miarraylist.size()/2;
        tiempo_array = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_mitad_arraylist(posicion, numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Ahora elimino el dato
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            borrar_mitad_arraylist(posicion);
        }
        tiempo_linked = 0;
        posicion = milinkedlist.size()/2;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            agregar_mitad_linkedlist(posicion, numero); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo borro
            borrar_mitad_linkedlist(posicion);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 3: Agregar un elemento a mitad                         ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
       
        // Test 4
        tiempo_array = 0;
        posicion = miarraylist.size()-1;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_final_arraylist(posicion); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Ahora vuelvo a agregarlo
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_final_arraylist(numero);
        }
        tiempo_linked = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_final_linkedlist(posicion); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora vuelvo a agregarlo
            agregar_final_linkedlist(numero);
        }
        // Ahora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 4: Borrar el último elemento                           ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
     
        
        // Test 5
        tiempo_array = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_inicio_arraylist(); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Lo vuelvo a agregar
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_inicio_arraylist(numero);
        }
        tiempo_linked = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_inicio_linkedlist(); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo agrego
            agregar_inicio_linkedlist(numero);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 5: Borrar el primer elemento                           ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 6
        tiempo_array = 0;
        posicion = miarraylist.size()/2;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_mitad_arraylist(posicion); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Lo vuelvo a agregar
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_mitad_arraylist(posicion,numero);
        }
        tiempo_linked = 0;
        posicion = milinkedlist.size()/2;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_mitad_linkedlist(posicion); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo agrego
            agregar_mitad_linkedlist(posicion,numero);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 6: Borrar elemento central                             ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 7
        tiempo_array = 0;
        //Meto como último elemento un valor que es imposible que esté ahora, y así me aseguro de que no está repetido
        numero = 999999;
        agregar_final_arraylist(numero);
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_arraylist(numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Ahora vuelvo a agregarlo
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_final_arraylist(numero);
        }
        tiempo_linked = 0;
        agregar_final_linkedlist(numero);
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_linkedlist(numero); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora vuelvo a agregarlo
            agregar_final_linkedlist(numero);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 7: Borrar el último elemento por valor                 ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
     
        
        // Test 8
        tiempo_array = 0;   
        agregar_inicio_arraylist(numero);
        posicion = miarraylist.size()-1;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_arraylist(numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Lo vuelvo a agregar
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_inicio_arraylist(numero);
        }
        tiempo_linked = 0;
        agregar_inicio_linkedlist(numero);
        posicion = milinkedlist.size()-1;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_linkedlist(numero); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo agrego
            agregar_inicio_linkedlist(numero);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 8: Borrar el primer elemento por valor                 ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 9
        tiempo_array = 0;
        posicion = miarraylist.size()/2;
        agregar_mitad_arraylist(posicion,numero);
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_arraylist(numero); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Lo vuelvo a agregar
            // Esta parte ya no se suma en el tiempo de ejecución de los tests.
            agregar_mitad_arraylist(posicion,numero);
        }
        tiempo_linked = 0;
        posicion = milinkedlist.size()/2;
        agregar_mitad_linkedlist(posicion, numero);
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            borrar_valor_linkedlist(numero); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Ahora lo agrego
            agregar_mitad_linkedlist(posicion, numero);
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 9: Borrar elemento central por valor                   ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        
        // Test 10 
        tiempo_array = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            vaciar_arraylist(); 
            tiempo_array += System.nanoTime() - tiempo_inicio;
            // Vacio también la linked list para que no tenga luego un millon de registros, porque llenar, llena las dos.
            vaciar_linkedlist();
            // Y las lleno también. Todo esto no hay influido en mis cálculos de tiempo.
            llenarListas();
        }
        tiempo_linked = 0;
        for (int i = 0; i < veces; i++) {
            tiempo_inicio = System.nanoTime();
            vaciar_linkedlist(); 
            tiempo_linked += System.nanoTime() - tiempo_inicio;
            // Vacio también la arraylist para que no tenga luego un millon de registros
            vaciar_arraylist();
            // Y las lleno también. Todo esto no hay influido en mis cálculos de tiempo.
            llenarListas();
        }
        // Ahiora lo divido entre las veces que paso los test
        tiempo_array = tiempo_array/veces;
        tiempo_linked = tiempo_linked/veces;
        
        System.out.print("Test 10: Vaciar completamente                               ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
         // Test 11
        numero = 900; // Voy a buscar el 900
        tiempo_inicio = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            buscar_con_funciones_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            buscar_con_funciones_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 11: Buscar con funciones de la lista                   ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);

        // Test 12
        numero = miarraylist.get(0);
        tiempo_inicio = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            buscar_implementado_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(0);
        for (int i = 0; i < veces; i++) {
            buscar_implementado_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 12: Buscar con funcion implementada  al inicio         ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 13
        numero = miarraylist.get(miarraylist.size() /2);
        tiempo_inicio = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            buscar_implementado_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(milinkedlist.size()/2);
        for (int i = 0; i < veces; i++) {
            buscar_implementado_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 13: Buscar con funcion implementada a mitad            ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
             
        // Test 14
        numero = miarraylist.get(miarraylist.size()-1);
        tiempo_inicio = System.nanoTime();
        for (int i = 0; i < veces; i++) {
            buscar_implementado_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(milinkedlist.size()-1);
        for (int i = 0; i < veces; i++) {
            buscar_implementado_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 14: Buscar con funcion implementada al final           ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 15      
        tiempo_inicio = System.nanoTime();
        numero = miarraylist.get(0);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(0);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 15: Buscar de forma binaria al inicio                  ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 16
        tiempo_inicio = System.nanoTime();
        numero = miarraylist.get(miarraylist.size()/2);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(miarraylist.size()/2);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 16: Buscar de forma binaria al medio                   ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 17
        tiempo_inicio = System.nanoTime();
        numero = miarraylist.get(miarraylist.size()-1);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();
        numero = milinkedlist.get(miarraylist.size()-1);
        for (int i = 0; i < veces; i++) {
            busqueda_binaria_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 17: Buscar de forma binaria final                      ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
         // Test 18
        tiempo_inicio = System.nanoTime();
        numero = 999999999;
        for (int i = 0; i < veces; i++) {
            buscar_implementado_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();

        for (int i = 0; i < veces; i++) {
            buscar_implementado_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 18: Buscar con funcion implementada inexistente        ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        // Test 19
        tiempo_inicio = System.nanoTime();

        for (int i = 0; i < veces; i++) {
            busqueda_binaria_arraylist(numero); 
        }
        tiempo_array = (System.nanoTime() - tiempo_inicio)/veces;
        tiempo_inicio = System.nanoTime();

        for (int i = 0; i < veces; i++) {
            busqueda_binaria_linkedlist(numero);
        }
        tiempo_linked = (System.nanoTime() - tiempo_inicio)/veces;
        
        System.out.print("Test 19: Buscar de forma binaria inexistente                ");  
        imprimir_tiempos(tiempo_array, tiempo_linked, df);
        
        System.out.println();
    }
    
    // Me hago método para imprimir los tiempos en verde o rojo segun sea menor uno u otro, porque voy a repetirlo muchisimas veces
    private void imprimir_tiempos(Double tiempo_array, Double tiempo_linked, DecimalFormat df){        
        if (tiempo_array < tiempo_linked) {
            System.out.print("\u001B[32m" + df.format(tiempo_array/1000000)+ "          ");    
            System.out.print("\u001B[31m" + df.format(tiempo_linked/1000000)); 
        }
        else{
            System.out.print("\u001B[31m" + df.format(tiempo_array/1000000) + "          ");    
            System.out.print("\u001B[32m" + df.format(tiempo_linked/1000000)); 
        }        
        System.out.println("\u001B[0m" + "      milisegundos.");
    }
}
