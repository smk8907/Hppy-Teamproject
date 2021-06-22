package com.team.project.Service.appl;


import com.team.project.Dto.appl.ApplInfoDto;
import com.team.project.Dto.appl.ApplSaveRequsetDto;
import com.team.project.Dto.comment.GalleryCommentInfoDto;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.appliclass.Appl;
import com.team.project.Repository.appl.ApplRepository;
import com.team.project.Repository.gallery.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplService {

    private final ApplRepository applRepository;
    private final GalleryRepository galleryRepository;

    @Transactional
    public List<ApplInfoDto> getApplInfo(Long galleryId) {
        GalleryEntity galleryEntity = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + galleryId));

        List<Appl> applList = applRepository.findAllByGalleryEntityOrderByIdAsc(galleryEntity);

        List<ApplInfoDto> applInfoDtoList = new ArrayList<>();

        for (int i = 0; i < applList.size(); i++) {
            ApplInfoDto applInfoDto = new ApplInfoDto();

            Appl appl = applList.get(i);
            Long applcommentUserId = applList.get(i).getUser().getId();
            String applcommentUserName = applList.get(i).getUser().getName();
            int appldeleted = applList.get(i).getDeleted();

            applInfoDto.setAppl(appl);
            applInfoDto.setApplcommentUserId(applcommentUserId);
            applInfoDto.setApplcommentUserName(applcommentUserName);
            applInfoDto.setAppldeleted(appldeleted);

            applInfoDtoList.add(applInfoDto);
        }

        return applInfoDtoList;
    }

    @Transactional
    public Long save(Long id, ApplSaveRequsetDto requestDto){
        GalleryEntity galleryEntity = galleryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + requestDto.getGalleryId()));
        requestDto.setGalleryEntity(galleryEntity);

        return applRepository.save(requestDto.toEntity()).getId();
    }
}
