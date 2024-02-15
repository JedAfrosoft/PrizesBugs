package zw.co.afrosoft;

import java.util.List;

public interface PrizeInterface {

    List<Prize> getAllPrizes();

    Prize addPrize(Prize prize);

    Prize fetchPrizeByName(Integer quantity, String name);

    void deletePrizeByName(String name);
}
