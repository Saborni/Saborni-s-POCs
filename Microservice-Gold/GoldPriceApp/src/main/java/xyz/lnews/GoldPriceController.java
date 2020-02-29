package xyz.lnews;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price/")
public class GoldPriceController {

    @GetMapping("/karat/{karat}/grams/{grams}")
    public String getNetPrice(@PathVariable String karat,@PathVariable int grams){
        GoldRateReader goldRateReader = new GoldRateReader();
        GoldRateDTO goldRateDTO = new GoldRateDTO(0,0);
        try {
            goldRateDTO = goldRateReader.getGoldRateResponse(karat);
        }catch (Exception e){

        }
        return ""+goldRateDTO.getGoldRate()*grams;
    }
}
