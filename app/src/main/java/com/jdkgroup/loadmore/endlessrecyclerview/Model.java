package com.jdkgroup.loadmore.endlessrecyclerview;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private String mName;
    private boolean mOnline;

    public Model(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    public static List<Model> createContactsList(final int start, final int increment) {
        int total, minus, nextsum;
        total = start + increment;
        List<Model> alsublist;

        List<Model> models = new ArrayList<>();
        models.add(new Model("1", true));
        models.add(new Model("2", true));
        models.add(new Model("3", true));
        models.add(new Model("4", true));
        models.add(new Model("5", true));
        models.add(new Model("6", true));
        models.add(new Model("7", true));
        models.add(new Model("8", true));
        models.add(new Model("9", true));
        models.add(new Model("10", true));
        models.add(new Model("A", true));
        models.add(new Model("B", true));
        models.add(new Model("C", true));
        models.add(new Model("D", true));
        models.add(new Model("E", true));
        models.add(new Model("F", true));
        models.add(new Model("G", true));
        models.add(new Model("H", true));
        models.add(new Model("I", true));
        models.add(new Model("J", true));
        models.add(new Model("K", true));
        models.add(new Model("L", true));
        models.add(new Model("M", true));
        models.add(new Model("N", true));
        models.add(new Model("O", true));
        models.add(new Model("P", true));
        models.add(new Model("Q", true));
        models.add(new Model("R", true));
        models.add(new Model("S", true));
        models.add(new Model("T", true));
        models.add(new Model("U", true));
        models.add(new Model("V", true));
        models.add(new Model("W", true));
        models.add(new Model("X", true));
        models.add(new Model("Y", true));
        models.add(new Model("Z", true));

        System.out.println("pagignation " + start + "-" + total);

        if (total < models.size()) {
            alsublist = new ArrayList(models.subList(start, total));
            return alsublist;
        } else if (start > models.size()) {
        } else {
            minus = models.size() - start;
            nextsum = start + minus;
            alsublist = new ArrayList(models.subList(start, nextsum));
            return alsublist;
        }
        return null;
    }
}