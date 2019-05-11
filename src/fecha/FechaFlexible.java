package fecha;

import excepcionesFecha.FechaNoValidaException;
import excepcionesFecha.FormatoIncorrectoException;


public class FechaFlexible extends Fecha {
    private final String formatoLatinoamerica = "dd/MM/yyyy";
    private final String formatoNorteamerica = "MM/dd/yyyy";
    private final String formatoISO = "yyyy/MM/dd";
    public FechaFlexible(String fecha) {    
        super();
        if (cumpleFormato(fecha, formatoLatinoamerica) && fechaValida(fecha, formatoLatinoamerica)) {
            FechaFormatoLatinoamericano fechaFormatoLatinoamericano = new FechaFormatoLatinoamericano(fecha);
            dia = FechaFormatoLatinoamericano.extraerDia(fecha);
            mes = FechaFormatoLatinoamericano.extraerMes(fecha);
            anio = FechaFormatoLatinoamericano.extraerAnio(fecha);
        } else if (cumpleFormato(fecha, formatoNorteamerica) && fechaValida(fecha, formatoNorteamerica)) {
            FechaFormatoNorteamericano fechaFormatoNorteamericano = new FechaFormatoNorteamericano(fecha);
            dia = FechaFormatoNorteamericano.extraerDia(fecha);
            mes = FechaFormatoNorteamericano.extraerMes(fecha);
            anio = FechaFormatoNorteamericano.extraerAnio(fecha);
        } else if(cumpleFormato(fecha, formatoISO) && fechaValida(fecha, formatoISO)) {
            FechaEstandarInternacional fechaFormatoIso = new FechaEstandarInternacional(fecha);
            dia = FechaEstandarInternacional.extraerDia(fecha);
            mes = FechaEstandarInternacional.extraerMes(fecha);
            anio = FechaEstandarInternacional.extraerAnio(fecha);
        }
        else if (!fechaValida(fecha,formatoNorteamerica)){
            throw new FechaNoValidaException("La fecha ingresada es invalida");
        }
        else{
            throw new FormatoIncorrectoException ("Formato no valido de fecha");
        }
    }

}
