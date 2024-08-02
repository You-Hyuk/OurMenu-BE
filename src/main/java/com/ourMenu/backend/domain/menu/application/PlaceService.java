package com.ourMenu.backend.domain.menu.application;

import com.ourMenu.backend.domain.menu.dao.PlaceRepository;
import com.ourMenu.backend.domain.menu.domain.Place;
import com.ourMenu.backend.domain.menu.dto.request.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    /*@Transactional
    public Place createPlace(StoreRequestDTO storeInfo) {
        Place existingPlace = placeRepository.findByUserIdAndTitle(userId, storeInfo.getStoreName()).orElse(null);

        if (existingPlace != null) {
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
                .address(storeInfo.getStoreAddress())
                .info(storeInfo.getStoreInfo())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .longitude(storeInfo.getStoreLongitude())
                .latitude(storeInfo.getStoreLatitude())
                .build();
    }
*/
    public Place save(Place place) {
        return placeRepository.save(place); // Place 객체를 저장하고 반환
    }
}
