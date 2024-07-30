package br.edu.ifms.Carros.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;

import br.edu.ifms.Carros.modelo.Carros;
import br.edu.ifms.Carros.modelo.Modelo;
import br.edu.ifms.Carros.repository.CarrosRepository;
import br.edu.ifms.Carros.repository.ModeloRepository;

@Controller
public class CarroController {

	@Autowired
	private CarrosRepository carrosRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@RequestMapping("/") 
	public String index(Model model) {
		model.addAttribute("carros", carrosRepository.findAll());		
		return "admin/lista-carros";
	}
	
	@GetMapping("/carro/new")
	public String addCarros(Model model) {
		model.addAttribute("carros", new Carros());
		model.addAttribute("modelos", modeloRepository.findAll());
		return "cadastro/cadastro-carros";
	}
	
	@PostMapping("/carro/save")
	public String saveCarros(@Valid Carros carro,BindingResult result, Model model, 
				RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			List<Modelo> modelos = modeloRepository.findAll();
			model.addAttribute("modelos", modelos);
			return "cadastro/cadastro-carros";
		}
		
		carrosRepository.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro cadastrado!");  
		return "redirect:/";
	}
	
	
	@GetMapping("/modelo/new")
	public String addModelo(Model model) {
		model.addAttribute("modelo", new Modelo());
		return "cadastro/cadastro-modelo";
	}

	@PostMapping("/modelo/save")
	public String saveModelo(@Valid Modelo modelo, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "cadastro/cadastro-modelo";
		}	
		modeloRepository.save(modelo);
		attributes.addFlashAttribute("mensagem", "Modelo cadastrado!");
		return "redirect:/";
	}
	
	
}
