package itsfine.com.inputdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataDto {
    public int parking_id;
    public String car_number;
    public LocalDateTime date_time;
}
