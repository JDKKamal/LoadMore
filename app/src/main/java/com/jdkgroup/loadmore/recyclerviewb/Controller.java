package com.jdkgroup.loadmore.recyclerviewb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamlesh on 7/31/2016.
 */
public class Controller {
    public static List<Model> al_loadmore(final int start, final int increment) {
        int total, minus, nextsum;
        total = start + increment;

        final List<Model> al_add = new ArrayList<>();
        List<Model> alsublist;

        al_add.add(new Model("A", 1, "", ""));
        al_add.add(new Model("B", 2, "", ""));
        al_add.add(new Model("C", 3, "", ""));
        al_add.add(new Model("D", 4, "", ""));
        al_add.add(new Model("E", 5, "", ""));
        al_add.add(new Model("F", 6, "", ""));
        al_add.add(new Model("G", 7, "", ""));
        al_add.add(new Model("H", 8, "", ""));
        al_add.add(new Model("I", 9, "", ""));
        al_add.add(new Model("J", 10, "", ""));
        al_add.add(new Model("K", 11, "", ""));
        al_add.add(new Model("L", 12, "", ""));
        al_add.add(new Model("M", 13, "", ""));
        al_add.add(new Model("N", 14, "", ""));
        al_add.add(new Model("O", 15, "", ""));
        al_add.add(new Model("P", 16, "", ""));
        al_add.add(new Model("Q", 17, "", ""));
        al_add.add(new Model("R", 18, "", ""));
        al_add.add(new Model("S", 19, "", ""));
        al_add.add(new Model("T", 20, "", ""));
        al_add.add(new Model("U", 21, "", ""));
        al_add.add(new Model("V", 22, "", ""));
        al_add.add(new Model("W", 23, "", ""));
        al_add.add(new Model("X", 24, "", ""));
        al_add.add(new Model("Y", 25, "", ""));
        al_add.add(new Model("Z", 26, "", ""));

        if (total < al_add.size()) {
            alsublist = new ArrayList(al_add.subList(start, total));
            return alsublist;
        } else if (start > al_add.size()) {
        } else {
            minus = al_add.size() - start;
            nextsum = start + minus;
            alsublist = new ArrayList(al_add.subList(start, nextsum));
            return alsublist;
        }
        return null;
    }
}
