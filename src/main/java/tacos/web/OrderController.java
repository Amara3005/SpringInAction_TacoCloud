package tacos.web;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.SessionAttributes; 
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import tacos.TacoOrder;
import tacos.data.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")


public class OrderController {
	
	private OrderRepository orderrepo;
	
	OrderController(OrderRepository repo)
	{
		this.orderrepo = repo;
	}
	
  @GetMapping("/current")
  public String orderForm() {
	  System.out.println(" OrderController ");
    return "orderForm";
  }
  
  
 // @PostMapping
 // public String processOrder(TacoOrder order,
   //       SessionStatus sessionStatus) {
    //log.info("Order submitted: {}", order);
    //sessionStatus.setComplete();
    //return "redirect:/";
  //}
  
  @PostMapping
  public String processOrder(@Valid TacoOrder order, Errors errors,SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    System.out.println(order);
    order.setPlacedAt();
    orderrepo.save(order);
    //log.info("Order submitted: {}", order);
    sessionStatus.setComplete();
    return "redirect:/";
  }
}