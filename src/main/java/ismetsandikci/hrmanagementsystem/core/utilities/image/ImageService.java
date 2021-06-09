package ismetsandikci.hrmanagementsystem.core.utilities.image;

import org.springframework.web.multipart.MultipartFile;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<?> uploadPhoto(MultipartFile file);
}
