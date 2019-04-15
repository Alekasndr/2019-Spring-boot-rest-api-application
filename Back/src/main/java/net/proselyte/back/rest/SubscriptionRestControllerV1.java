package net.proselyte.back.rest;

import net.proselyte.back.model.Subscription;
import net.proselyte.back.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path="/sub/")
public class SubscriptionRestControllerV1 {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Subscription> getSubscription(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Subscription subscription = this.subscriptionService.getSubscriptionById(id);

        if (subscription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Subscription> add(@RequestBody Subscription subscription) {
        HttpHeaders headers = new HttpHeaders();

        if (subscription == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.subscriptionService.addSubscription(subscription);
        return new ResponseEntity<>(subscription, headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/new/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Subscription> updateSubscription(@RequestBody @Valid Subscription subscription, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (subscription == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.subscriptionService.addSubscription(subscription);

        return new ResponseEntity<>(subscription, headers, HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Subscription> delete(@PathVariable("id") Long id) {
        Subscription subscription = this.subscriptionService.getSubscriptionById(id);

        if (subscription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.subscriptionService.removeSubscription(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllSubscription() {
        List<Subscription> subscriptions = this.subscriptionService.listSubscription();

        if (subscriptions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(subscriptions);
    }
}
