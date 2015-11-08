
package uy.edu.fing.middleware.generated.amazonia;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2015-11-07T22:01:48.591-03:00
 * Generated source version: 2.5.1
 * 
 */
public final class StockLocal_StockLocalPort_Client {

    private static final QName SERVICE_NAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "StockLocalService");

    private StockLocal_StockLocalPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = StockLocalService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        StockLocalService ss = new StockLocalService(wsdlURL, SERVICE_NAME);
        StockLocal port = ss.getStockLocalPort();  
        
        {
        System.out.println("Invoking anularReserva...");
        java.lang.Long _anularReserva_arg0 = null;
        try {
            uy.edu.fing.middleware.generated.amazonia.DatoSalida _anularReserva__return = port.anularReserva(_anularReserva_arg0);
            System.out.println("anularReserva.result=" + _anularReserva__return);

        } catch (Exception_Exception e) { 
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking stockLocalLog...");
        try {
            java.util.List<java.lang.String> _stockLocalLog__return = port.stockLocalLog();
            System.out.println("stockLocalLog.result=" + _stockLocalLog__return);

        } catch (Exception_Exception e) { 
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking reservaProductos...");
        java.util.List<uy.edu.fing.middleware.generated.amazonia.DatoReserva> _reservaProductos_arg0 = null;
        try {
            uy.edu.fing.middleware.generated.amazonia.DatoSalida _reservaProductos__return = port.reservaProductos(_reservaProductos_arg0);
            System.out.println("reservaProductos.result=" + _reservaProductos__return);

        } catch (Exception_Exception e) { 
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}