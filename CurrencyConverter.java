package codsoft.tasks;

import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample exchange rates (base: INR)
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);  // 1 INR = 0.012 USD
        rates.put("EUR", 0.011);  // 1 INR = 0.011 EURI
        rates.put("GBP", 0.0095); // 1 INR = 0.0095 GBP
        rates.put("JPY", 1.79);   // 1 INR = 1.79 JPY

        System.out.println("Supported Currencies: INR, USD, EUR, GBP, JPY");
        System.out.print("Enter base currency: ");
        String base = scanner.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String target = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("❌ Unsupported currency.");
        } else {
            double inrAmount = amount / rates.get(base);  // Convert to INR
            double converted = inrAmount * rates.get(target); // INR → target
            System.out.printf("💱 Converted amount: %.2f %s\n", converted, target);
        }

        scanner.close();
    }
}
