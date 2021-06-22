package com.team.project.Service.QnA;


import com.team.project.Dto.QnA.QnAInfoDto;
import com.team.project.Dto.QnA.QnASaveRequestDto;
import com.team.project.Dto.comment.GalleryCommentInfoDto;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.QnA.QnA;
import com.team.project.Repository.QnARepository.QnARepository;
import com.team.project.Repository.gallery.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QnAService {

    private final QnARepository qnARepository;
    private final GalleryRepository galleryRepository;

    @Transactional
    public List<QnAInfoDto> getQnAInfo(Long galleryId) {
        GalleryEntity galleryEntity = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + galleryId));

        List<QnA> qnAList = qnARepository.findAllByGalleryEntityOrderByIdDesc(galleryEntity);

        List<QnAInfoDto> qnAInfoDtoList = new ArrayList<>();

        for (int i = 0; i < qnAList.size(); i++) {
            QnAInfoDto qnAInfoDto = new QnAInfoDto();

            QnA qnA = qnAList.get(i);
            Long qnaUserId = qnAList.get(i).getUser().getId();
            String qnaUserName = qnAList.get(i).getUser().getName();

            qnAInfoDto.setQnA(qnA);
            qnAInfoDto.setQnaUserId(qnaUserId);
            qnAInfoDto.setQnaUserName(qnaUserName);

            qnAInfoDtoList.add(qnAInfoDto);
        }

        return qnAInfoDtoList;
    }

    @Transactional
    public Long save(Long id, QnASaveRequestDto requestDto){
        GalleryEntity galleryEntity = galleryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + requestDto.getGalleryId()));
        requestDto.setGalleryEntity(galleryEntity);

        return qnARepository.save(requestDto.toEntity()).getId();
    }
}
