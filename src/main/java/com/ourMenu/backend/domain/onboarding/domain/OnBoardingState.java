package com.ourMenu.backend.domain.onboarding.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OnBoardingState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int questionId;
    private AnswerType answerType;

    public static OnBoardingState toEntity(Long userId, int questionId, AnswerType answerType) {
        return OnBoardingState.builder()
                .userId(userId)
                .questionId(questionId)
                .answerType(answerType)
                .build();
    }

    public void update(int questionId, AnswerType answerType) {
        this.questionId = questionId;
        this.answerType = answerType;
    }
}
