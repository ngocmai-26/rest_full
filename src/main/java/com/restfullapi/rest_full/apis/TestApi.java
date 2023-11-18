package com.restfullapi.rest_full.apis;

import com.restfullapi.rest_full.containts.Message;
import com.restfullapi.rest_full.ultis.ApiResponseHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/public/test")
public class TestApi {
    private final Logger logger = LoggerFactory.getLogger(TestApi.class);

    @Data
    @AllArgsConstructor
    private static class UserReq {
        private String name;
        private String address;
        private int age;
    }

    @GetMapping("/index")
    public ResponseEntity<?> demo() {
        UserReq userReq = new UserReq("khanhdaica","hai phong",20);
        return ApiResponseHelper.gI().resp(
                userReq,
                HttpStatus.OK,
                Message.DEFAULT_SUCCESS_MESSAGE
        );
    }
}
