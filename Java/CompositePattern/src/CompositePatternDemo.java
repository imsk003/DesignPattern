public class CompositePatternDemo {  
    public static void main(String args[]){  
         Employee emp1=new Cashier(1,"SK", 20000.0);  
         Employee emp2=new Cashier(2,"AK", 25000.0);  
         Employee emp3=new Accountant(3,"BV", 30000.0);   
         Employee manager=new BankManager(4,"RK",100000.0);  
            
          manager.add(emp1);  
          manager.add(emp2);  
          manager.add(emp3);  
          manager.print();  
        }  
}  