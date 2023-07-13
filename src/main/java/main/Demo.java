package main;

import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class Demo {
	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.insert(new Category("Apple"));
		categoryDAO.insert(new Category("Samsung"));
		categoryDAO.insert(new Category("Xiaomi"));
		List<Category> categories = categoryDAO.getAllCategories();
		for(Category category : categories) {
			System.out.println(category.getId() + "  " + category.getName());
		}
	}
}
