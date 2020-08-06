package tms;

import tms.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:+eventString:"+eventString);
    }

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderRegistered_orderRegistNotify(@Payload OrderRegistered orderRegistered){

        if(orderRegistered.isMe() && orderRegistered.getId()!=null){
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ORDERORDERORDERORDER@@@@@@@@@@@@@@@@@@@@@@");
            Optional<Order> orders = orderRepository.findById(orderRegistered.getId());
            orders.get().setId(orderRegistered.getId());
            //orders.get().setStatus("JOINORDERCOMPLETE");
            orderRepository.save(orders.get());


//            }
            System.out.println("ttttttttttttttttttttttttttttttttttttt");

        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_orderCancelNotify(@Payload OrderCanceled orderCanceled){
        System.out.println("99999999999999999999999999999999999999999999" );
        if(orderCanceled.isMe() && orderCanceled.getId()!=null){
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            Optional<Order> orders = orderRepository.findById(orderCanceled.getId());
            orders.get().setId(orderCanceled.getId());
            //orders.get().setStatus("JOINORDERCOMPLETE");
            orderRepository.save(orders.get());


//            }
            System.out.println("*********************************************");

        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelAccepted_OrderCancelAccept(@Payload OrderCanceled orderCanceled){
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" );
        if(orderCanceled.isMe() && orderCanceled.getId()!=null){

            System.out.println("77777777777777777777777777777777777777777777" );

            Optional<Order> orders = orderRepository.findById(orderCanceled.getId());
            orders.get().setId(orderCanceled.getId());
            orders.get().setDescription("ORDERCANCELED");
            orderRepository.save(orders.get());


            System.out.println("##### listener OrderCancelAccept status : " + orderCanceled.toJson());
        }
    }



}
