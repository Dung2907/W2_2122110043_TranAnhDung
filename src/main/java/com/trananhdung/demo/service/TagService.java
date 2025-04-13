package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Tag;

public interface TagService {
    Tag addTag(Tag tag);

    List<Tag> getAllTags();

    void deleteTag(UUID tagId);

    public Tag updateTag(UUID tagId, Tag tag);

    public Tag getTagById(UUID tagId);
}
