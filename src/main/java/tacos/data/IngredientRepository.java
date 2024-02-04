package tacos.data;

import org.apache.el.stream.Optional;

import tacos.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findAll();
	  //Optional findById(String id);
	   
	Optional<Ingredient> findById(String id);
	  Ingredient save(Ingredient ingredient);
}
