package software.ulpgc.commands;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Builder> builders;

    public CommandFactory() {
        builders = new HashMap<>();
    }

    public void register(String name, Builder builder){
        builders.put(name, builder);
    }

    public Selector with(HttpServletRequest req, HttpServletResponse res){
        return name -> builders.get(name).build(req,res);
    }

    public interface Builder{
        Command build(HttpServletRequest req, HttpServletResponse res);
    }

    public interface Selector{
        Command build(String name);
    }
}
