package enoca.enoca.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import enoca.enoca.business.abstracts.TechnologyService;
import enoca.enoca.business.requests.technologies.CreateTechnologyRequest;
import enoca.enoca.business.requests.technologies.UpdateTechnologyRequest;
import enoca.enoca.business.response.technologies.GetAllTechnologiesResponse;
import enoca.enoca.dataAccess.abstracts.LanguageRepository;
import enoca.enoca.dataAccess.abstracts.TechnologyRepository;
import enoca.enoca.entities.concretes.Language;
import enoca.enoca.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;

	public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {

		this.languageRepository = languageRepository;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {

		List<Technology> technologies = this.technologyRepository.findAll();
		List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<GetAllTechnologiesResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setTechnologyId(technology.getId());
			responseItem.setProgrammingLanguageId(technology.getLanguage().getId());
			responseItem.setTechnologyName(technology.getName());
			responseItem.setProgrammingLanguageName(technology.getLanguage().getName());

			getAllTechnologiesResponses.add(responseItem);
		}

		return getAllTechnologiesResponses;
	}

	@Override
	public void create(CreateTechnologyRequest request) {

		Technology technology = new Technology();
		Language programmingLanguage = this.languageRepository.findById(request.getLanguageId()).get();

		technology.setName(request.getName());
		technology.setLanguage(programmingLanguage);

		this.technologyRepository.save(technology);

	}

	@Override
	public void update(UpdateTechnologyRequest request) {
		
		Technology technology = this.technologyRepository.findById(request.getId()).get();

        Language programmingLanguage = this.languageRepository.findById(request.getLanguageId()).get();

        technology.setName(request.getName());
        technology.setLanguage(programmingLanguage);

        this.technologyRepository.save(technology);

	}

	@Override
	public void delete(int id) {
		this.technologyRepository.deleteById(id);

	}

}
