import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p10_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> countries = new HashMap<>();
        Map<String, Long> countriesWithPopulation = new HashMap<>();
        String input = reader.readLine();
        while(!"report".equals(input)){
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String town = tokens[0];
            Long population = Long.parseLong(tokens[2]);
            if (!countries.containsKey(country)){
                countries.put(country, new HashMap<>());
                countriesWithPopulation.put(country, 0L);
            }
            if (!countries.get(country).containsKey(town)){
                countries.get(country).put(town, 0L);
            }
            countries.get(country).put(town, countries.get(country).get(town) + population);
            countriesWithPopulation.put(country, countriesWithPopulation.get(country) + population);
            input = reader.readLine();
        }

        Map<String, Map<String, Long>> sortedCountries =
                countries.entrySet()
                        .stream()
                        .sorted((country1, country2) -> {
                            long populationCountry1 =
                                    country1.getValue()
                                            .values()
                                            .stream()
                                            .mapToLong(Long::valueOf)
                                            .sum();
                            long populationCountry2 =
                                    country2.getValue()
                                            .values()
                                            .stream()
                                            .mapToLong(Long::valueOf)
                                            .sum();
                            int comparator = Long.compare(populationCountry2, populationCountry1);
                            return comparator;
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> country : sortedCountries.entrySet()) {
            String citiesResult = "";
            long totalPopulation = 0;
            Map<String, Long> cities = country.getValue();
            Map<String, Long> sortedCities = cities.entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                citiesResult += "=>" + city.getKey() + ": " + city.getValue() + "\n";
                totalPopulation += city.getValue();
            }
            System.out.printf("%s (total population: %d)\n", country.getKey(), totalPopulation);
            System.out.print(citiesResult);
        }

    }
}
