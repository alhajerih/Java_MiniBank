package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {


    private static BankSingleton instance;
    private List<User>users;



    public static BankSingleton getInstance(){
        if(instance==null){
        instance = new BankSingleton();
        }
        return instance;
    }

    private BankSingleton() {
        users = new ArrayList<>();
    }

    //Create username
    public User createUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                throw new IllegalArgumentException("Username already exists.");
            }
        }
        // create and add
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    public User authenticate(String username,String password){
        if(username ==null || password==null){
            return null;
        }

        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }

        return null;
    }





}
