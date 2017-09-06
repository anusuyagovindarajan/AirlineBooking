package com.company.controller;

import com.company.vo.Location;
import com.company.vo.TravelClassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.company.service.FlightSearchService;
import com.company.vo.FlightSearchVO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */

@Controller
public class FlightController
{

    @Autowired
    private FlightSearchService flightSearchService;

    @RequestMapping("/")
    public String welcomeMessage(@Valid @ModelAttribute(value="flightSearchVO")FlightSearchVO flightSearchVO, Model model) {

        model.addAttribute("flightSearchVO",flightSearchVO);

        TravelClassType travelClasses[] = TravelClassType.values();
        model.addAttribute("travelClasses",travelClasses);

        Location searchOptions[] = Location.values();
        model.addAttribute("searchOptions",searchOptions);

        return "flightSearch";
    }

    @RequestMapping(value = "/getFlight", method = RequestMethod.POST)
    public String getFlights(@Valid @ModelAttribute(value="flightSearchVO")FlightSearchVO flightSearchVO, BindingResult bindingResult, Model model){

        Location searchOptions[] = Location.values();
        model.addAttribute("searchOptions",searchOptions);

        TravelClassType travelClasses[] = TravelClassType.values();
        model.addAttribute("travelClasses",travelClasses);

        model.addAttribute("flightSearchVO", flightSearchService.searchFlight( flightSearchVO));

        return "flightSearch";
    }


}
