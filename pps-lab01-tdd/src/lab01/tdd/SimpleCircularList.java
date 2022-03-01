package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> list;
    private int index;

    public SimpleCircularList() {
        list = new ArrayList<>();
        index = 0;
    }


    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.isEmpty()){
            return Optional.empty();
        } else {
            int element = list.get(index);
            index = index == this.size()-1 ? 0 : index +1;
            return Optional.of(element);
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        } else {
            int element = list.get(index);
            index = index == 0 ? this.list.size()-1 : index-1;
            return Optional.of(element);
        }
    }

    @Override
    public void reset() {
        this.index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
