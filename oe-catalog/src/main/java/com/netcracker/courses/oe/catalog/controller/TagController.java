package com.netcracker.courses.oe.catalog.controller;

import com.netcracker.courses.oe.catalog.dto.TagDTO;
import com.netcracker.courses.oe.catalog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/catalog/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TagDTO save(@RequestBody TagDTO tagDTO) {
        return tagService.save(tagDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public TagDTO update(@RequestBody TagDTO tagDTO) {
        return tagService.update(tagDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TagDTO> getAll() {
        return tagService.getAllTags();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TagDTO get(@PathVariable("id") Long id) {
        return tagService.getTag(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        tagService.delete(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<TagDTO> saveAll(@RequestBody List<TagDTO> tagsDTO) {
        return tagService.saveAll(tagsDTO);
    }
}
