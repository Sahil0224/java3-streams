package com.xpanxion.solution;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.PersonCat;
import com.xpanxion.java.assignments.model.Product;

public class Worker {
    List<Product> productList = DataAccess.getProducts();
    List<Person> personList = DataAccess.getPeople();
    List<Cat> catList = DataAccess.getCats();

    public void ex1 () 
    {
        System.out.println("Ex1");
        System.out.println(" ");
        System.out.println(productList.stream().map(product -> new Product(product.getId(), product.getDepartmentId(), DataAccess.getDepartments().get(product.getDepartmentId()-1).getName(), product.getName(), product.getPrice(), product.getSku()))
        .collect(Collectors.toList()));
    }

    public void ex2()
    {
        System.out.println(" ");

        System.out.println("Ex2");
        System.out.println(" ");

        System.out.println(productList.stream().map(product -> new Product(product.getId(), product.getDepartmentId(), "N/A", product.getName(), product.getPrice(), product.getSku())).collect(Collectors.toList()));
        
    }

    public void ex3()
    {
        System.out.println(" ");

        System.out.println("Ex3");
        System.out.println(" ");
        System.out.println(productList.stream().filter(product -> product.getPrice() >= 10).collect(Collectors.toList()));
    }

    public void ex4()
    {
        System.out.println(" ");
        System.out.println("Ex4");
        System.out.println(" ");
        productList = DataAccess.getProducts().stream()
        .map(product -> new Product(product.getId(), product.getDepartmentId(), DataAccess.getDepartments().get(product.getDepartmentId()-1).getName(), product.getName(), product.getPrice(), product.getSku()))
        .collect(Collectors.toList());
        Double sum = productList.stream().filter(Product->Product.getDepartmentName().equals("Food")).mapToDouble(Product::getPrice).sum();
        System.out.println(sum);
    }

    public void ex5()
    {
        System.out.println(" ");
        System.out.println("Ex5");
        System.out.println(" ");
        System.out.println(personList.stream().filter(person -> person.getId() <= 3).map(person -> new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getAge(), person.getSsn().substring(7))).collect(Collectors.toList()));
    }

    public void ex6()
    {
        System.out.println(" ");
        System.out.println("Ex6");
        System.out.println(" ");
        System.out.println(catList.stream().sorted(Comparator.comparing(Cat::getName)).collect(Collectors.toList()));
    }


    public void ex7()
    {
        System.out.println(" ");
        System.out.println("Ex7");
        System.out.println(" ");
        String words[] = DataAccess.getWords().split(" ");

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            Integer w = map.get(word);
            if(w != null)
            {
                map.put(word, w + 1);
            }
            else
            {
                map.put(word, 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
        System.out.println(entry.getKey() + " = " + entry.getValue());
    }


    public void ex8()
    {
        System.out.println(" ");
        System.out.println("Ex8");
        System.out.println(" ");

        System.out.println(personList.stream().map(person -> new Person(person.getId(), person.getFirstName(), null, 0, null)).collect(Collectors.toList()));
    }


    public void ex9()
    {
        System.out.println(" ");
        System.out.println("Ex9");
        System.out.println(" ");
        productList = productList.stream().filter(product -> product.getDepartmentName().equals("Electronics")).map(product -> new Product(product.getId(), product.getDepartmentId(), product.getDepartmentName(), product.getName(), product.getPrice() + 2, product.getSku())).collect(Collectors.toList());
        
        Double sum = productList.stream().filter(Product -> Product.getDepartmentName().equals("Electronics")).mapToDouble(Product::getPrice).sum();
        System.out.println("$" + sum);
    }

    public void ex10()
    {
        System.out.println(" ");
        System.out.println("Ex10");
        System.out.println(" ");
        DataAccess.getPeople().stream().map(person -> new PersonCat(person.getId(), person.getFirstName(), catList.stream().filter(cat -> person.getId() == cat.getId()).collect(Collectors.toList()))).forEach(System.out::print);
    }
}

