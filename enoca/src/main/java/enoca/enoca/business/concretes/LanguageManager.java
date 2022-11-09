package enoca.enoca.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import enoca.enoca.business.abstracts.LanguageService;
import enoca.enoca.business.requests.languages.CreateLanguageRequest;
import enoca.enoca.business.requests.languages.UpdateLanguageRequest;
import enoca.enoca.business.response.languages.GetAllLanguagesResponse;
import enoca.enoca.business.response.languages.GetLanguageByIdResponse;
import enoca.enoca.dataAccess.abstracts.LanguageRepository;
import enoca.enoca.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;

	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {

		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> result = new ArrayList<GetAllLanguagesResponse>();

		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());

			result.add(responseItem);
		}

		return result;
	}

	@Override
	public GetLanguageByIdResponse getById(int id) {

		Language language = languageRepository.findById(id).get();

		GetLanguageByIdResponse byIdResponse = new GetLanguageByIdResponse();
		byIdResponse.setName(language.getName());

		return byIdResponse;
	}

	@Override
	public void create(CreateLanguageRequest request) {
		
		Language language=new Language();
		language.setName(request.getName());
		
		this.languageRepository.save(language);

		
		
	}

	@Override
	public void update(UpdateLanguageRequest request) {
		
		Language language=this.languageRepository.findById(request.getId()).get();
		language.setName(request.getName());
		this.languageRepository.save(language);

	}

	@Override
	public void delete(int id) throws Exception {
		
		this.languageRepository.deleteById(id);

	}

}
