import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Products> products = new ArrayList<>();


        Products thing1 = new Products("Кирпич фасадный", 315);
        users.add(new User());
        Products thing2 = new Products("Щит мебельный", 320);
        products.add(thing1);
        products.add(thing2);


//        User admin = new User("Иволгин","Пётр","Cтепанович","+78904564141","ivolgin@ya.ru","admin",
//                "admin");
//        admin.setRole("aдминистратор");
//        users.add(admin);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в магазин!");

        boolean exit = false;

        while (true) {
            User user = new User();

            if (exit == true) {
                break;
            }
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    users.add(registration(users));
                    break;
                case 2:
                    authentication(users);
                    System.out.println("Привет");
                    break;
                case 3:
                    break;
            }
        }

    }

    public static boolean authentication(ArrayList<User> users) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            System.out.println("Авторизация\n-----------");
            System.out.println("Введите логин или email:");
            String loginOrEmail = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            User user = new User(loginOrEmail, password);
            if(Objects.equals(loginOrEmail, "admin") && Objects.equals(password, "admin")){
                System.out.println("--------------\nВы администратор\n--------------\n");

                adminMenu();
                switch(scanner.nextInt()){
                    case 1:
                        break;
                    case 2:
                        break;
                }
                return true;
            }
            if (!findUser(user, users)) {
                System.out.println("----------------------\nНеправильный логин или " +
                        "пароль\n----------------------\n");
            }
        }
        return false;
    }

    static boolean findUser(User customer,ArrayList<User> users) {
        for (User user : users) {

            if (user.getLogin().equals(customer.getLogin()) &&
                    user.getPassword().equals(customer.getPassword())) {
                System.out.println("-----------\nВы вошли\n-----------\n");

                userMenu();
                return true;
            }
            // в логине может быть и email
            if(user.getEmail().equals(customer.getLogin()) && user.getPassword().equals(customer.getPassword())){
                System.out.println("-----------\nВы вошли\n-----------\n");

                userMenu();
                return true;
            }
        }
        System.out.println("Такого пользователя нет в системе");
        return false;
    }

    static User registration(ArrayList<User> users) {
        User user = new User();
        System.out.println("\nРегистрация\n-----------");
        user.setLastName();
        user.setFirstName();
        user.setPatronymic();
        user.setPhone(users);
        user.setEmail(users);
        user.setLogin(users);
        user.setPassword(users);
        System.out.println("----------------------\nПользователь добавлен\n----------------------");

        return user;
    }

    static void menu() {
        System.out.println("\n" +
                "Для доступа к каталогу товаров, пожалуйста,\n" +
                "войдите в Личный Кабинет.\n\n" +
                "Выберите действие:\n\n1 - регистрация\n2 - вход в ЛК");
    }

    static void adminMenu(){
        System.out.println("Здравствуйте Администратор\n\nВыберите действие:\n\n1 - получить " +
                "список пользователей\n2 - получить список товаров\n3 - выйти из личного " +
                "кабинета");
    }

    static void userMenu(){
        System.out.println("\nПожалуйста, ознакомьтесь с нашими акционными товара!\n\nВыберите " +
                "действие:\n\n1 - получить список товаров\n2 - выйти из личного кабинета");
    }


}
