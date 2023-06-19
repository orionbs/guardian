package fr.orionbs.guardian.adapter.view.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AuthenticationViewAdapter {

    @GetMapping(path = "/authenticate")
    public ModelAndView getAuthenticationView() {
        return new ModelAndView("authenticate-view");
    }


}
