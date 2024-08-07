package com.ourMenu.backend.domain.menu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPhotoRequest {
    private List<String> imageUrls;
    private Long menuId;
}
