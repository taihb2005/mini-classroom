package vn.edu.hust.taika.miniclassroom.model;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

}
