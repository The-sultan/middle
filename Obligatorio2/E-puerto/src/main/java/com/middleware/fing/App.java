package com.middleware.fing;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanWrapperImpl;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.middleware.fing.model.Order;
import com.middleware.fing.model.OrderResult;
import com.middleware.fing.utils.CSVUtils;

/**
 * 
 * @author mauri
 *
 */

public class App {
	public static void main(String[] args) {
		// MAP TO REMEMBER ORDERS SO WE CAN CANCEL THEM

		String OS = System.getProperty("os.name").toLowerCase();

		String folderOrderPath = null;
		String folderConfirmPath = null;
		String folderCancelPath = null;

		ICsvBeanReader beanReader = null;
		ICsvBeanWriter beanWriter = null;
		if (OS.indexOf("win") >= 0) {
			// para los que corran en WIN no se les rompa nada
			folderOrderPath = "C:\\Midddleware-Ordenes";
			folderConfirmPath = "C:\\Midddleware-Confirmaciones";
			folderCancelPath = "C:\\Midddleware-Cancelaciones";
		} else {
			folderOrderPath = System.getProperty("user.home") + File.separator + "Middleware-Ordenes";
			folderConfirmPath = System.getProperty("user.home") + File.separator + "Middleware-Confirmaciones";
			folderCancelPath = System.getProperty("user.home") + File.separator + "Middleware-Cancelaciones";
		}
		// ORDER POLLING
		Path myDir = Paths.get(folderOrderPath);
		try {
			WatchService watcher = myDir.getFileSystem().newWatchService();
			myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

			WatchKey watckKey = watcher.take();
			while (true) {
				List<WatchEvent<?>> events = watckKey.pollEvents();

				for (WatchEvent<?> event : events) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						// NEW CSV DEPLOYED ON FOLDER, PROCESSING...

						try {
							System.out.println("Created: " + event.context().toString());

							beanReader = new CsvBeanReader(
									new FileReader(folderOrderPath + File.separator + event.context().toString()),
									CsvPreference.STANDARD_PREFERENCE);
							final String[] header = beanReader.getHeader(true);
							final CellProcessor[] processors = CSVUtils.getOrderProcessors();

							Order order;
							while ((order = beanReader.read(Order.class, header, processors)) != null) {
								OrderResult res = new OrderResult();
								res.setIdentificadorCompra(order.getIdentificadorCompra());
								res.setIdentificadorReserva(UUID.randomUUID().toString());
								res.setCodigo(0);
								res.setDescripcion("OK");
								try {
									beanWriter = new CsvBeanWriter(
											new FileWriter(
													folderConfirmPath + File.separator + event.context().toString()),
											CsvPreference.STANDARD_PREFERENCE);

									final CellProcessor[] confirmProcessors = CSVUtils.getConfirmProcessors();
									final String[] headerConfirm = CSVUtils.getCSVConfirmHeaders();

									beanWriter.writeHeader(headerConfirm);

									beanWriter.write(res, headerConfirm, confirmProcessors);
								} finally {
									if (beanWriter != null) {
										beanWriter.close();
									}
								}

								System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s",
										beanReader.getLineNumber(), beanReader.getRowNumber(), order));
							}

						} finally {
							if (beanReader != null) {
								beanReader.close();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		// CANCEL POLLING
		System.out.println("Done");

	}

}
