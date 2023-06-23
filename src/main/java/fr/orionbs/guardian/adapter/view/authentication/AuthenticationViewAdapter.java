package fr.orionbs.guardian.adapter.view.authentication;

import fr.orionbs.guardian.adapter.view.authentication.data.AuthenticateViewRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthenticationViewAdapter {

    @GetMapping(path = "/authenticate")
    public ModelAndView getAuthenticateView() {
        return new ModelAndView("authenticate-view");
    }

    @PostMapping(path = "/authenticate")
    public ModelAndView postAuthenticateView(@Valid AuthenticateViewRequest authenticateViewRequest, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authenticate-view");
            modelAndView.addObject("errors", bindingResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList()));
            return modelAndView;
        } else {
            log.debug(authenticateViewRequest.toString());
            modelAndView.setViewName("authenticate-view");
            return modelAndView;
        }

    }

}
