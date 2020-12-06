package dev.cosmingherghe.pma.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest, Model model) {
        Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorStatus = "ERROR ";
        String errorMessage = "";

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                errorStatus += statusCode;
                errorMessage = "The page you are looking for might have been removed, had its name changed or is temporarily unavailable.";
                model.addAttribute("errorStatus", errorStatus);
                model.addAttribute("errorMessage", errorMessage);
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()){
                errorStatus += statusCode;
                errorMessage = "You do not have permission to access this area. ACCESS FORBIDDEN!";
                model.addAttribute("errorStatus", errorStatus);
                model.addAttribute("errorMessage", errorMessage);
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                errorStatus += statusCode;
                errorMessage = "Internal problem is encountered by a web server. You can try to resolve it by reloading the page, clearing your browser’s cache, deleting your browser’s cookies and restarting the browser!";
                model.addAttribute("errorStatus", errorStatus);
                model.addAttribute("errorMessage", errorMessage);
            }
            else {
                errorStatus += statusCode;
                errorMessage = "Oops! Something went wrong. Send error report to help us improve your experience.";
                model.addAttribute("errorStatus", errorStatus);
                model.addAttribute("errorMessage", errorMessage);
            }
        }
        else {
            model.addAttribute("errorStatus", errorStatus);
            model.addAttribute("errorMessage", errorMessage);
        }

        return "main/errorPage.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}