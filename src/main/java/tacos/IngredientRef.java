package tacos;

import lombok.Data;

@Data
public class IngredientRef {
	public IngredientRef(String id) {
		// TODO Auto-generated constructor stub
		this.ingredient = id;
	}

	private String ingredient;
}
