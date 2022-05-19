package kr.co.kwonshzzang.springadmin.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderDetailList", "partner"})
@Builder
@Accessors(chain = true)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String name;
    private String title;
    private String content;
    private Double price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;


    // 1 : N
    //LAZY = 지연로딩, EAGER = 즉시로딩 (1 : 1만 추천)
    //LAZY = select * from item where id =?
    //EAGER(Join) = : from item item0_ left outer join order_detail orderdetai1_
    //                on item0_.id=orderdetai1_.item_id
    //                left outer join user user2_
    //                on orderdetai1_.user_id=user2_.id
    //                where item0_.id=?

    //Item : OrderDetail => 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

    //Item : Partner => N : 1
    @ManyToOne
    private Partner partner;
}
