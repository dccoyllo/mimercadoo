package udaff.edu.pe.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	private String upload_folder = ".//src//main//resources//static//img//";
//	private String upload_folder = ".//src//main//resources//files//";
	
	@Override
	public void saveFileCatalogo(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }
	}

}
