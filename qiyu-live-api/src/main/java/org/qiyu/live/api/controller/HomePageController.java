package org.qiyu.live.api.controller;

import org.qiyu.live.common.interfaces.vo.WebResponseVO;
import org.qiyu.live.web.starter.QiyuRequestContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author idea
 * @Date: Created in 08:56 2023/6/25
 * @Description
 */
@RestController
@RequestMapping("/home")
public class HomePageController {

    @PostMapping("/initPage")
    public WebResponseVO initPage() {
        Long userId = QiyuRequestContext.getUserId();
        new Thread(() -> QiyuRequestContext.getUserId()).start();
        System.out.println(userId);
        //前端调用initPage --> success状态，代表登录过了，token依旧有效
        return WebResponseVO.success();
    }
}
