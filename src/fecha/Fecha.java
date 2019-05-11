package fecha;

import excepcionesFecha.FechaNoValidaException;
import excepcionesFecha.FormatoIncorrectoException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Fecha {
    protected int dia;
    protected int mes;
    protected int anio;
    
    public Fecha(){
    }
    
    public Fecha(String fecha, String formato) throws FormatoIncorrectoException, FechaNoValidaException {
        if(!cumpleFormato(fecha,formato)){
            throw new FormatoIncorrectoException("La fecha  no cumple con el formato " + formato);
        }
        if(!fechaValida(fecha,formato)){
            throw new FechaNoValidaException("La fecha no es valida");
        }
       
    }
    
    protected static boolean cumpleFormato(String fecha,String dateFormat){
        boolean cumpleFormato = true;
        if(fecha.length() != dateFormat.length())cumpleFormato = false;
        for(int i = 0 ; i < dateFormat.length() && cumpleFormato; i++){
            if(dateFormat.charAt(i) == '/'){
                cumpleFormato = fecha.charAt(i) == '/';
            }
            else{
                cumpleFormato = Character.isDigit(fecha.charAt(i));
            }
        }
        return cumpleFormato;
    }
    
     protected static boolean fechaValida(String fecha, String dateFormat){
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }
    
    public int getAnio() {
        return anio;
    }

    protected String representacionEnIso(){
        return anio + "/" + mes + "/" + dia;
    }
    
    public static int diasEntre(Fecha dia1, Fecha dia2){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            Date fechaInicial = dateFormat.parse(dia1.representacionEnIso());
            Date fechaFinal = dateFormat.parse(dia2.representacionEnIso());
            
            return Math.abs((int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000));
        } catch (ParseException ex) {
            Logger.getLogger(Fecha.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    };
    
    protected static boolean hayDiferenciaAnios(Fecha anio1, Fecha anio2){
        return anio1.getAnio() != anio2.getAnio();
    }
    
    protected static boolean hayDiferenciaMeses(Fecha mes1, Fecha mes2){
        return mes1.getMes() != mes2.getMes();
    }
    
    public static Fecha fechaAnterior(Fecha fecha1, Fecha fecha2){
        if(hayDiferenciaAnios(fecha1,fecha2)){
            return (fecha1.getAnio() < fecha2.getAnio()) ? fecha1 : fecha2;
        }
        else if(hayDiferenciaMeses(fecha1,fecha2)){
            return (fecha1.getMes() < fecha2.getMes()) ? fecha1 : fecha2;
        }
        else{
            return (fecha1.getDia() <= fecha2.getDia()) ? fecha1 : fecha2;
        }
    };
}

