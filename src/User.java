import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String role = "customer";

    static Scanner scanner = new Scanner(System.in);
    public User(String lastName, String firstName, String patronymic, String phone, String email, String login, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        System.out.println("Введите фамилию:");
        do{
            this.lastName = scanner.nextLine();
            if(!lastName.matches("\\D*")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!lastName.matches("\\D*"));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        System.out.println("Введите имя:");
        do{
            this.firstName = scanner.nextLine();
            if(!firstName.matches("\\D*")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!firstName.matches("\\D*"));
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic() {
        System.out.println("Введите отчество:");
        do{
            this.patronymic = scanner.nextLine();
            if(!patronymic.matches("\\D*")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!patronymic.matches("\\D*"));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<User> users) {
        System.out.println("Введите номер телефона:");
        do{
            this.phone = scanner.nextLine();

            if(!phoneUnique(users,phone)){
                setPhone(users);
            }
            if(!phone.matches("^((\\+7|7|8)+([0-9]){10})$")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!phone.matches("^((\\+7|7|8)+([0-9]){10})$"));
    }

    public boolean phoneUnique(ArrayList<User> users, String phone){
        if(users == null){
            return true;
        }
        for(User user : users){
            if(phone.equals(user.phone)){
                System.out.println("Этот номер телефона уже используется");
                return false;
            }
        }
        return true;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(ArrayList<User> users) {
        System.out.println("Введите email:");
        do{
            this.email = scanner.nextLine();

            if(!emailUnique(users,email)){
                setEmail(users);
            }

            if(!email.matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!email.matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$"));
    }

    public boolean emailUnique(ArrayList<User> users, String email){
        if(users == null){
            return true;
        }
        for(User user : users){
            if(email.equals(user.email)){
                System.out.println("Этот email уже используется");
                return false;
            }
        }
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(ArrayList<User> users) {
        System.out.println("Введите логин:\n(2-20 символов, буквы и цифры, первый символ " +
                "обязательно буква)");

        do{
            this.login = scanner.nextLine();

            if(!loginUnique(users,login)){
                setLogin(users);
            }

            if(!login.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!login.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"));
    }

    public boolean loginUnique(ArrayList<User> users, String login){
        if(users == null){
            return true;
        }
        for(User user : users){
            if(login.equals(user.login)){
                System.out.println("Этот логин уже занят");
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(ArrayList<User> users) {
        System.out.println("Введите пароль:\n(цифры, а также cтрочные и прописные латинские " +
                "буквы)");

        do{
            this.password = scanner.nextLine();

            if(!passwordUnique(users,password)){
                setPassword(users);
            }
            if(!password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")){
                System.out.println("Введите корректные данные");
            }
        }
        while (!password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$"));
    }

    public boolean passwordUnique(ArrayList<User> users, String email){
        if(users == null){
            return true;
        }
        for(User user : users){
            if(password.equals(user.password)){
                System.out.println("Этот логин уже занят");
                return false;
            }
        }
        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }


}
