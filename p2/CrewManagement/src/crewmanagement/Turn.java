/*Clase turnos
Creado por David León Marín 1ºDAM- A
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmanagement;

/**
 *
 * @author David León Marín
 */
public class Turn {
    String diaSemana;
    int horaInicio;
    int horaFin;    
    /**
     * Constructor de Turn que recibe sólo el día de la semana
     * @param aDay 
     */
    Turn(){
        
    }
    
    Turn(String aDay)
    {
        diaSemana = aDay;
    }
    /**
     * Constructor de Turn que recibe eldía de la semana, la hora de inicio y de fin del turno
     * @param aDay
     * @param aInitHour
     * @param aFinishHour 
     */
    Turn(String aDay, int aInitHour, int aFinishHour)
    {   
        
        diaSemana = (aDay == null) ? null: aDay.toUpperCase();
        horaInicio = aInitHour;
        horaFin = aFinishHour;
    }
    /**
     * Para poner el día del turno, si es null guarda null.
     * @param dia 
     */
    void setDay(String dia)
    {
        diaSemana = (dia == null) ? null : dia.toUpperCase() ;
    }
    /**
     * Devuelve el día del turno
     * @return 
     */
    String getDay()
    {
        return diaSemana;
    }
    /**
     * Para poner la hora de inicio el turno, comprueba que esté entre 0 y 23 horas
     * @param hora 
     */
    void setInitHour(int hora)
    {
        if (hora >= 0 && hora < 24)
        {
            horaInicio = hora;
        }
    }
    /**
     * Devuelve la hora de inicio del turno
     * @return 
     */
    int getInitHour()
    {
        return horaInicio;
    }
    /**
     * Para poner la hora de fin del turno
     * @param hora 
     */
    void setFinishHour(int hora)
    {
        if (hora >= 0 && hora < 24)
        {
            horaFin = hora;
        }
    }
    /**
     * Devuelve la hora de fin del turno
     * @return 
     */
    int getFinishHour()
    {
        return horaFin;
    }
}
