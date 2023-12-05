package com.paperpath.demo.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
/**
 *
 * @author Amin
 */
@Service
public class WriterService {
    @Autowired
    private WriterRepository quillRepository;

    public void saveContent(String title, String content) {
        Writer quillEntity = new Writer();
        quillEntity.setContent(content);
        quillRepository.save(quillEntity);
    }
    
    
    public String getContentById(Long id) {
        Optional<Writer> quillEntityOptional = quillRepository.findById(id);

        return quillEntityOptional.map(Writer::getContent).orElse("");
    }
    
      public List<Writer> getAllContent() {
        return quillRepository.findAll();
    }
}

