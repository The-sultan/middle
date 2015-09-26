package uy.edu.fing.intmidd.pagosacme.lealtad.controller;
 
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uy.edu.fing.intmidd.pagosacme.lealtad.persistence.DatosCliente;
import uy.edu.fing.intmidd.pagosacme.lealtad.persistence.DatosCliente.HistoriaEntry;
import uy.edu.fing.intmidd.pagosacme.lealtad.persistence.Storing;
 
@Controller
public class ConsultaPuntosController {
 
	@RequestMapping("/puntos")
	public ModelAndView showMessage(@RequestParam(value = "idCliente", required = true) Long idCliente) {
		
		System.out.println("in controller");

		DatosCliente dc = Storing.obtener(idCliente);
		
		ModelAndView mv;
		if (dc == null) {
			mv = new ModelAndView("cliente_no_existe");
			mv.addObject("idCliente", idCliente);
		} else {
			List<HistoriaEntry> historial = dc.getHistorial();
			String tablaHistorial = armarTablaHistorial(historial);
			
			mv = new ModelAndView("puntos_cliente");
			mv.addObject("idCliente", idCliente);
			mv.addObject("puntos", dc.getPuntosAcumulados());
			mv.addObject("historial", tablaHistorial);
		}
		
		return mv;
	}
	
//	@RequestMapping("/welcome")
//	public ModelAndView helloWorld() {
// 
//		String message = "<br><div style='text-align:center;'>"
//				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
//		return new ModelAndView("welcome", "message", message);
//	}
	
	private String armarTablaHistorial(List<HistoriaEntry> historial) {
		
		StringBuilder sb = new StringBuilder();
		
		for (HistoriaEntry he : historial) {
			sb.append("<tr>");
			sb.append("<td>").append(he.getFechaHoraPago()).append("</td>");
			sb.append("<td>").append(he.getCodigoMoneda().value).append("</td>");
			sb.append("<td>").append(he.getMonto()).append("</td>");
			sb.append("<td>").append(he.getPuntosGenerados()).append("</td>");
			sb.append("</tr>");
		}
		
		return sb.toString();
	}
}