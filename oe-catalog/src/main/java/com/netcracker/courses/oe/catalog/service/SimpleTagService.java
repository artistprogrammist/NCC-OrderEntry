package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.TagDTO;
import com.netcracker.courses.oe.catalog.entity.Tag;
import com.netcracker.courses.oe.catalog.repository.TagRepository;
import com.netcracker.courses.oe.catalog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleTagService implements TagService {

    private final TagRepository tagRepository;

    private final Converter converter;

    @Autowired
    public SimpleTagService(TagRepository tagRepository, Converter converter) {
        this.tagRepository = tagRepository;
        this.converter = converter;
    }

    @Override
    public TagDTO save(TagDTO tagDTO) {
        Tag tag = converter.toTag(tagDTO);
        Tag save = tagRepository.save(tag);
        return converter.toTagDTO(save);
    }

    @Override
    public List<TagDTO> getAllTags() {
        List<Tag> all = tagRepository.findAll();
        return converter.toTagsDTO(all);
    }

    @Override
    public TagDTO getTag(Long id) {
        return converter.toTagDTO(tagRepository.findOne(id));
    }

    @Override
    public TagDTO update(TagDTO tagDTO) {
        return save(tagDTO);
    }

    @Override
    public void delete(Long id) {
        tagRepository.delete(id);
    }

    @Override
    public List<TagDTO> saveAll(List<TagDTO> tagsDTO) {
        List<Tag> tags = converter.toTags(tagsDTO);
        List<Tag> save = tagRepository.save(tags);
        return converter.toTagsDTO(save);
    }
}
