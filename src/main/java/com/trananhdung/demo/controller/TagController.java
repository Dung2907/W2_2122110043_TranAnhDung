package com.trananhdung.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trananhdung.demo.entity.Tag;
import com.trananhdung.demo.service.TagService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin({"http://localhost:3000", "http://localhost:3001"})

@RequestMapping("api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @PostMapping
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        Tag addedTag = tagService.addTag(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable("id") UUID tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable UUID id, @RequestBody Tag tag) {
        try {
            Tag updatedTag = tagService.updateTag(id, tag);
            return ResponseEntity.ok(updatedTag);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable UUID id) {
        try {
            Tag tag = tagService.getTagById(id);
            return ResponseEntity.ok(tag);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
