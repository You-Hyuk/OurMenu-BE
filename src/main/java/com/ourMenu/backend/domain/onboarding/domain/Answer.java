package com.ourMenu.backend.domain.onboarding.domain;

import com.ourMenu.backend.domain.onboarding.util.S3Util;
import lombok.Getter;

@Getter
public enum Answer {
    FEELING("좋아!", S3Util.S3Path + "좋아.svg", S3Util.S3Path + "기분이 꿀꿀할때는 돼지 파티다.svg", "별로야..", S3Util.S3Path + "별로야.svg", S3Util.S3Path + "기분이 저기압일 땐 고기 앞으로 가라.svg"),

    WEATHER("맑아", S3Util.S3Path + "맑아.svg", S3Util.S3Path + "날씨도 맑은데 바깥에서 피크닉 어때요_.svg", "비가 오네", S3Util.S3Path + "비가와.svg", S3Util.S3Path + "비오고 쌀쌀할 때 뜨끈한 국물 어때요_.svg"),
    STRESS("달달한 음식을 먹어", S3Util.S3Path + "달달한음식.svg", S3Util.S3Path + "스트레스 해소엔 달달한게 최고지~.svg", "매운 음식이지!", S3Util.S3Path + "매운음식.svg", S3Util.S3Path + "스트레스 해소엔 역시 화끈하게!.svg"),
    TRAVEL("바다", S3Util.S3Path + "바다.svg", S3Util.S3Path + "바다 내음이 물씬나는 해산물 어때요_.svg", "산", S3Util.S3Path + "산.svg", S3Util.S3Path + "피톤치드향 가득한 건강식 어때요_.svg"),
    SEASON("여름", S3Util.S3Path + "여름.svg", S3Util.S3Path + "따가운 햇살엔 이열치열! 뜨거운 음식들.svg", "겨울", S3Util.S3Path + "겨울.svg", S3Util.S3Path + "따가운 햇살을 이겨내는 차가운 음식들 어때요_.svg"),
    ;

    private final String yes;
    private final String yesImg;
    private final String yesAnswerImg;
    private final String no;
    private final String noImg;
    private final String noAnswerImg;

    Answer(String yes, String yesImg, String yesAnswerImg, String no, String noImg, String noAnswerImg) {
        this.yes = yes;
        this.yesImg = yesImg;
        this.yesAnswerImg = yesAnswerImg;
        this.no = no;
        this.noImg = noImg;
        this.noAnswerImg = noAnswerImg;
    }
}
