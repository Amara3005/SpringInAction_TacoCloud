package tacos.web;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")

public class DesignTacoController {
	
	 private final IngredientRepository ingredientRepo;
    
     public DesignTacoController(IngredientRepository ingredientRepo) {
       this.ingredientRepo = ingredientRepo;
   }
   
	 @ModelAttribute
     public void addIngredientsToModel(Model model) 
	 {
		 List<Ingredient> ingredients = new ArrayList<>();
		 ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		    
		 Type[] types = Ingredient.Type.values();
   
		 for (Type type : types) 
		 {
			 model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
		 }
	 }
	
	
	      @ModelAttribute(name = "tacoOrder")
	      public TacoOrder order() {
	    	  System.out.println("Tacoorder");
	        return new TacoOrder();
	      }
	      
	      
	      @ModelAttribute(name = "taco")
	      public Taco taco() 
	      {
	    	  System.out.println("Taco");
	    	  return new Taco();
	      }
	      
	      
	      @GetMapping
	      public String showDesignForm(Model model) 
	      {
	    	  
	    	  System.out.println("getreq");
	    	  System.out.println("Model "+model);
	    	  return "design";
	      }
	      
	                 
	      @PostMapping
	      public String processTaco(@Valid Taco taco, Errors errors,@ModelAttribute TacoOrder tacoOrder) 
	      {
	        if (errors.hasErrors()) 
	        {
	          return "design";
	        }
	        System.out.println(taco);
	        tacoOrder.addTaco(taco);
	 
	        return "redirect:/orders/current";
	      }

	      	      
	      
	      private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) 
	      {
	    	  
	    	  System.out.println(ingredients);	    	    return ingredients
	    	              .stream()
	    	              .filter(x -> x.getType().equals(type))
	    	              .collect(Collectors.toList());
	      }
	      
}
