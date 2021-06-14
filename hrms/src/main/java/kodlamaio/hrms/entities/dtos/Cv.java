package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {
	private int id;
	private String language;
	private String level;
	private String uniName;
	private String department;
	private String workplaceName;
	private String imageUrl;
}
