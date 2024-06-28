## Ushbu dastur Chat app hisoblanadi
```java
package uyishi2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static User user = new User();

    public static void main(String[] args) throws Exception {

        String s = "E:\\Java_4_Module\\loging\\homeworks\\uyishi2";
        String fileTxt = UserService.mkdir(s, "file.txt");
        String logTxt = UserService.mkdir(s, "log.txt");

        while (true) {
            System.out.println("""
                    \033[1;92m
                    0.   Exit
                    1.   Register
                    2.   Login
                    """);
            System.out.print("Kiriting : ");
            switch (new Scanner(System.in).nextInt()) {
                case 0 -> {
                    System.out.println("Good bye !");
                    logger.log(Level.WARNING,"Dasturdan chiqildi !!!");
                    return;
                }
                case 1 -> {
                    System.out.print("Kiriting Emailni : ");
                    String email = new Scanner(System.in).nextLine();
                    if (UserService.register(email)) {
                        String x = "Siz kiritgan email tasdiqlandi !";
                        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(fileTxt), StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
                            bufferedWriter.write(email + ", " + LocalDateTime.now() + ", " + x);
                            bufferedWriter.newLine();
                        }
                        logger.log(Level.INFO, x);
                        user.setEmail(email);
                    } else {
                        System.out.println("\033[1;91m\n" + "Email yaroqsiz !" + "\033[0m");
                    }
                }
                case 2 -> {
                    System.out.print("Kiriting Emailni : ");
                    String email = new Scanner(System.in).nextLine();
                    if (user.getEmail() != null) {
                        while (true) {
                            System.out.println("""
                                    \033[1;93m
                                    0.   Exit
                                    1.   Send message
                                    2.   View messages
                                    """);
                            System.out.print("Kiriting : ");
                            int a = new Scanner(System.in).nextInt();
                            if (a == 0) break;
                            switch (a) {
                                case 1 -> {
                                    System.out.print("Massaga yozing : ");
                                    String massage = new Scanner(System.in).nextLine();
                                    try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(logTxt), StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
                                        bufferedWriter.write(email + ", " + LocalDateTime.now() + ", " + massage);
                                        bufferedWriter.newLine();
                                    }
                                }
                                case 2 -> {
                                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logTxt))) {
                                        while (bufferedReader.ready()){
                                            System.out.println(bufferedReader.readLine());
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("\033[1;91m\n" + "Email yaroqsiz !" + "\033[0m");
                    }

                }
            }
        }

    }
}
```
* Chat App. Barcha ma'lumotlarni fileda saqlaydi. Email orqali registeratsiya qiladi. Login ham email orqali bo'ladi regexpdan foydalanib userni barcha ma'lumotlarni tekshiruvdan o'tkazdim. Barcha mufaqiyatli bo'lsa va dasurdan chiqilganida Log tashlaydi. User qachon registeratsiya bo'lgani Time classlaridan biridan foydalanib filega yozadi va o'sha filedan o'qiydi. Barcha chatlarni o'zi bilan qachon yozilganigacha vaqtni saqlab boradi. Dastur yozib bo'lganingizdan keyin githubga qo'dim.
## Images

![This is an alt text.](https://img.freepik.com/free-photo/cellphone-editorial-data-digital-modern-green_1421-358.jpg?w=740&t=st=1719585214~exp=1719585814~hmac=f2b479572520e1d99a94488a203032c30455e0090d7a31902b79e35b88e10fb2 "This is a sample image.")
