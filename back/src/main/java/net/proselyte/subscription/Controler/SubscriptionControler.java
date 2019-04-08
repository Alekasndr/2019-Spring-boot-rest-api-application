package net.proselyte.subscription.Controler;


import net.proselyte.subscription.model.Subscription;
import net.proselyte.subscription.services.SubscriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubscriptionControler {

    private SubscriptionServices subscriptionServices;

    @Autowired(required = true)
    @Qualifier(value = "servisService")
    public void setSubscriptionServices(SubscriptionServices subscriptionServices) {
        this.subscriptionServices = subscriptionServices;
    }


    @RequestMapping(value = "subscription", method = RequestMethod.GET)
    public String listSubscripption(Model model) {
        model.addAttribute("subscription", new Subscription());
        model.addAttribute("listSubscription", this.subscriptionServices.listSubscription());
        return "subscription";
    }

    @RequestMapping(value = "subscription/add", method = RequestMethod.POST)
    public String addSubscription(@ModelAttribute("subscription") Subscription subscription) {
        if (subscription.getId() == 0) {
            this.subscriptionServices.addSubscription(subscription);
        } else {
            return "redirect:/subscription";
        }
        return "redirect:/subscription";
    }

    @RequestMapping("/remove/id")
    public String removeSubscription(@PathVariable("id") int id) {
        this.subscriptionServices.removeSubscription(id);
        return "redirect:/subscription";
    }

}
