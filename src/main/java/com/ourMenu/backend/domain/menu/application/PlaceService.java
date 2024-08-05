package com.ourMenu.backend.domain.menu.application;

import com.ourMenu.backend.domain.menu.dao.PlaceRepository;
import com.ourMenu.backend.domain.menu.domain.Place;
import com.ourMenu.backend.domain.menu.dto.request.StoreRequestDTO;
import com.ourMenu.backend.domain.user.application.UserService;
import com.ourMenu.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final UserService userService;

    @Transactional
    public Place createPlace(StoreRequestDTO storeInfo, Long userId) {

        Place existingPlace = placeRepository.findByUserIdAndTitle(userId, storeInfo.getStoreName()).orElse(null);
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("해당하는 유저가 없습니다"));

        log.info("정말 정말 정말 재밌는 스프링 프로젝트.");
        if (existingPlace != null) {
            log.info("기존의 존재하는 음식점 정보입니다.");
            // 필드값 업데이트 (null이 아닌 경우에만)
            if (storeInfo.getStoreAddress() != null) {
                existingPlace.setAddress(storeInfo.getStoreAddress());
            }
            if (storeInfo.getStoreInfo() != null) {
                existingPlace.setInfo(storeInfo.getStoreInfo());
            }
            if (storeInfo.getStoreLongitude() != null) {
                existingPlace.setLongitude(storeInfo.getStoreLongitude());
            }
            if (storeInfo.getStoreLatitude() != null) {
                existingPlace.setLatitude(storeInfo.getStoreLatitude());
            }
            existingPlace.setModifiedAt(LocalDateTime.now()); // 수정 시간 업데이트

            // 업데이트된 Place 객체 저장
            return placeRepository.save(existingPlace);
        }

        return Place.builder()
                .title(storeInfo.getStoreName())
                .user(user)
                .address(storeInfo.getStoreAddress())
                .info(storeInfo.getStoreInfo())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .longitude(storeInfo.getStoreLongitude())
                .latitude(storeInfo.getStoreLatitude())
                .build();
    }

    public Place save(Place place) {
        return placeRepository.save(place); // Place 객체를 저장하고 반환
    }
}