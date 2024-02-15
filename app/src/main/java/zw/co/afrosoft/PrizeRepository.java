package zw.co.afrosoft;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrizeRepository {

    private final List<Prize> prizeList= new ArrayList<>();


    public List<Prize> getAllPrizes(){return prizeList;}


    public Prize addPrize(Prize prize){

        //Checking if the prize already exists
        /*The bug here is that even if the prize already exists, it will be
         * added as a different record anyway because the prizeID of
         * the prize being added will always start as 0.*/
        if (prizeList.contains(prize)) {

            prizeList.stream()
                    .filter(p -> p.getPrizeName().equals(prize.getPrizeName()))
                    .findFirst()
                    .ifPresent(p -> p.setPrizeQuantity(prize.getPrizeQuantity() + p.getPrizeQuantity()));
            return prize;
        }

        else{prize.setPrizeID(prizeList.size() + 1);
            prizeList.add(prize);
            return prize;
        }


    }

    public Prize fetchPrizeByName(Integer quantity, String name) {
        for (Prize prize : prizeList) {
            if (name.equals(prize.getPrizeName())) {
                if (prize.getPrizeQuantity() < quantity) {
                    return null;
                } else {
                    prize.setPrizeQuantity(prize.getPrizeQuantity() - quantity);
                    return prize;
                }
            }
        }
        return null;
    }


    public void deletePrizeByName(String name){

        var prize= prizeList.stream()
                        .filter(p-> name.equals(p.getPrizeName()))
                        .findFirst()
                        .orElse(null);

        prizeList.remove(prize);

        //Reassigning IDs
        int i;
        for(i=0;i<prizeList.size();i++)
           {
               prizeList.get(i).setPrizeID(i + 1);
           }

            
    }

}
