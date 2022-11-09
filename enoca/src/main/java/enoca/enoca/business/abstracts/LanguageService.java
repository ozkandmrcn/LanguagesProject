package enoca.enoca.business.abstracts;

import java.util.List;

import enoca.enoca.business.requests.languages.CreateLanguageRequest;
import enoca.enoca.business.requests.languages.UpdateLanguageRequest;
import enoca.enoca.business.response.languages.GetAllLanguagesResponse;
import enoca.enoca.business.response.languages.GetLanguageByIdResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();

	GetLanguageByIdResponse getById(int id);

	void create(CreateLanguageRequest request);

	void update(UpdateLanguageRequest request);

	void delete(int id) throws Exception;

}
