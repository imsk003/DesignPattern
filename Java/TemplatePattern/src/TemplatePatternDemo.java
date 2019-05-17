public class TemplatePatternDemo {  
  
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {  
          
         Class c=Class.forName("Chess");  
         Game game=(Game) c.newInstance();  
         game.play();     
       }  
}