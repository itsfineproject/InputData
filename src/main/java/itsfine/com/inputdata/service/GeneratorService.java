package itsfine.com.inputdata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import itsfine.com.inputdata.dto.DataDto;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Poller;

import java.time.LocalDateTime;
import java.util.Random;

@EnableBinding(Source.class)
public class GeneratorService {

    private Random random = new Random();
    ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @InboundChannelAdapter(value=Source.OUTPUT,poller=@Poller
            (fixedDelay="${fixedDelay:30000}" ,maxMessagesPerPoll="${nMessages:1}"))
    public String randomData() throws JsonProcessingException {
        int randArrayLength = getRandomInt(19,51);
        DataDto[] dataArr = new DataDto[randArrayLength];

        for (int i = 0; i < randArrayLength; i++)
            dataArr[i] = getRandomData();

        return mapper.writeValueAsString(dataArr);
    }

    public DataDto getRandomData() {
        return new DataDto(this.getRandomInt(0,9), this.getRandomCarNumber(), this.getDateTime());
    }

    public String getRandomCarNumber() {
        double chance = random.nextDouble();
        String number = "";
        if (chance <= 0.1) {
            number = getRandomNumberPart(1) + '-' + getRandomNumberPart(2) + '-' + getRandomNumberPart(3);
        } else if (chance > 0.1 && chance <= 0.5) {
            number = getRandomNumberPart(2) + '-' + getRandomNumberPart(3) + '-' + getRandomNumberPart(2);
        } else if (chance > 0.5 && chance <= 1.0) {
            number = getRandomNumberPart(3) + '-' + getRandomNumberPart(2) + '-' + getRandomNumberPart(3);
        }
        System.out.println(number);
        return number;
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    public int getRandomInt(int min, int max) {
        return min + random.nextInt(max - min);
    }

    public String getRandomNumberPart(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char digit1 = (char)(random.nextInt(10) + '0');
            s.append(digit1);
        }
        return s.toString();
    }

}
