package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Tag;
import com.trananhdung.demo.repository.TagRepository;
import com.trananhdung.demo.service.TagService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(UUID tagId, Tag tag) {
        Optional<Tag> existingTag = tagRepository.findById(tagId);
        if (existingTag.isPresent()) {
            Tag updatedTag = existingTag.get();
            updatedTag.setName(tag.getName());
            return tagRepository.save(updatedTag);
        } else {
            throw new RuntimeException("Tag not found with id " + tagId);
        }
    }

    @Override
    public void deleteTag(UUID tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Tag getTagById(UUID tagId) {
        Optional<Tag> tag = tagRepository.findById(tagId);
        if (tag.isPresent()) {
            return tag.get();
        } else {
            throw new RuntimeException("Tag not found with id " + tagId);
        }
    }
}
