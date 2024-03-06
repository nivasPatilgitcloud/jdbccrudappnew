package com.jdbc.jdbcapp;

import java.util.Scanner;

import com.jdbc.jdbcapp.crud.CrudOperation;

public class App 
{
	static CrudOperation obj = new CrudOperation();
	static Scanner sc = new Scanner(System.in);
	public static void switchway() {
		
        System.out.println("Enter number to perform operation 1)Insert 2)Display 3)Delete and 4)Update");
        int num = sc.nextInt();
        sc.nextLine();
        
        switch (num) {
		case 1:
			System.out.println("Insert operation\n");
			obj.InsertStudent();
			App.callAgain();
			break;
		case 2:
			System.out.println("Display operation\n");
			obj.showAllStudents();
			App.callAgain();
			break;
		case 3:
			System.out.println("Delete operation\n");
			obj.deleteStudent();
			App.callAgain();
			break;
		case 4:
			System.out.println("Update operation");
			obj.updateStudent();
			App.callAgain();
			break;

		default:
			System.out.println("You opted invalid number");
			break;
		}
	}
	public static void callAgain() {
		System.out.println("Do you want to perform another operation y/n");
		String str = sc.nextLine();
		if(str.equalsIgnoreCase("y")) {
			App.switchway();
		}else {
			System.exit(0);
		}
	}
    public static void main( String[] args )
    {
        
        App.switchway();
        
    }
}
