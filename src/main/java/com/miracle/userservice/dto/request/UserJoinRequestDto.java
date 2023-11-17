package com.miracle.userservice.dto.request;

import com.miracle.userservice.dto.request.validation.Birth;
import com.miracle.userservice.dto.util.ValidationDefaultMsgUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UserJoinRequestDto {

    @Schema(
            description = "유저 이메일. 이메일 형식을 지켜야함",
            required = true,
            example = "youremail@naver.com"
    )
    @Email(message = ValidationDefaultMsgUtil.EMAIL)
    @NotBlank(message = ValidationDefaultMsgUtil.EMAIL)
    private final String email;

    @Schema(
            description = "유저 이름. 한글만 가능하고 2글자 이상이어야함",
            required = true,
            example = "오스틴"
    )
    @Pattern(regexp = "^[가-힣]{2,}$", message = ValidationDefaultMsgUtil.NAME)
    @NotBlank(message = ValidationDefaultMsgUtil.NAME)
    private final String name;

    @Schema(
            description = "유저 비밀번호. 최소 6글자이며 특수문자가 최소 1개 포함되어야함",
            required = true,
            example = "ostin123!"
    )
    @Pattern(regexp = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{6,}$", message = ValidationDefaultMsgUtil.PASSWORD)
    @NotBlank(message = ValidationDefaultMsgUtil.PASSWORD)
    private final String password;

    @Schema(
            description = "유저 전화번호. 특수문자 없이 11개의 숫자로만 이루어져야함. 맨 앞은 010으로 시작해야함",
            required = true,
            example = "01012345678"
    )
    @Pattern(regexp = "^010(\\d{8})$", message = ValidationDefaultMsgUtil.PHONE)
    @NotBlank(message = ValidationDefaultMsgUtil.PHONE)
    private final String phone;

    @Schema(
            description = "유저 생년월일. 'yyyy-MM-dd' 형식으로 요청해야함. 1900년 이후, 현재 날짜 이전 날짜만 가능",
            required = true,
            example = "2017-01-01"
    )
    @Birth(message = ValidationDefaultMsgUtil.BIRTH)
    private final LocalDate birth;

    @Schema(
            description = "유저 주소",
            required = true,
            example = "서울특별시 서초구 효령로 113"
    )
    @NotBlank(message = ValidationDefaultMsgUtil.ADDRESS)
    private final String address;

    public UserJoinRequestDto() {
        this.email = null;
        this.name = null;
        this.password = null;
        this.phone = null;
        this.birth = null;
        this.address = null;
    }

    @Builder
    public UserJoinRequestDto(String email, String name, String password, String phone, LocalDate birth, String address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
    }
}
