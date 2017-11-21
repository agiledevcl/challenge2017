package cl.agile.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Agile
 * Clase encargada de resolver las urls bajo el prefijo '/api'
 *
 */
@Controller
@RequestMapping(value="/api")
public class APIController {
	
	private static Logger logger = LoggerFactory.getLogger(APIController.class);
	
	/**
	 * @return Un listado de Colores
	 */
	@RequestMapping(value = "/colours", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<String[]> getColours(){
		logger.info("Recibiendo consulta de colores");
		String[] colours = new String[5];
		colours[0] = "black";
		colours[1] = "yellow";
		colours[2] = "red";
		colours[3] = "blue";
		colours[4] = "pink";
		logger.info("Retornando listado de colores");
		return new ResponseEntity<>(colours, HttpStatus.OK);		
	}
}
