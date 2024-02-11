package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.IngredientRef;
import tacos.data.IngredientRepository;


@Component

public class IngredientByIdConverter implements Converter<String,IngredientRef> 
{
	private IngredientRepository ingredientRepo;
	@Autowired
	public IngredientByIdConverter(IngredientRepository ingredientRepo) 
	{
	
	 System.out.println(" IngredientConveter ");
	 this.ingredientRepo = ingredientRepo; 
	}
	@Override
	public IngredientRef convert(String id) {
		return new IngredientRef(id);


	}
}
