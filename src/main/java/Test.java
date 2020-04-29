import org.springframework.util.DigestUtils;

public class Test {
    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex("11223".getBytes());
        System.out.println(s);
        if ("3b712de48137572f3849aabd5666a4e3".equals(s)) {
            System.out.println(555);
        }
    }
}
