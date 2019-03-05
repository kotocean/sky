package cn.spotsport.sky.coursetype;

import javax.persistence.*;

@Entity
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long restaurantId;
    public CourseType(){}

    public CourseType(String name, Long restaurantId) {
        this.name = name;
        this.restaurantId = restaurantId;
    }

    public Long getId() {
        return id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
