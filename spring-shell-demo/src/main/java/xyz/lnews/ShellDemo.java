package xyz.lnews;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellDemo {

    @ShellMethod("To multiply.")
    public int mul(int a, int b) {
        return a*b;
    }

    @ShellMethod("Display stuff.")
    public String strdis(int a, int b, int c) {
        return String.format("You said a=%d, b=%d, c=%d", a, b, c);
    }

    @ShellMethod("Display string.")
    public String echo(String str) {
        return String.format("You said %s",str);
    }

}
