package com.ourMenu.backend.domain.user.api;

import com.ourMenu.backend.domain.user.api.request.ChangeNicknameRequest;
import com.ourMenu.backend.domain.user.api.request.ChangePasswordRequest;
import com.ourMenu.backend.domain.user.api.response.UserInfoResponse;
import com.ourMenu.backend.domain.user.application.UserService;
import com.ourMenu.backend.global.argument_resolver.UserId;
import com.ourMenu.backend.global.common.ApiResponse;
import com.ourMenu.backend.global.util.ApiUtils;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.ourMenu.backend.global.util.BindingResultUtils.getErrorMessages;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/password")
    public ApiResponse<Object> changePassword(@UserId Long userId, @Valid @RequestBody ChangePasswordRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ValidationException(getErrorMessages(bindingResult));
        }
        userService.changePassword(userId, request);
        return ApiUtils.success(null);
    }

    @PatchMapping("/nickname")
    public ApiResponse<Object> changeNickname(@UserId Long userId, @Valid @RequestBody ChangeNicknameRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ValidationException(getErrorMessages(bindingResult));
        }
        userService.changeNickname(userId, request);
        return ApiUtils.success(null);
    }

    @GetMapping("")
    public ApiResponse<UserInfoResponse> getUserInfo(@UserId Long userId) {
        return ApiUtils.success(userService.getUserInfo(userId));
    }

}
