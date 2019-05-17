public class CollectionofNames implements Container {  
public String name[]={"Arun", "Selva","Ram","Mani","Karthi"};   
      
@Override  
    public Iterator getIterator() {  
        return new CollectionofNamesIterate() ;  
    }  
    private class CollectionofNamesIterate implements Iterator{  
        int i;  
        @Override  
        public boolean hasNext() {  
            if (i<name.length){  
                return true;  
            }  
            return false;  
        }  
        @Override  
        public Object next() {  
            if(this.hasNext()){  
                return name[i++];  
            }  
            return null;      
        }  
    }  
}  
