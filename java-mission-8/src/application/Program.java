package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int numOfProducts = sc.nextInt();

        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("Product #" + (i + 1) + ": ");
            System.out.println("Common, used or imported (c/u/i)?");
            char productType = sc.next().charAt(0);

            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Price: ");
            Double price = sc.nextDouble();

            if (productType == 'u') {
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = simpleDateFormat.parse(sc.next());
                list.add(new UsedProduct(name, price, manufactureDate));

            } else if (productType == 'i') {
                System.out.println("Customs fee: ");
                double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));

            } else {
                list.add(new Product(name, price));
            }
        }

        System.out.println("PRICE TAGS: ");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }

        System.out.println();
        sc.close();
    }
}
