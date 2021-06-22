package com.team.project.Service.comment;


import com.team.project.Dto.comment.GalleryCommentInfoDto;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Repository.comment.GalleryCommentRepository;
import com.team.project.Repository.gallery.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GalleryCommentService {

    private final GalleryCommentRepository galleryCommentRepository;
    private final GalleryRepository galleryRepository;

    @Transactional
    public List<GalleryCommentInfoDto> getGalleryCommentInfo(Long galleryId) {
        GalleryEntity galleryEntity = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + galleryId));

        List<GalleryComment> galleryCommentList = galleryCommentRepository.findAllByGalleryEntityOrderByIdDesc(galleryEntity);

        List<GalleryCommentInfoDto> galleryCommentInfoDtoList = new ArrayList<>();

        for (int i = 0; i < galleryCommentList.size(); i++) {
            GalleryCommentInfoDto galleryCommentInfoDto = new GalleryCommentInfoDto();

            GalleryComment galleryComment = galleryCommentList.get(i);
            Long gallerycommentUserId = galleryCommentList.get(i).getUser().getId();
            String gallerycommentUserName = galleryCommentList.get(i).getUser().getName();
            int gallerydeleted = galleryCommentList.get(i).getDeleted();

            galleryCommentInfoDto.setGalleryComment(galleryComment);
            galleryCommentInfoDto.setGallerycommentUserId(gallerycommentUserId);
            galleryCommentInfoDto.setGallerycommentUserName(gallerycommentUserName);
            galleryCommentInfoDto.setGallerydeleted(gallerydeleted);

            galleryCommentInfoDtoList.add(galleryCommentInfoDto);
        }

        return galleryCommentInfoDtoList;
    }

    @Transactional
    public Long save(Long id, GalleryCommentSaveRequsetDto requestDto){
        GalleryEntity galleryEntity = galleryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + requestDto.getGalleryId()));
        requestDto.setGalleryEntity(galleryEntity);

        return galleryCommentRepository.save(requestDto.toEntity()).getId();
    }
}
