package enoca.enoca.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enoca.enoca.business.abstracts.LanguageService;
import enoca.enoca.business.requests.languages.CreateLanguageRequest;
import enoca.enoca.business.requests.languages.UpdateLanguageRequest;
import enoca.enoca.business.response.languages.GetAllLanguagesResponse;
import enoca.enoca.business.response.languages.GetLanguageByIdResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private final LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getAllLanguages")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getLanguagesById")
	public GetLanguageByIdResponse getById(int id) {
		return languageService.getById(id);
	}

	@PostMapping("/createLanguages")
	public void create(CreateLanguageRequest language) {
		this.languageService.create(language);
	}

	@PutMapping("/updateLanguages")
	public void update(UpdateLanguageRequest language) {
		this.languageService.update(language);
	}

	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
		languageService.delete(id);
	}

}
