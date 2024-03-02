package tacos.data;

//import org.apache.el.stream.Optional;

//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

//@ComponentScan
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

	 
}
