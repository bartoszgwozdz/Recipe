package dev.gwozdz.DemoRecipe.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(long recipeId, MultipartFile file);
}
