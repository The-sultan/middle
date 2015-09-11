package hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Farid
 * 
 * Para no utilizar archivos de configuraci�n (xml) se crea esta clase.
 * Lo �nico que hace es definir el "basePackage" como el paquete hello
 * Esto hace que al levantar spring, se escanee ese paquete en busqueda de 
 * spring annotations.
 */
@Configuration
@ComponentScan(basePackages = "hello")
public class AppConfig {
    
}
