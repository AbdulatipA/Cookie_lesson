package org.example.cookie_lesson;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sessions")
@AllArgsConstructor
public class SessionController {

    @GetMapping("/getSession")
    public String getSession(HttpSession httpSession) {
        String session = httpSession.getAttribute("data").toString();
        if (session == null) {
            return "Пользователь не найден";
        } else {
            return "Первый визит пользователя был в: " + session;
        }
    }


    @GetMapping("/setSession")
    public String setSession(HttpSession httpSession) {
        httpSession.setAttribute("data", LocalDateTime.now().toString());

        return "ok";
    }


    @GetMapping("/deleteSession")
    public String deleteSession(HttpSession httpSession) {
        httpSession.invalidate();
        return "delete done";
    }
}
