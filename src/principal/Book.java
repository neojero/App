package principal;

public class Book {

    private String title;

    public void setTitle(String title) throws Exception {
    	if (title == null) {
    		throw new Exception("Erreur : Null");
    	}
   
    	if (title.isEmpty()) {
    		throw new Exception("Erreur : Empty");
    	}
    	
    	if (title.isBlank()) {
    		throw new Exception("Erreur : Blank");
    	}
    	
    	this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
}


