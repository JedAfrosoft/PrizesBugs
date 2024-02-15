package zw.co.afrosoft;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeService implements PrizeInterface{

    private final PrizeRepository repository;

    public PrizeService(PrizeRepository repository) {
        this.repository = repository;
    }

    public List<Prize> getAllPrizes(){return repository.getAllPrizes();}

    @Override
    public Prize addPrize(Prize prize){return repository.addPrize(prize);}

    @Override
    public Prize fetchPrizeByName(Integer quantity, String name){return repository.fetchPrizeByName(quantity, name);}


    @Override
    public void deletePrizeByName(String name){repository.deletePrizeByName(name);}



}
