
package com.team.springboot.controller;

        import com.team.springboot.pojo.BaseResponse;
        import com.team.springboot.pojo.User;
        import com.team.springboot.pojo.UserHead;
        import com.team.springboot.service.UserHeadService;
        import com.team.springboot.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;


        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.UUID;

@Controller
public class UserIndexController {
        @Autowired
        UserService userService;

        @Autowired
        UserHeadService userHeadService;

        //进入userIndex界面，给model加上userhead和user
        @RequestMapping("/userIndex")
        public String login(Model m, @RequestParam("u_Account") String u_Account) {
            User u;
            UserHead userHead;
            u=userService.selectUserById(u_Account);
            userHead=userHeadService.selectHead(u_Account);
            m.addAttribute("userhead",userHead);
            m.addAttribute("user",u);
            return "html/user_index";
        }

        //我的钱包
        @RequestMapping("/userWallet")
        public String login(HttpSession session, Model model) {
                String account = (String) session.getAttribute("u_Account");
                User user = userService.selectUserById(account);
                model.addAttribute(user);
                return "html/wallet";
        }
}