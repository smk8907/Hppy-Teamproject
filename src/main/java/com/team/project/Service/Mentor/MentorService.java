package com.team.project.Service.Mentor;

import com.team.project.Dto.Mentor.MentorResponseDto;
import com.team.project.Dto.Mentor.MentorSaveRequestDto;
import com.team.project.Dto.Mentor.MentorUpdateRequestDto;
import com.team.project.Entity.Board.Mentor;
import com.team.project.Entity.User.User;
import com.team.project.Repository.Mentor.MentorRespository;
import com.team.project.Repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MentorService {

    private final MentorRespository mentorRespository;
    private final UserRepository userRepository;

    @Transactional
    public Page<Mentor> getMentorList(Pageable pageable){
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
                pageable.getPageSize());
        return mentorRespository.findAllDesc(pageable);

    }

    @Transactional
    public Long save(MentorSaveRequestDto requestDto){
        return mentorRespository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MentorUpdateRequestDto requestDto){
        Mentor mentor = mentorRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));

        mentor.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getHtype(), requestDto.getCareer());

        return id;
    }
    //게시글 삭제
    @Transactional
    public void delete(Long id){
        Mentor mentor = mentorRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));
        mentorRespository.delete(mentor);
    }

    @Transactional(readOnly = true)
    public MentorResponseDto findById(long id){
        Mentor entity = mentorRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id= " + id));

        return new MentorResponseDto(entity);
    }

    @Transactional
    public User findBoardUserById(Long id) {
        Mentor mentor = mentorRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호d=" + id));

        Long userId = mentor.getUser().getId();

        User mentorUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. 유저 id = " + userId));

        return mentorUser;
    }

}
