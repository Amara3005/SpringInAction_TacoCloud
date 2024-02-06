package tacos.data;

//import org.apache.el.stream.Optional;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;

import tacos.Ingredient;

@ComponentScan
public interface IngredientRepository {

	Iterable<Ingredient> findAll();
	  //Optional findById(String id);
	   
	  Optional<Ingredient> findById(String id);
	  Ingredient save(Ingredient ingredient);
}
