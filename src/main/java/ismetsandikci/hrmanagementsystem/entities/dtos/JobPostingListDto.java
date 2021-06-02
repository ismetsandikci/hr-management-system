package ismetsandikci.hrmanagementsystem.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingListDto {

	private int id;
	
	private String companyName;
	
	private String jobPositionName;
	
	private int openPositionsCount; 
	
	private LocalDate createdDate; 
	
	private LocalDate applicationDeadline;
}
