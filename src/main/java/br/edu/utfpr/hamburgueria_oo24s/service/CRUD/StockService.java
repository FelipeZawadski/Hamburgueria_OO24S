package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import br.edu.utfpr.hamburgueria_oo24s.model.StockRegister;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public record StockService (StockRepository repository){

    public Stock findByItem(Item item){
        log.info("Finding stock by item {}", item.getDescription());
        return repository.findFirstByItem(item);
    }

    public Stock save(Stock stock){
        log.info("Saving stock movimentation from item {}", stock.getItem().getDescription());

        return repository.save(stock);
    }
}
