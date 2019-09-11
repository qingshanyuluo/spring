package xyz.lennon.spring.test;

public class UserController {

    @Autowired
    private UserService userService;
    //no auto wired
    private Integer integer;
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
