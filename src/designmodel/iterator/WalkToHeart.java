package designmodel.iterator;

import java.util.Iterator;

/**
 * @author huang
 * @version 1.0
 * @date 2018/12/26 17:49
 **/

public class WalkToHeart {
    private int index = -1;
    private String[] records = new String[10];

    public void append(String record) {
        if (index == 9) {
            index = 0;
        } else {
            index++;
        }
        records[index] = record;
    }

    public Iterator<String> iterator(){
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        int cursor = index;
        int loopCount = 0;

        @Override
        public boolean hasNext() {
            return loopCount < 10;
        }

        @Override
        public String next() {
            int i = cursor;
            if (cursor == 0) {
                cursor = 9;
            } else {
                cursor--;
            }
            loopCount++;
            return records[i];
        }
    }

}
