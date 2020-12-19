package cn.tuling.Model;

import org.springframework.beans.factory.annotation.Value;

public class Wife {
    @Value("德莱厄斯")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
