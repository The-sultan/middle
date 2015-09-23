package uy.edu.fing.inco.lins.endpoints.ServiceActivators;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import uy.edu.fing.inco.lins.domain.PagoOffline;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpoint;

/**
 *
 * @author Farid
 */
@Component
public class OfflineServiceActivator extends AbstractServiceActivator<VentaEntradasEndpoint, PagoOffline> {

	@Override
	public ConfirmacionPago call(PagoOffline pagoOffline) throws Exception {

		ConfirmacionPago confirmacionPago = new ConfirmacionPago();
		ICsvBeanWriter beanWriter = null;
		String OS = System.getProperty("os.name").toLowerCase();
		String filePath = null;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
		if (OS.indexOf("win") >= 0) {
			// para los que corran en WIN no se les rompa nada
			filePath = "C://middleware-" + sdf.format(pagoOffline.getHoraCobro()) + ".csv";
		} else {
			filePath = System.getProperty("user.home") + File.separator + "middleware-"
					+ sdf.format(pagoOffline.getHoraCobro()) + ".csv";
		}
		
		beanWriter = new CsvBeanWriter(new FileWriter(filePath),CsvPreference.STANDARD_PREFERENCE );
		
		String[] headers = getCSVHeaders();

		beanWriter.writeHeader(headers);
		beanWriter.write(pagoOffline, headers, getProcessors());
		beanWriter.close();
		confirmacionPago.setDescripcion("PAGO OK");
		return confirmacionPago;
	}

	private CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // clientId
				new NotNull(), // moneda
				new NotNull(), // monto
				new FmtDate("ddMMyy"), // diaCobro
				new FmtDate("hhmmss"), // horaCobro

		};

		return processors;
	}

	private String[] getCSVHeaders() {

		return new String[] { "identificadorCliente", "codigoMoneda", "monto", "fechaCobro", "horaCobro" };

	}

}
