package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trananhdung.demo.entity.SlideShow;

import java.util.UUID;

@Repository
public interface SlideShowRepository extends JpaRepository<SlideShow, UUID> {
}
