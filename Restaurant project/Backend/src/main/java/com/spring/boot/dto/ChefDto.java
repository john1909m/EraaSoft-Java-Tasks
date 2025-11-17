package com.spring.boot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ChefDto {

    private Long ChefId;

    private String ChefName;

    private String ChefSpec;

    private String logoPath;

    private String facebookLink;

    private String twitterLink;

    private String instagramLink;

}
