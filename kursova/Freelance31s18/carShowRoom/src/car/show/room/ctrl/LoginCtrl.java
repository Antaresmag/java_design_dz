package car.show.room.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import car.show.room.service.AuthService;
 
@Controller
@RequestMapping("/user")
public class LoginCtrl {
 
    @Autowired
    private AuthService authenticateService;            // This will auto-inject the authentication service into the controller.
 
    private static Logger log = Logger.getLogger(LoginCtrl.class);
 
    // Checks if the user credentials are valid or not.
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validateUsr(@RequestParam("username")String username, @RequestParam("password")String password) {
        System.out.println("------Hello---------");
    	String msg = "";
        boolean isValid = authenticateService.findUser(username, password);
        log.info("Is user valid?= " + isValid);
 
        if(isValid) {
            msg = "Welcome " + username + "!";
        } else {
            msg = "Invalid credentials";
        }
 
        return new ModelAndView("result", "output", msg);
    }
}