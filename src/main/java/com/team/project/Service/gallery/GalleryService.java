package com.team.project.Service.gallery;



import com.team.project.Dto.gallery.GalleryDto;
import com.team.project.Dto.gallery.GallerySaveRequestDto;
import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Repository.category.CategoryRepository;
import com.team.project.Repository.gallery.GalleryRepository;
import com.team.project.Repository.user.UserRepository;
import com.team.project.Service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;
    private S3Service s3Service;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;


    public Long save(Long id, GallerySaveRequestDto requestDto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + requestDto.getCategoryId()));
        requestDto.setCategory(category);

        return galleryRepository.save(requestDto.toEntity()).getId();
    }

    public List<GalleryDto> getList(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + categoryId));

        List<GalleryEntity> galleryEntityList = galleryRepository.findAllByCategoryOrderByIdDesc(category);
        List<GalleryDto> galleryDtoList = new ArrayList<> ();

        for(int i = 0; i < galleryEntityList.size(); i++) {
            GalleryDto galleryDto = new GalleryDto();

            GalleryEntity galleryEntity = galleryEntityList.get(i);

            galleryDto.setGalleryEntity(galleryEntity);

            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }


    private GalleryDto convertEntityToDto(GalleryEntity galleryEntity) {
        return GalleryDto.builder()
                .id(galleryEntity.getId())
                .user(galleryEntity.getUser())
                .category(galleryEntity.getCategory())
                .title(galleryEntity.getTitle())
                .filePath(galleryEntity.getFilePath())
                .filePath2(galleryEntity.getFilePath2())
                .filePath3(galleryEntity.getFilePath3())
                .filePath4(galleryEntity.getFilePath4())
                .filePath5(galleryEntity.getFilePath5())
                .imgFullPath ("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME+"/"+ galleryEntity.getFilePath())
                .imgFullPath2("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME+"/"+ galleryEntity.getFilePath2())
                .imgFullPath3("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME+"/"+ galleryEntity.getFilePath3())
                .imgFullPath4("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME+"/"+ galleryEntity.getFilePath4())
                .imgFullPath5("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME+"/"+ galleryEntity.getFilePath5())
                .build();
    }

    @Transactional(readOnly = true)
    public GalleryDto findById(long id){
        GalleryEntity entity = galleryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id= " + id));

        return new GalleryDto(entity);
    }
}
