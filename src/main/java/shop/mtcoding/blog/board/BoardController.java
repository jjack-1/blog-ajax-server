package shop.mtcoding.blog.board;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(
            @PathVariable int id,
            HttpServletRequest request,
            HttpServletResponse response) {
        request.setAttribute("boardId", id);
        Cookie cookie = new Cookie("boardId", id + "");
        cookie.setHttpOnly(true); // http프로토콜 전용으로 사용해라 js가 접근 불가, 브라우저의 통신에서만 접근 허용
        response.addCookie(cookie);

        return "board/updateForm";
    }
}
