package hello.kafka.v3;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StockChange {
    String message;

    LocalDate date;
    String skuCd;
    String fieldName;
    int diff;

    @Builder
    public StockChange(LocalDate date, String skuCd, String fieldName, int diff, String message) {
        this.date = date;
        this.skuCd = skuCd;
        this.fieldName = fieldName;
        this.diff = diff;
        this.message = message;
    }
}