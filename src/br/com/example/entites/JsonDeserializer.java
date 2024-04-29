package br.com.example.entites;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JsonDeserializer {

    String result = "";
    String time_last_update_utc = "";
    String base_code = "";
    String target_code = "";
    Double conversion_rate = 0.0;
    Double conversion_result = 0.0;

    public String getTime_last_update_utc() {
        ZonedDateTime agora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);
        return dataHoraFormatada;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(Double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "______________________________________________________ \n" +
                "Conversion Result \n" +
                "Date of conversion = " + time_last_update_utc + '\n' +
                "Money base = " + base_code + '\n' +
                "Money Target = " + target_code + '\n' +
                "Conversion rate = " + conversion_rate + '\n' +
                "Conversion result = " + conversion_result + '\n' +
                "______________________________________________________"
                +'\n';
    }
}
