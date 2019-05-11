package fecha;

import excepcionesFecha.FechaNoValidaException;
import excepcionesFecha.FormatoIncorrectoException;

public class FechaEstandarInternacional extends Fecha {
    final static String FORMATO_FECHA = "yyyy/MM/dd";
    
    public FechaEstandarInternacional(String fecha) throws FormatoIncorrectoException, FechaNoValidaException {
        super(fecha,FORMATO_FECHA);
        this.dia = extraerDia(fecha);
        this.mes = extraerMes(fecha);
        this.anio = extraerAnio(fecha);
    }
    
    protected static int extraerDia(String fecha){
        return Integer.parseInt(fecha.substring(8,10));
    }
    
    protected static int extraerMes(String fecha){
        return Integer.parseInt(fecha.substring(5,7));
    }
    
    protected static int extraerAnio(String fecha){
        return Integer.parseInt(fecha.substring(0,4)); 
    }
}

