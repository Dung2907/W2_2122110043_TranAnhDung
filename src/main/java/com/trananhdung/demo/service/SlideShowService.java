package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.SlideShow;

public interface SlideShowService {
    SlideShow addSlideShow(SlideShow slideShow);

    SlideShow getSlideShowById(UUID slideShowId);

    List<SlideShow> getAllSlideShows();

    SlideShow updateSlideShow(UUID slideShowId, SlideShow updatedSlideShow);

    void deleteSlideShow(UUID slideShowId);
}
