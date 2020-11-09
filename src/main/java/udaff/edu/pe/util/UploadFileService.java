package udaff.edu.pe.util;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	public void saveFileCatalogo(MultipartFile file) throws IOException;
}
