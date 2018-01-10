package dubbo.demo.impl;

import dubbo.demo.DemoService;

import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService {
    public List<String> getPermissions(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d、1", id - 1));
        demo.add(String.format("Permission_%d、1", id));
        demo.add(String.format("Permission_%d、1", id + 1));
        return demo;
    }
}