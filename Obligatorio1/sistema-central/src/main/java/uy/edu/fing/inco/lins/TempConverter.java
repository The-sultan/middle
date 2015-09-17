package uy.edu.fing.inco.lins;

import org.springframework.integration.annotation.Gateway;

/**
 * @author Mauricio Vignale
 */

 public interface TempConverter {

 	@Gateway(requestChannel = "convert.input")
 	float fahrenheitToCelcius(float fahren);

 }
