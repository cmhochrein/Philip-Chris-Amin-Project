package navbar;

import com.paperpath.demo.requests.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chris
 */
@RequestMapping("/navbar")
@Controller
public class NavbarController {

    @Autowired
    RequestService requestService;

    @GetMapping("/photo-bulletin")
    public String getPhotographerBulletin(Model model) {
        model.addAttribute("requestList", requestService.getAllFreeRequests());
        return "photo/bulletin";
    }
}
