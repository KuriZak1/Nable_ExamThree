/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nable_exam3;

import java.util.Scanner;

/**
 *
 * @author Jake Marson Nable
 */
public class Nable_Exam3 {
    
    static Scanner scan = new Scanner(System.in);
    static Nable_Exam3 List = new Nable_Exam3();
    
    public static void main(String[] args) throws Exception {
        int PrintCount = 0;
        while (true) {            
            System.out.println("1. Insertion");
            System.out.println("2. Display");
            System.out.println("3. EXIT");
            int choice = scan.nextInt();
            int pages, priority;
            
            
            switch (choice) {
                case 1:
                    if (PrintCount > 5){
                        List.deletion();
                    }
                    System.out.println("Please Enter Pages to Print.");
                    pages = scan.nextInt();
                    System.out.println("Please Enter Priority Number.");
                    priority = scan.nextInt();
                    
                    List.insertion(pages, priority);
                    PrintCount++;
                    break;
                case 2:
                    List.display();
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
    //constructor
    private class Node {
        int priority;
        int data;
        // int PrintCount = 0;
        Node next;
        
    }
    private Node front = null;
    
    private void insertion(int item,int priority) throws Exception{  
        Node node = new Node();
        
        node.data = item;
        node.priority = priority;
        node.next = null;
        
        if(front == null || priority <= front.priority){
            node.next = front;
            front = node;
        }else{
            Node temporary = front;
            while(temporary.next != null && temporary.next.priority <= priority){
                temporary = temporary.next;
            }
            
            node.next = temporary.next;
            temporary.next = node;
        }
    }
    
    public int deletion() throws Exception{
        int temporary = front.data;
        front = front.next;
        return temporary;
    }
    
    public void display() throws Exception{
        if(front == null){
            throw new Exception("Queue is Empty");
        }
        
        Node temporary = front;
        
        System.out.println("Priority \t\tPages ");
        
        while (temporary != null) {            
            System.out.println(temporary.priority + "\t\t\t" + temporary.data);
            temporary = temporary.next;
        }
        System.out.println("\n");
    }
}
