package com.team.project.Service.board;


import com.team.project.Dto.board.BoardResponseDto;
import com.team.project.Dto.board.BoardSaveRequestDto;
import com.team.project.Dto.board.BoardUpdateRequestDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import com.team.project.Repository.board.BoardRepository;
import com.team.project.Repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    //게시글 목록 출력
    @Transactional
    public Page<Board> getBoardList(Pageable pageable){
        pageable = PageRequest.of(
            pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
            pageable.getPageSize());
        return boardRepository.findAllDesc(pageable);
    }
    //게시글 등록
    @Transactional
    public Long save(BoardSaveRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }
    //게시글 수정
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    //게시글 삭제
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));
        boardRepository.delete(board);
    }

    @Transactional(readOnly = true)
    public BoardResponseDto findById(long id){
        Board entity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id= " + id));

        return new BoardResponseDto(entity);
    }
    //게시글 검색
    @Transactional
    public List<Board> search(String keyword) {
        List<Board> boardList = boardRepository.findByTitleContaining(keyword);

        return boardList;
    }
    //조회수
    @Transactional
    public int updateView(Long id) {
        return boardRepository.updateView(id);
    }

    @Transactional
    public User findBoardUserById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호d=" + id));

        Long userId = board.getUser().getId();

        User boardUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. 유저 id = " + userId));

        return boardUser;
    }

    @Transactional
    public void admindelete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));
        boardRepository.delete(board);
    }
}
