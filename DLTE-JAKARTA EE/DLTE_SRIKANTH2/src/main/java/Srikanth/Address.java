package Srikanth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int door_num;
    private String town;
    private String city;
    private int pincode;
    private String type;


    public Address(int p_door_num, String town1, String city1, String pincode1, String permanent) {
    }
}
