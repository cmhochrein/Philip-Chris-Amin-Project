package com.paperpath.demo.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Amin
 */
@Service
public class WriterService {
    @Autowired
    private WriterRepository quillRepository;

    public void saveContent(String content) {
        Writer quillEntity = new Writer();
        quillEntity.setContent(content);
        quillRepository.save(quillEntity);
    }
}