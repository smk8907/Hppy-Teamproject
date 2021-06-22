package com.team.project.Config.Auth.dto;

import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class OAuthAttributes {

        private Map<String, Object> attributes;
        private String nameAttributeKey;
        private String name;
        private String nickname;
        private String email;
        private String picture;
        private List<Board> boardList;

        @Builder
        public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String nickname, String email, String picture, List<Board> boardList) {
            this.attributes = attributes;
            this.nameAttributeKey = nameAttributeKey;
            this.name = name;
            this.nickname = email;
            this.email = email;
            this.picture = picture;
            this.boardList = boardList;
        }

        public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
            if("naver".equals (registrationId)){
                return ofNaver("id", attributes);
            }
            if("kakao".equals(registrationId)){
                return ofKakao("id", attributes);
            }
            return ofGoogle(userNameAttributeName, attributes);
        }
    //카카오
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String,Object> response = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
        return OAuthAttributes.builder()
                .name((String)profile.get("nickname"))
                .email((String)response.get("email"))
                .picture((String)profile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    //네이버 추가
    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

        private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
            return OAuthAttributes.builder()
                    .name((String) attributes.get("name"))
                    .nickname((String) attributes.get("nickname"))
                    .email((String) attributes.get("email"))
                    .picture((String) attributes.get("picture"))
                    .attributes(attributes)
                    .nameAttributeKey(userNameAttributeName)
                    .build();
        }

        public User toEntity(){
            return User.builder()
                    .name(name)
                    .nickname(nickname)
                    .email(email)
                    .role(Role.USER)
                    .build();
        }
    }