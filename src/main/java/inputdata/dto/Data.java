package inputdata.dto;

import lombok.*;
import java.time.LocalDateTime;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    public String carNumber;
    public int parkingId;
    public LocalDateTime dateTime;
}
