import java.io.*;
import java.util.*;
class prg4
  {
  	public static void main(String args[]) throws IOException
  	  {
  	  	 int n,num,ch,flag=0;
  	  	 String s="",name,mname="",mno;
  	  	 Hashtable h1=new Hashtable();
  	     DataInputStream br=new DataInputStream(System.in);
  	     System.out.println("Main menu for student information using Hash table:");
  	     System.out.println("1:Add student");
  	     System.out.println("2:Display details of student");
  	     
  	    
  	     System.out.println("5:Exit");
  	     do
  	     {
  	  	  System.out.print("Enter your choice:");
  	  	  ch=Integer.parseInt(br.readLine());
    	  switch(ch)
    	   {
  	 	     case 1: System.out.print("Enter the student name:");
  	  	             name=br.readLine();
  	  	             System.out.print("Enter the student Mobile Number:");  	 
  	  	             mno=br.readLine();
  	  	             
  	  	             h1.put(name,mno);
  	  	             break;
  	           	 
  	         case 2: System.out.println("Enter the student name to find percentage:");
  	  	         	   Enumeration e2=h1.keys();
  	  	             while(e2.hasMoreElements())
  	  	               {
  	  	                 s=(String)e2.nextElement();
     	                
  	  	               	  System.out.println("Name   Percentage");
  	  	                    System.out.println(s+"\t"+h1.get(s));
  	  	                   
  	  	                  }  
  	  	               }
  	  	            
  	       
  	         
  	  	   
  	  	 }while(ch!=3);            
  	  } 
  }
  
