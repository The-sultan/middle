package uy.edu.fing.inco.lins.endpoints.transformers;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import uy.edu.fing.inco.lins.domain.DatosLealtad;
import uy.edu.fing.inco.lins.domain.PagoMOM;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasResult;


/**
 * @author Oscar
 *
 */
@MessageEndpoint
public class EntradaToLealtadTransformer {

	@Transformer(inputChannel="pagoVentaTransformerChannel", outputChannel="lealtadChannel")
	public DatosLealtad pagoVentaConverter(PagoMOM pagoMOM) {
		
		DatosLealtad result = new DatosLealtad();
        result.setIdCliente(pagoMOM.getIdCliente());
        result.setCodigoMoneda(pagoMOM.getCodigoMoneda());
        result.setMonto(pagoMOM.getMonto());
        result.setFechaHoraCobro(pagoMOM.getFechaPago());
        
        return result;
	}

}
