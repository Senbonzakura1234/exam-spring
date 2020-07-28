package com.app.manager.controller;

import com.app.manager.entity.Product;
import com.app.manager.entity.Sale;
import com.app.manager.service.interfaceClass.ProductService;
import com.app.manager.service.interfaceClass.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ListController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    ProductService productService;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SaleService saleService;

    @GetMapping("/product")
    public String product(Model model,
        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
        @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

        Sort sortable = sort.equals("DESC")?
                Sort.by("name").descending():
                Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page <= 0? 0: page - 1, size, sortable);

        Page<Product> products = productService.getAll(pageable);

        var totalPages = products.getTotalPages();
        var currentPage = pageable.getPageNumber();
        var totalItems = products.getTotalElements();
        var offset = (totalItems - products.getPageable().getOffset());
        var currentPageItems = offset < size? offset : size;

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }


        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("offset", offset);
        model.addAttribute("page", page <= 0? 1: page);
        model.addAttribute("count", currentPageItems);
        model.addAttribute("products", products);
        model.addAttribute("sort", sort);
        model.addAttribute("sortInverse", sort.equals("ASC") ? "DESC" : "ASC");

        return "views/product";
    }

    @GetMapping("/sale")
    public String sale(Model model,
        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
        @RequestParam(name = "size", required = false, defaultValue = "20") Integer size,
        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

        Sort sortable = sort.equals("DESC")?
                Sort.by("saleManName").descending():
                Sort.by("saleManName").ascending();
        Pageable pageable = PageRequest.of(page <= 0? 0: page - 1, size, sortable);

        Page<Sale> sales = saleService.getAll(pageable);

        var totalPages = sales.getTotalPages();
        var currentPage = pageable.getPageNumber();
        var totalItems = sales.getTotalElements();
        var offset = (totalItems - sales.getPageable().getOffset());
        var currentPageItems = offset < size? offset : size;

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }


        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("offset", offset);
        model.addAttribute("page", page <= 0? 1: page);
        model.addAttribute("count", currentPageItems);
        model.addAttribute("sales", sales);
        model.addAttribute("sort", sort);
        model.addAttribute("sortInverse", sort.equals("ASC") ? "DESC" : "ASC");

        return "views/sale";
    }
}
