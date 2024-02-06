package tacos.web;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")

public class DesignTacoController {
	
	 private final IngredientRepository ingredientRepo;
    
	 @Autowired
     public DesignTacoController(IngredientRepository ingredientRepo) {
       this.ingredientRepo = ingredientRepo;
   }
   
	 @ModelAttribute
     public void addIngredientsToModel(Model model) {
   Iterable<Ingredient> ingredients = ingredientRepo.findAll();
   Type[] types = Ingredient.Type.values();
   
   for (Type type : types) {
   model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
   }
	 }
	
	//@ModelAttribute
	//public void addIngredientsToModel(Model model) {
		//System.out.println("addIngredients");
		
	   // List<Ingredient> ingredients = Arrays.asList(
	     // new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
	     // new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
	    //  new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
	     // new Ingredient("CARN", "Carnitas", Type.PROTEIN),
	     // new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
	    //  new Ingredient("LETC", "Lettuce", Type.VEGGIES),
	   //   new Ingredient("CHED", "Cheddar", Type.CHEESE),
	     // new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
	    //  new Ingredient("SLSA", "Salsa", Type.SAUCE),
	    //  new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
	//);
      
	    /*Type[] types = Ingredient.Type.values();
	    for (Type type : types) {
	          model.addAttribute(type.toString().toLowerCase(),
	        		  filterByType(ingredients, type));
		        }*/
	    //System.out.println("Model Attributes:");
       // for (String attributeName : model.asMap().keySet()) {
         //   Object attributeValue = model.asMap().get(attributeName);
         //   System.out.println(attributeName + ": " + attributeValue);
	          
	   // } 
	//}

	      @ModelAttribute(name = "tacoOrder")
	      public TacoOrder order() {
	    	  System.out.println("Tacoorder");
	        return new TacoOrder();
	      }
	      @ModelAttribute(name = "taco")
	      public Taco taco() {
	    	  System.out.println("Taco");
	        return new Taco();
	      }
	      @GetMapping
	      public String showDesignForm() {
	    	  System.out.println("getreq");
	        return "design";
	      }
	      
	     // @PostMapping
	      //public String processTaco(Taco taco,
	           //       @ModelAttribute TacoOrder tacoOrder) {
	        //tacoOrder.addTaco(taco);
	       // log.info("Processing taco: {}", taco);
	      //  return "redirect:/orders/current";
	      //}
            
	      @PostMapping
	      public String processTaco(
	              @Valid Taco taco, Errors errors,
	              @ModelAttribute TacoOrder tacoOrder) {
	        if (errors.hasErrors()) {
	          return "design";
	    }
	        tacoOrder.addTaco(taco);
	        log.info("Processing taco: {}", taco);
	        return "redirect:/orders/current";
	      }

	      private Iterable<Ingredient> filterByType(
	    	        Iterable<Ingredient> ingredients, Type type) {
	    	                       return ingredients;
	      }
	      
	      
	     /* private Iterable<Ingredient> filterByType(
	          Iterable<Ingredient> ingredients, Type type) {
	        return ((Object) ingredients)
	                  .stream()
	                  .filter(x -> x.getType().equals(type))
	                  .collect(Collectors.toList());*/
	}
	      
