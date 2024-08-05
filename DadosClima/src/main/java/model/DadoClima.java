package model;

import java.time.LocalDate;
import java.util.Objects;

public record DadoClima(float temperatura, float umidade, float pressao, LocalDate data) {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DadoClima other = (DadoClima) obj;
        return Float.compare(other.temperatura, temperatura) == 0
                && Float.compare(other.umidade, umidade) == 0
                && Float.compare(other.pressao, pressao) == 0
                && Objects.equals(other.data, data);
    }

}
