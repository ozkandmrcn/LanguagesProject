package enoca.enoca.business.response.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {

	private int technologyId;
	private String technologyName;
	private int programmingLanguageId;
	private String programmingLanguageName;
	

}
