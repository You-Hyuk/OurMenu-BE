package com.ourMenu.backend.domain.user.api;

import com.ourMenu.backend.domain.user.api.request.ChangePasswordRequest;
import com.ourMenu.backend.domain.user.application.UserService;
import com.ourMenu.backend.global.argument_resolver.UserId;
import com.ourMenu.backend.global.common.ApiResponse;
import com.ourMenu.backend.global.util.ApiUtils;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
