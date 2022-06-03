package kr.co.kwonshzzang.springadmin.sample;


import kr.co.kwonshzzang.springadmin.model.entity.Item;
import kr.co.kwonshzzang.springadmin.model.entity.OrderDetail;
import kr.co.kwonshzzang.springadmin.model.entity.OrderGroup;
import kr.co.kwonshzzang.springadmin.model.entity.User;
import kr.co.kwonshzzang.springadmin.model.enumClass.OrderStatus;
import kr.co.kwonshzzang.springadmin.model.enumClass.OrderType;
import kr.co.kwonshzzang.springadmin.model.enumClass.PaymentType;
import kr.co.kwonshzzang.springadmin.repository.ItemRepository;
import kr.co.kwonshzzang.springadmin.repository.OrderDetailRepository;
import kr.co.kwonshzzang.springadmin.repository.OrderGroupRepository;
import kr.co.kwonshzzang.springadmin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
class OrderDetailSample  {

    private Random random = new Random();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    void createOrder(){

        List<User> userList = userRepository.findAll();

        for(int j = 0; j < 1; j++){
            User user = userList.get(j);
            item(user);

        }


        userList.forEach(user -> {

            int orderCount = random.nextInt(10) + 1;
            for (int i = 0; i < orderCount; i++) {
                item(user);
            }
        });


    }


    private void item(User user){
        double totalAmount = 0;

        List<Item> items = new ArrayList<>();
        List<OrderDetail> orderHistoryDetails = new ArrayList<>();


        int itemCount = random.nextInt(10)+1;
        for(int i = 0 ; i < itemCount; i ++){
            // db에 아이템 갯수가 총 500개 ( * 자신의 샘플에 맞추세요 )
            int itemNumber = random.nextInt(405)+1;

            Item item = itemRepository.findById((long)itemNumber).get();
            totalAmount += item.getPrice().doubleValue();
            items.add(item);
        }


        int s = random.nextInt(3)+1;
        OrderStatus status = OrderStatus.ORDERING;
        PaymentType paymentType = PaymentType.BANK_TRANSFER;
        switch (s){
            case 1 :
                status = OrderStatus.ORDERING;
                paymentType = PaymentType.BANK_TRANSFER;
                break;

            case 2 :
                status =OrderStatus.COMPLETE;
                paymentType = PaymentType.CARD;
                break;

            case 3 :
                status = OrderStatus.CONFIRM;
                paymentType = PaymentType.CHECK_CARD;
                break;
        }

        int t = random.nextInt(2)+1;
        OrderType type = t==1? OrderType.ALL:OrderType.EACH;

        OrderGroup orderGroup = OrderGroup.builder()
                .user(user)
                .status(status)
                .orderType(type)
                .revAddress("경기도 분당구 판교역로")
                .revName(user.getEmail())
                .paymentType(paymentType)
                .totalPrice(new BigDecimal(totalAmount))
                .orderAt(getRandomDateTime())
                .totalQuantity(itemCount)
                .arrivalDate(getRandomDate().plusDays(3))
                .orderDetailList(orderHistoryDetails)
                .build();

        orderGroupRepository.save(orderGroup);



        for(Item item : items){

            OrderStatus orderDetailStatus = OrderStatus.ORDERING;
            switch (random.nextInt(3)+1){
                case 1 :
                    orderDetailStatus = OrderStatus.ORDERING;
                    break;

                case 2 :
                    orderDetailStatus = OrderStatus.COMPLETE;
                    break;

                case 3 :
                    orderDetailStatus = OrderStatus.CONFIRM;
                    break;
            }


            OrderDetail orderDetail = OrderDetail.builder()
                    .orderGroup(orderGroup)
                    .item(item)
                    .quantity(1)
                    .totalPrice(BigDecimal.valueOf(0))
                    .arrivalDate(type.equals(OrderType.ALL) ? orderGroup.getArrivalDate() : getRandomDate())
                    .status(type.equals(OrderType.ALL) ? status :orderDetailStatus)
                    .build();
            orderDetailRepository.save(orderDetail);
            orderHistoryDetails.add(orderDetail);
        }


    }


    private LocalDateTime getRandomDateTime(){
        return LocalDateTime.of(2022,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private LocalDate getRandomDate(){
        return LocalDate.of(2022, getRandomNumber(), getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
