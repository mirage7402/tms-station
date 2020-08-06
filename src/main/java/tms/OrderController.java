package tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
 public class OrderController {

 @Autowired
 OrderRepository orderRepository;

// @RequestMapping(method=RequestMethod.PATCH, path="/orders/cancel")
// public void orderCancel(@RequestParam(value="id", required=false, defaultValue="0") String id) {

//  Optional<Order> orders = orderRepository.findById(Long.valueOf(id));
//  System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
//  orderRepository.delete(orders.get());
  //orders.get().setId(Long.valueOf(id));
  //orders.get().setDescription("CANCELORDERED");
//  System.out.println("D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2D2");
  //orderRepository.delete(orders.get());
// }




}
