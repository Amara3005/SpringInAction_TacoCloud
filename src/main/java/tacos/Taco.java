//package tacos;
//import java.util.List;
//import lombok.Data;

//@Data
//public class Taco {
	
    // private String name;
     //private List<Ingredient> ingredients;
//}

package tacos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
//@Table
@Entity
public class Taco {
	 
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private Date createdAt = new Date();
 
	@NotNull
     @Size(min=5, message="Name must be at least 5 characters long") 
	private String name;
    
	@NotNull
    @Size(min=1, message="You must choose at least 1 ingredient") 
	@ManyToMany(targetEntity=Ingredient.class)
	//private List<IngredientRef> ingredients = new ArrayList<>();
	private List<Ingredient> ingredients = new ArrayList<>();
	
	/*( public void addIngredient(Ingredient ingredient) {
		    this.ingredients.add(ingredient);
		}*/

	public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
