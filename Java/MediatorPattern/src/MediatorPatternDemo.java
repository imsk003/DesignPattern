public class MediatorPatternDemo {  
      
    public static void main(String args[])  
    {  
          
          ChatRoom chat = new ChatRoomImpl();  
      
          User1 u1=new User1(chat);  
          u1.setname("SK");  
          u1.sendMsg("Hiii");  
        
                
          User2 u2=new User2(chat);  
          u2.setname("AK");  
          u2.sendMsg("Hii there");  
    }  
  
}