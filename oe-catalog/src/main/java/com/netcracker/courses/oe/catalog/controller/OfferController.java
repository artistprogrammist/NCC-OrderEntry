package com.netcracker.courses.oe.catalog.controller;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/catalog/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO saveOffer(@RequestBody OfferDTO offerDTO) {
        return offerService.save(offerDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO updateOffer(@RequestBody OfferDTO offerDTO) {
        return offerService.update(offerDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDTO> getAllOffers() {
        return offerService.getAllOffers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public OfferDTO getOffer(@PathVariable("id") Long id) {
        return offerService.getOffer(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOffer(@PathVariable("id") Long id) {
        offerService.delete(id);
    }

    @RequestMapping(value = "/{id}/category/{name}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO updateOfferByCategory(@PathVariable("id") Long idOffer, @PathVariable("name") String name) {
        return offerService.updateOfferByCategory(idOffer, name);
    }

    @RequestMapping(value = "/{id}/tag/{name}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO updateOfferByTag(@PathVariable("id") Long idOffer, @PathVariable("name") String name) {
        return offerService.updateOfferByTag(idOffer, name);
    }

    @RequestMapping(value = "/{id}/tag/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public OfferDTO deleteOfferByTag(@PathVariable("id") Long idOffer, @PathVariable("name") String name) {
        return offerService.deleteOfferByTag(idOffer, name);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDTO> findOffersByFilter(@RequestParam(value = "tag", required = false) Set<String> tagNames, @RequestParam(value = "priceFrom", required = false) String priceFrom, @RequestParam(value = "priceTo", required = false) String priceTo, @RequestParam(value = "category", required = false) String category) {
        return offerService.findOffersByFilter(tagNames, priceFrom, priceTo, category);
    }
}
