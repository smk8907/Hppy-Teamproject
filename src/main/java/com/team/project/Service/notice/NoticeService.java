package com.team.project.Service.notice;

import com.team.project.Dto.notice.NoticeResponseDto;
import com.team.project.Dto.notice.NoticeSaveRequestDto;
import com.team.project.Dto.notice.NoticeUpdateRequestDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.Board.Notice;
import com.team.project.Entity.User.User;
import com.team.project.Repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Page<Notice> getNoticeList(Pageable pageable){
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
                pageable.getPageSize());
        return noticeRepository.findAllDesc(pageable);
    }

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto){
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoticeUpdateRequestDto requestDto){
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));

        notice.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));
        noticeRepository.delete(notice);
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findById(long id){
        Notice entity = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id= " + id));

        return new NoticeResponseDto(entity);
    }
}
