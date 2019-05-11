package FechaTest;

import excepcionesFecha.FechaNoValidaException;
import excepcionesFecha.FormatoIncorrectoException;
import fecha.Fecha;
import fecha.FechaEstandarInternacional;
import fecha.FechaFlexible;
import fecha.FechaFormatoLatinoamericano;
import fecha.FechaFormatoNorteamericano;
import org.junit.Assert;
import org.junit.Test;


public class FechaTest {
    @Test
    public void fecha_seCreaFechaConFormatoInternacional() {
        FechaEstandarInternacional fecha = new FechaEstandarInternacional("2019/06/29");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test
    public void fecha_seCreaFechaConFormatoLatinoamericano() {
        FechaFormatoLatinoamericano fecha = new FechaFormatoLatinoamericano("29/06/2019");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test
    public void fecha_seCreaFechaConFormatoNorteamericano() {
        FechaFormatoNorteamericano fecha = new FechaFormatoNorteamericano("06/29/2019");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test(expected = FormatoIncorrectoException.class)
    public void fecha_seCreaMalElFormatoDeUnaFechaNorteamericana() {
        FechaFormatoNorteamericano fecha = new FechaFormatoNorteamericano("06/29/20199");
    }

    @Test(expected = FechaNoValidaException.class)
    public void fecha_seCreaUnaFechaNoValidaNorteamericana() {
        FechaFormatoNorteamericano fecha = new FechaFormatoNorteamericano("13/29/2019");
    }
    
     @Test(expected = FormatoIncorrectoException.class)
        public void fecha_seCreaMalElFormatoDeUnaFechaFlexible() {
        FechaFlexible fecha = new FechaFlexible("06/29/20199");
    }

    @Test(expected = FechaNoValidaException.class)
    public void fecha_seCreaUnaFechaNoValidaFlexible() {
        FechaFlexible fecha = new FechaFlexible("2000/29/20");
    }


    @Test
    public void fecha_seCreaFechaFlexibleConFormatoLatinoamericano() {
        FechaFlexible fecha = new FechaFlexible("29/06/2019");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test
    public void fecha_seCreaFechaFlexibleConFormatoNorteamericano() {
        FechaFlexible fecha = new FechaFlexible("06/29/2019");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test
    public void fecha_seCreaFechaFlexibleConFormatoEstandar() {
        FechaFlexible fecha = new FechaFlexible("2019/06/29");
        int dia = fecha.getDia();
        int mes = fecha.getMes();
        int anio = fecha.getAnio();
        Assert.assertEquals("No es el mismo dia", 29, dia);
        Assert.assertEquals("No es el mismo mes", 06, mes);
        Assert.assertEquals("No es el mismo anio", 2019, anio);
    }

    @Test
    public void diasEntre_pasaron29DiasEntreDosFechas() {
        FechaFormatoNorteamericano fecha1 = new FechaFormatoNorteamericano("10/12/2018");
        FechaFormatoLatinoamericano fecha2 = new FechaFormatoLatinoamericano("13/09/2018");
        Assert.assertEquals("No pasaron 29 dias", 29, Fecha.diasEntre(fecha1, fecha2));

    }

    @Test
    public void diasEntre_pasaron366diasEntreDosFechasPorqueEl2000EsBisiesto() {
        FechaFormatoNorteamericano fecha1 = new FechaFormatoNorteamericano("02/28/2000");
        FechaEstandarInternacional fecha2 = new FechaEstandarInternacional("2001/02/28");
        Assert.assertEquals("No pasaron 366 dias", 366, Fecha.diasEntre(fecha1, fecha2));
    }

    @Test
    public void diasEntre_noPasoNingunDiaEntre() {
        FechaFlexible fecha1 = new FechaFlexible("2000/02/28");
        FechaFormatoNorteamericano fecha2 = new FechaFormatoNorteamericano("02/28/2000");
        Assert.assertEquals("Pasaron dias",0, Fecha.diasEntre(fecha1, fecha2));
    }

    @Test
    public void fechaAnterior_fecha1EsAnteriorAFecha2() {
        FechaEstandarInternacional fecha1 = new FechaEstandarInternacional("2000/12/18");
        FechaFormatoLatinoamericano fecha2 = new FechaFormatoLatinoamericano("20/12/2000");
        Assert.assertEquals("Fecha2 es anterior a fecha1",fecha1, Fecha.fechaAnterior(fecha1, fecha2));
    }

    @Test
    public void fechaAnterior_fecha2EsAnteriorAFecha1() {
        FechaFlexible fecha1 = new FechaFlexible("30/09/1998");
        FechaFormatoNorteamericano fecha2 = new FechaFormatoNorteamericano("08/27/1998");
        Assert.assertEquals("Fecha1 es anterior a fecha2",fecha2, Fecha.fechaAnterior(fecha1, fecha2));
    }

    @Test
    public void fechaAnterior_MismaFechaDevuelveLaPrimeraFecha() {
        FechaEstandarInternacional fecha1 = new FechaEstandarInternacional("1998/09/30");
        FechaFormatoLatinoamericano fecha2 = new FechaFormatoLatinoamericano("30/09/1998");
        Assert.assertEquals("Las fechas no son iguales",fecha1, Fecha.fechaAnterior(fecha1, fecha2));
    }
}

