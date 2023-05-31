package com.consume.apinew.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.consume.apinew.models.ProduccionModelo;

@Controller
@RequestMapping("/Produccion")
public class ControladorProduccion {
	@GetMapping("{sw}")
	public String viewfruit(@PathVariable("sw") String sw, Model model) {
		String titulo = "P{agina API con SprinBot";
		model.addAttribute("name", sw);
		model.addAttribute("titulo", titulo);
		ProduccionModelo startProduResult = startProduResultDTO (sw);
		model.addAttribute("startProduccion", startProduResult);
		return "verProduccion";
	}
	
	public ProduccionModelo startProduResultDTO(String sw) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProduccionModelo> resp =
				restTemplate.getForEntity(
						String.format("https://myappfb-4718b.firebaseio.com/campeche/produccion/%s"+".json", sw), ProduccionModelo.class);
		return resp.getBody();
	}
}
