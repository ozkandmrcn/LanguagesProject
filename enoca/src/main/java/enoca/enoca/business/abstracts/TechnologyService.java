package enoca.enoca.business.abstracts;

import java.util.List;

import enoca.enoca.business.requests.technologies.CreateTechnologyRequest;
import enoca.enoca.business.requests.technologies.UpdateTechnologyRequest;
import enoca.enoca.business.response.technologies.GetAllTechnologiesResponse;

public interface TechnologyService {

	List<GetAllTechnologiesResponse> getAll();

	void create(CreateTechnologyRequest request);

	void update(UpdateTechnologyRequest request);

	void delete(int id);

}
