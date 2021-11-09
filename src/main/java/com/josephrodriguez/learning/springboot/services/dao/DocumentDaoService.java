package com.josephrodriguez.learning.springboot.services.dao;

import com.josephrodriguez.learning.springboot.data.entity.Document;
import com.josephrodriguez.learning.springboot.data.repository.DocumentRepository;
import com.josephrodriguez.learning.springboot.dto.http.DocumentDto;
import com.josephrodriguez.learning.springboot.services.mapping.DefaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentDaoService {

    @Autowired
    private DocumentRepository repository;

    @Autowired
    private DefaultMapper mapper;

    public List<DocumentDto> getAll() {
        final List<DocumentDto> result = repository.findAll()
                .stream()
                .map(entity -> mapper.fromEntity2Dto(entity))
                .collect(Collectors.toList());

        return result;
    }

    public List<DocumentDto> saveAll(List<DocumentDto> documents) {

        List<Document> entities = documents
                .stream()
                .map(dto -> mapper.fromDto2Entity(dto))
                .collect(Collectors.toList());

        return repository.saveAll(entities)
                .stream()
                .map(entity -> mapper.fromEntity2Dto(entity))
                .collect(Collectors.toList());
    }

    public DocumentDto findById(String code) throws ResourceNotFoundException {

        Document entity = repository
                .findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + code));

        return mapper.fromEntity2Dto(entity);
    }

    public DocumentDto save(DocumentDto dto) {

        Document mappedEntity = mapper.fromDto2Entity(dto);
        Document responseEntity = repository.save(mappedEntity);
        return mapper.fromEntity2Dto(responseEntity);
    }

    public void deleteById(String code) {
        repository.deleteById(code);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
