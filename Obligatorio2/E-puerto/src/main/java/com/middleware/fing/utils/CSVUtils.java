package com.middleware.fing.utils;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public final class CSVUtils {

	
	private static final String[] ORDER_HEADERS = { "identificadorCompra", "identificadorProducto", "cantidad"};
	private static final String[] CONFIRM_HEADERS = { "identificadorCompra", "identificadorReserva", "codigo", "descripcion"};
	private static final String[] CANCEL_HEADERS = { "identificadorReserva" };
	
	private static final CellProcessor[] ORDER_PROCESSOR = new CellProcessor[] { 
			new NotNull(), // identificadorCompra
			new NotNull(), // identificadorProducto
			new NotNull(), // cantidad
	};
	
	private static final CellProcessor[] CONFIRM_PROCESSOR = new CellProcessor[] { 
			new NotNull(), // identificadorCompra
			new NotNull(), // identificadorReserva
			new NotNull(), // codigo
			new NotNull(), // descripcion
};
	
	private static final CellProcessor[] CANCEL_PROCESSOR = new CellProcessor[] { 
			new NotNull(), // identificadorReserva
	};
	
	public static CellProcessor[] getOrderProcessors() {

		return ORDER_PROCESSOR;
	}
	
	
	public static CellProcessor[] getConfirmProcessors() {

		return CONFIRM_PROCESSOR;
	}
	
	public static CellProcessor[] getCancelProcessors() {

		return CANCEL_PROCESSOR;
	}
	
	public static String[] getCSVOrderHeaders() {

		return ORDER_HEADERS;

	}
	
	public static String[] getCSVConfirmHeaders() {

		return CONFIRM_HEADERS;

	}
	public static String[] getCSVCancelHeaders() {

		return CANCEL_HEADERS;

	}
}
