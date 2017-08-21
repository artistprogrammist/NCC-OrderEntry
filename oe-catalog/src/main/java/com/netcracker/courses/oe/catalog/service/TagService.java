package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.TagDTO;

import java.util.List;

public interface TagService {

    TagDTO save(TagDTO tagDTO);

    List<TagDTO> getAllTags();

    TagDTO getTag(Long id);

    TagDTO update(TagDTO tagDTO);

    void delete(Long id);

    List<TagDTO> saveAll(List<TagDTO> tagsDTO);
}
