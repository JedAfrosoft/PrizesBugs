package zw.co.afrosoft;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prizes")
public class PrizeController {

    private final PrizeService service;

    public PrizeController(PrizeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prize> getAllPrizes(){

        return service.getAllPrizes();
    }

    @PostMapping
    public Prize addPrize(@RequestBody Prize prize){

        return service.addPrize(prize);
    }

    @GetMapping(value = "/{name}/{quantity}")
    public Prize fetchPrizeByName(@PathVariable("quantity") Integer quantity, @PathVariable("name") String name){

        return service.fetchPrizeByName(quantity, name);
    }

    @DeleteMapping(value = "/{name}")
    public void deletePrizeByName(@PathVariable("name") String name){

        service.deletePrizeByName(name);
    }
}
