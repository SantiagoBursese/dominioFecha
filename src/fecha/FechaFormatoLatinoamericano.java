package fecha;

import excepcionesFecha.FechaNoValidaException;
import excepcionesFecha.FormatoIncorrectoException;

public class FechaFormatoLatinoamericano extends Fecha {
    final static String FORMATO_FECHA = "dd/MM/yyyy";
    
    public FechaFormatoLatinoamericano(String fecha) throws FormatoIncorrectoException, FechaNoValidaException{
        super(fecha,FORMATO_FECHA);
        this.dia = extraerDia(fecha);
        this.mes = extraerMes(fecha);
        this.anio = extraerAnio(fecha);
    }
    
    protected static int extraerDia(String fecha){
        return Integer.parseInt(fecha.substring(0,2));
    }
    
    protected static int extraerMes(String fecha){
        return Integer.parseInt(fecha.substring(3,5));
    }
    
    protected static int extraerAnio(String fecha){
        return Integer.parseInt(fecha.substring(6,10));
    }
  
}

