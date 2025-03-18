package com.example.demo.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class GameUserInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            //게임유저id가 없을 경우 예외처리
            if(request.getHeader("game-user-id") == null){
                //throw new BaseException(UserErrorCode.USER_NOT_FOUND);
            }

            int gameUserId = Integer.parseInt(request.getHeader("game-user-id"));
            //게임유저 id를 활용해 유저정보를 가져옴
            //GameUser gameUser = gameUserService.findById(gameUserId);
            //
            //User = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


}
