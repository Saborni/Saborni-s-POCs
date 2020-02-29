package xyz.lnews;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class GoldRateController {

    @GetMapping("/22")
    public GoldRateDTO returnTwoGoldRateDTO(){
        return new GoldRateDTO(22,5000);
    }

    @GetMapping("/14")
    public GoldRateDTO returnOneGoldRateDTO(){
        return new GoldRateDTO(14,2700);
    }

}
