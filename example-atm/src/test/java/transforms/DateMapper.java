package transforms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cucumber.api.Transformer;

public class DateMapper extends Transformer<LocalDate>{

    @Override
    public LocalDate transform(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");

        return LocalDate.parse(date, formatter); 
   }

}
