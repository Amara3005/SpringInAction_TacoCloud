package tacos.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.IngredientRef;
import tacos.data.IngredientRepository;


@Component

public class IngredientByIdConverter implements Converter<String, Ingredient> 
{
	private IngredientRepository ingredientRepo;
	@Autowired
	public IngredientByIdConverter(IngredientRepository ingredientRepo) 
	{
	
	 System.out.println(" IngredientConveter ");
	 this.ingredientRepo = ingredientRepo; 
	}
	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);

	}
	
	/*@Override
	  public Ingredient convert(String id) {
	    return ingredientRepo.findById(id);
	  }*/
}
