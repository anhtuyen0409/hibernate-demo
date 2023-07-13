package main;

import java.util.List;
import java.util.Scanner;

import dao.CategoryDAO;
import model.Category;

public class Demo {
	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAO();
		Scanner scanner = new Scanner(System.in);
		
		//get category by id
		System.out.println("Input id: ");
		int id = scanner.nextInt();
		System.out.println("Result:");
		getCategoryById(id, categoryDAO);
		
		//update
		System.out.println("Input id: ");
		int idUpdate = scanner.nextInt();
		System.out.println("Result:");
		update(idUpdate, categoryDAO);
		showData(categoryDAO);
	}
	
	private static void insert(CategoryDAO categoryDAO) {
		categoryDAO.insert(new Category("Apple"));
		categoryDAO.insert(new Category("Samsung"));
		categoryDAO.insert(new Category("Xiaomi"));
	}
	
	private static void showData(CategoryDAO categoryDAO) {
		List<Category> categories = categoryDAO.getAllCategories();
		for(Category category : categories) {
			System.out.println(category.getId() + "  " + category.getName());
		}
	}
	
	private static void getCategoryById(int id, CategoryDAO categoryDAO) {
		Category category = categoryDAO.findById(id);
		System.out.println(category.getId() + "  " + category.getName());
	}
	
	private static void update(int id, CategoryDAO categoryDAO) {
		Category category = categoryDAO.findById(id);
		category.setName("Oppo");
		categoryDAO.update(category);
	}
}
