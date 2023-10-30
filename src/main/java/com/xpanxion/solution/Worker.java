package com.xpanxion.solution;

import java.util.List;
import java.util.stream.Collectors;
import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

public class Worker {
    List<Product> productList = DataAccess.getProducts();

    public void ex1 () 
    {
        System.out.println("Ex1");

        System.out.println(productList.stream().map(product -> new Product(product.getId(), product.getDepartmentId(), DataAccess.getDepartments().get(product.getDepartmentId()-1).getName(), product.getName(), product.getPrice(), product.getSku()))
        .collect(Collectors.toList()));
    }

    public void ex2()
    {
        System.out.println("Ex2");

        System.out.println(productList.stream().map(product -> new Product(product.getId(), product.getDepartmentId(), "N/A", product.getName(), product.getPrice(), product.getSku())).collect(Collectors.toList()));
        
    }

    public void ex3()
    {
        System.out.println("Ex3");
        System.out.println(productList.stream().filter(product -> product.getPrice() >= 10).collect(Collectors.toList()));
    }

    public void ex4()
    {
        System.out.println("Ex4");

        productList = DataAccess.getProducts().stream()
        .map(product -> new Product(product.getId(), product.getDepartmentId(), DataAccess.getDepartments().get(product.getDepartmentId()-1).getName(), product.getName(), product.getPrice(), product.getSku()))
        .collect(Collectors.toList());
        Double sum = productList.stream().filter(Product->Product.getDepartmentName().equals("Food")).mapToDouble(Product::getPrice).sum();
        System.out.println(sum);
    }

    public void ex5()
    {

    }
}

