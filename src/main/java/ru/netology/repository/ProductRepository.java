package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];
    Book book1 = new Book(1, "Book1", 1000, "Authore", 234, 2013);
    Book book2 = new Book(2, "Book2", 2000, "Authore2", 234, 2013);
    Book book3 = new Book(3, "Book3", 1000, "Authore3", 234, 2013);

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

}
