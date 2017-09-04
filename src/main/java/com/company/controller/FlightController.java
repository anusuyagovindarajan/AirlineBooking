package com.company.controller;

import com.company.service.LocationProviderService;
import com.company.vo.LocationVO;
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

    @Autowired
    private LocationProviderService locationProviderService;


    @RequestMapping("/")
    public String welcomeMessage(@Valid @ModelAttribute(value="flightSearchVO")FlightSearchVO flightSearchVO, Model model) {

        model.addAttribute("flightSearchVO",flightSearchVO);

        List<LocationVO> searchOptions = locationProviderService.getLocations();
        model.addAttribute("searchOptions",searchOptions);

        return "flightSearch";
    }

    @RequestMapping(value = "/getFlight", method = RequestMethod.POST)
    public String getFlights(@Valid @ModelAttribute(value="flightSearchVO")FlightSearchVO flightSearchVO, BindingResult bindingResult, Model model){

        System.out.println(flightSearchVO.getSource());
        System.out.println(flightSearchVO.getStartDate());
        List<LocationVO> searchOptions = locationProviderService.getLocations();
        model.addAttribute("searchOptions",searchOptions);

        model.addAttribute("flightSearchVO", flightSearchService.searchFlight(
                flightSearchVO.getSource(),
                flightSearchVO.getDestination(),
                flightSearchVO.getCapacity(),
                flightSearchVO.getStartDate()));
        return "flightSearch";
    }


}