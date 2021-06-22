package com.team.project.Service.user;


import com.team.project.Dto.user.UserNicknameDto;
import com.team.project.Dto.user.UserResponseDto;
import com.team.project.Dto.user.UserRoleUpDateDto;
import com.team.project.Dto.user.UserUpdateRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Page<User> getUserList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 존재하지 않습니다 id=" + id));
    }

    @Transactional
    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));
        userRepository.delete(user);
    }

    @Transactional
    public Long roleUpdate(Long id, UserRoleUpDateDto requestDto){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id가 존재하지 않습니다 id=" + id));
        user.roleUpdate(requestDto.getRole());
        return id;
    }

    @Transactional
    public Long Mypageupdate(Long id, UserNicknameDto requestDto){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id= " + id));

        user.mypageUpdate(requestDto.getNickname());

        return id;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해상 사용자 없음" + id));

        return new UserResponseDto(entity);
    }

    @Transactional
    public Long savePostnickname(UserUpdateRequestDto userUpdateRequestDto) {
        return userRepository.save(userUpdateRequestDto.toEntity()).getId();
    }

}