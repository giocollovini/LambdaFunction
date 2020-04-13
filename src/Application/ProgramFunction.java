package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class ProgramFunction {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();		
		List<String> names = new ArrayList<>();	
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		System.out.println();
		System.out.println("===========LAMBDA CONSUMER===============================================");
		System.out.println();
		System.out.println("Fazer um programa que, a partir de uma lista de produtos,"); 
		System.out.println("gere uma nova lista contendo os nomes dos produtos em caixa alta.");
		System.out.println("Product('Tv', 900.00)");
		System.out.println("Product('Mouse', 50.00)");
		System.out.println("Product('Tablet', 350.50)");
		System.out.println("Product('HD Case', 80.90)");
		System.out.println();
		
		for (int i=1; i < 6; i++) { 	
									
			if (i == 1) { 
				System.out.println(); 
				System.out.println("===========Implementação da interface=============================");
								
				names = list.stream().map(new UpperCaseName()).collect(Collectors.toList()) ;
				//map aplica a função a cada elemento da lista
				//map só funciona para stream por isso a conversão list.stream() 
				//names.forEach(System.out::println);
			} else if (i == 2) { 
				System.out.println();
				System.out.println("===========Reference method com método estático==================");
				
				names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()) ;
				
			}  else if (i == 3) {
				System.out.println();
				System.out.println("===========Reference method com método não estático==============");
				
				names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()) ;
				
			} else if (i == 4) {
				System.out.println();
				System.out.println("===========Expressão lambda declarada============================");
			
				Function<Product, String> func = p -> p.getName().toUpperCase();
				
				names = list.stream().map(func).collect(Collectors.toList()) ;
				
			}  else { 
				System.out.println();
				System.out.println("===========Expressão lambda inline===============================");
								
				names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList()) ;
			}		
	
			names.forEach(System.out::println);
		}
				
		
	}
}
