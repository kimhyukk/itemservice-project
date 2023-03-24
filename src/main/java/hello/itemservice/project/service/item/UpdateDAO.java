package hello.itemservice.project.service.item;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 업데이트 데이터 전달용 객체
 */
@Data
public class UpdateDAO {

    @NotBlank
    private String itemName;
    @NotNull
    private Integer price;
    @NotNull
    private Integer quantity;
}
