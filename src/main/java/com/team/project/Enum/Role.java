package com.team.project.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum Role {

    USER("ROLE_USER", "회원"),
    ADMIN("ROLE_ADMIN", "어드민"),
    MASTER("ROLE_MASTER", "마스터");


    private final String key;
    private final String title;

    }
