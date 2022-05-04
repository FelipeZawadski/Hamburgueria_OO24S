package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.StockRegister;
import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockRegisterService;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.edu.utfpr.hamburgueria_oo24s.model.enums.StockRegisterType.*;


@RequiredArgsConstructor
public record BuyItemsService (StockRegisterService stockRegisterService, StockService stockService){

    public List<ItemQuantityTO> initItemList(){
        return new ArrayList<>();
    }

    public void processShoppingList(List<ItemQuantityTO> products){
        registerStockMovimentation(products);
        updateStock(products);
    }

    private void registerStockMovimentation(List<ItemQuantityTO> products){
        log.info("Starting registering stock movimentations {}")
        products.stream()
                .map(product -> StockRegister.builder())
                .item(product.getItem())
                .type(ENTRANCE)
                .quantity(product.getQuantity())
                .at(LocalDateTime.now())
                .build()
                .forEach(stockRegister -> stockRegisterService::save);
    }

    private void updateStock(List<ItemQuantityTO> products){
        products.stream().map(products -> stockService.findByItem(products.getItem())
                .updateIncrementQuantity(products.getQuantity())
                .forE
        );
    }
}
