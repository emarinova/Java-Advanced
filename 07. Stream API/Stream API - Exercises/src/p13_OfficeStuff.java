import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p13_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> companies = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for(int i =0; i < n; i++){
            List<String> input = Arrays.stream(reader.readLine().split("[|\\-\\s]+"))
                    .filter(x -> x.length()!=0).collect(Collectors.toList());
            String companyName = input.get(0);
            Integer amount = Integer.parseInt(input.get(1));
            String product = input.get(2);
            if(!companies.containsKey(companyName)){
                companies.put(companyName, new LinkedHashMap<>());
            }
            if(!companies.get(companyName).containsKey(product)){
                companies.get(companyName).put(product, 0);
            }
            companies.get(companyName).put(product, companies.get(companyName).get(product) + amount);
        }
        companies.entrySet().stream().forEach(company -> {
            System.out.print(company.getKey() + ": ");
            StringBuilder sb = new StringBuilder();
            company.getValue().entrySet().stream().forEach(product ->{
                sb.append(product.getKey()).append("-").append(product.getValue()).append(", ");
            });
            sb.delete(sb.length()-2, sb.length());
            System.out.println(sb);
        });
    }
}
