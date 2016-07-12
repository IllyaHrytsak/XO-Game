package Study;


import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<T> implements Collection<T> {

    private int size = 0;

    private T[] m = (T[])new Object[1];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(final Object o) {
        for (Object item : m) {
            if (item == o) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorArray();
    }

    @Override
    public Object[] toArray() {
        Object[] newM = (T[])new Object[size()];
        System.arraycopy(m, 0, newM, 0, size());
        return newM;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[])this.toArray();
    }

    @Override
    public boolean add(final T t) {
        if (size() == m.length) {
             final T[] oldM = m;
            m = (T[])new Object[size() * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
        }
        m[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
            for (int i = 0; i < size(); i++) {
                if (m[i].equals(o)) {
                    if (i != this.size() - 1)
                        System.arraycopy(m, i + 1, m, i, this.size() - i - 1);
                    size--;
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size(); i++){
            if (!c.contains(m[i])) {
                this.remove(m[i]);
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        m = (T[])new Object[1];
        size = 0;
    }

    private class IteratorArray<T> implements Iterator<T> {

        private int size;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size() > size;
        }

        @Override
        public T next() {
            return (T)ArrayCollection.this.m[size++];
        }
    }
}
