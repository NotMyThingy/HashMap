
public class List<T> {

    private T[] lista;
    private int alkioita;

    public List(10) {
        this(10);
    }

    public List(int size) {
        this.lista = (T[]) new Object[size];
        this.alkioita = 0;
    }

    /**
     * @param arvo
     * @return saves the given value into the array
     */
    public void add(T arvo) {
        if (this.lista.length == this.alkioita) {
            listEnlarge();
        }

        this.lista[alkioita] = arvo;
        this.alkioita++;
    }

    /**
     * @param arvo
     * @return returns true if the list contains the value
     */
    public boolean contains(T arvo) {
        return itemIndex(arvo) >= 0;
    }

    /**
     * @param arvo
     * @return removes the given value from the list
     */
    public void remove(T arvo) {
        int removableIndex = itemIndex(arvo);
        if (removableIndex < 0) {
            return;
        }

        moveToLeft(removableIndex);
        this.alkioita--;
    }

    /**
     * @param index
     * @return returns the value from the given index
     */
    public T get(int index) {
        if (index < 0 || index >= this.alkioita) {
            throw new ArrayIndexOutOfBoundsException("Indeksi " + index + " alueen [0, " + this.alkioita + "[ ulkopuolella.");
        }

        return this.lista[index];
    }

    /**
     * @param arvo
     * @return returns the index of the given value
     */
    public int itemIndex(T arvo) {
        for (int i = 0; i < this.alkioita; i++) {
            if (this.lista[i].equals(arvo)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @return returns the current size of the list.
     */
    public int size() {
        return this.alkioita;
    }

    /**
     * @param startingFromIndex
     */
    private void moveToLeft(int startingFromIndex) {
        for (int i = startingFromIndex; i < this.alkioita - 1; i++) {
            this.lista[i] = this.lista[i + 1];
        }
    }

    /**
     *
     */
    private void listEnlarge() {
        T[] uusiLista = (T[]) new Object[this.lista.length + this.lista.length / 2];
        for (int i = 0; i < this.lista.length; i++) {
            uusiLista[i] = this.lista[i];

            this.lista = uusiLista;
        }
    }
}
