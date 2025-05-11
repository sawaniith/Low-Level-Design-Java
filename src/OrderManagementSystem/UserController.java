package OrderManagementSystem;

import java.util.List;

public class UserController {
    List<User> userList;

    UserController(List userList){
        this.userList = userList;
    }

    //add user
    public User createUser(){
        User user = new User();
        user.userId = 1;
        user.userName = "SJ";
        user.address = new Address(230011, "city", "state");
        userList.add(user);
        return user;
    }

    //remove user
    public void removeUser(User user){
        userList.remove(user);
    }

    //get particular user
    public User getUser(int userId){
        for(User user : userList){
            if(user.userId == userId){
                return user;
            }
        }
        return null;
    }
}
