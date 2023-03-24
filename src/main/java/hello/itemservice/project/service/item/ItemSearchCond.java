package hello.itemservice.project.service.item;

import lombok.Data;


/**
 * 검색용 객체
 */
@Data
public class ItemSearchCond {

    private String itemName;
    private Integer MaxPrice;
    private Integer minPrice;

}
