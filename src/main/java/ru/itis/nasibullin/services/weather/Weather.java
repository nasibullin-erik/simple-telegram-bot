package ru.itis.nasibullin.services.weather;

public class Weather {
    private String city;
    private String state;
    private String description;
    private double temperature;
    private double feelsLike;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private int visibility;

    private Weather(){}

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public int getVisibility() {
        return visibility;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Weather weather;

        private Builder() {
            weather = new Weather();
        }

        public Builder city(String city) {
            weather.city = city;
            return this;
        }

        public Builder feelsLike(double feelsLike) {
            weather.feelsLike = feelsLike;
            return this;
        }

        public Builder humidity(double humidity) {
            weather.humidity = humidity;
            return this;
        }

        public Builder pressure(double pressure) {
            weather.pressure = pressure;
            return this;
        }

        public Builder temperature(Double temperature) {
            weather.temperature = temperature;
            return this;
        }

        public Builder windSpeed(Double windSpeed) {
            weather.windSpeed = windSpeed;
            return this;
        }

        public Builder state(String state) {
            weather.state = state;
            return this;
        }

        public Builder description(String description) {
            weather.description = description;
            return this;
        }

        public Builder visibility(int visibility) {
            weather.visibility = visibility;
            return this;
        }

        public Weather build() {
            return weather;
        }
    }
}
