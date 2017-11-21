package cl.agile.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Agile
 * Clase encargada de resolver las urls bajo el prefijo '/portal'
 *
 */
@Controller
@RequestMapping(value="/portal")
public class ViewController {
	
	private static Logger logger = LoggerFactory.getLogger(ViewController.class);

	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return Index Page
	 */
	@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
	public String views(HttpServletRequest request,
			HttpServletResponse response, 
			HttpSession session){
			logger.info("Requesting index page");
			return "index";		
	}


}
