package org.example;
import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private int card_num;

    public User(String first_name, String last_name, String username, String plainPassword,int card_num) throws NoSuchAlgorithmException {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.card_num = card_num;
        this.password = hashPassword(plainPassword);
    }

    public User() {
        super();
        this.first_name = null;
        this.last_name = null;
        this.username = null;
        this.password = null;
    }

    private String hashPassword(String plainPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        String salt = getSalt();
        String generatedPassword;
        md.update(salt.getBytes());
        byte[] bytes = md.digest(plainPassword.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }

    private String getSalt() throws NoSuchAlgorithmException {
        return first_name+card_num;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String name) {
        this.first_name = name;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String name) {
        this.last_name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        return hashPassword(password).equals(this.password);
    }
    public String getPassword(){
        return password;
    }
    public int getId() {
        return id;
    }

    public int getCardNum(){
        return card_num;
    }
    public void setCardNum(int card_num){
        this.card_num = card_num;
    }
}
