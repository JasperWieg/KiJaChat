
/**
 * Generische Klasse DynArray<ContentType>
 * Konform programmiert mit den Methoden des Landes Niedersachsen bezueglich der gegebenen ergaenzenden Informationen
 * zu Abitur 2025. <br />
 * Generelle Informationen: <br />
 * Funktioniert aehnlich zur Java-internen Klasse ArrayList.
 * Der Inhaltstyp von Eintraegen innerhalb der dynamischen Reihung ist moeglich bei der
 * Initialisierung eines Objekts.
 *
 * @param <ContentType>
 * @author Birgit Komander
 */

public class DynArray<ContentType> {
    /* Angang private Attribute der Klasse DynArray */
    private ContentType[] list;
    private int lastPos; // Index des letzten Elements eines DynArrays

    /**
     * Konstruktor DynArray<ContentType>
     */
    public DynArray() {
        this.list = (ContentType[]) new Object[0];
        this.lastPos = 0;
    }

    /* Anfang Methoden in Reihenfolge des Informationsblattes fuer das Abitur 2025 */

    /**
     * Methode isEmpty() <br />
     * Wenn die dynamische Reihung kein Element enthaelt, wird der Wert wahr zurueckgegeben, sonst der Wert falsch.
     *
     * @return Wahrheitswert
     */
    public boolean isEmpty() {
        return (this.list.length == 0);
    }

    /**
     * Methode getItem(index: Ganzzahl) <br />
     * Der Inhalt des Elements an der Position index wird zurueckgegeben.
     *
     * @param index: Ganzzahl (int)
     * @return Inhaltstyp
     */
    public ContentType getItem(int index) {
        if (!isEmpty()) {
            return this.list[index];
        } else {
            return null;
        }
    }

    /**
     * Methode append(inhalt: Inhaltstyp) <br />
     * Ein neues Element mit dem uebergebenen Inhalt wird am Ende der dynamischen Reihung angefuegt.
     *
     * @param content: Inhaltstyp
     */
    public void append(ContentType content) {
        if(isEmpty()) {
            ContentType[] tmp = (ContentType[]) new Object[1];
            tmp[this.lastPos] = content;
            this.list = tmp;
        } else {
            ContentType[] tmp = (ContentType[]) new Object[this.list.length + 1];
            for (int i = 0; i <= lastPos; i++) {
                tmp[i] = this.list[i];
            }
            this.lastPos++;
            tmp[this.lastPos] = content;
            this.list = tmp;
        }
    }

    /**
     * Methode insertAt(index: Ganzzahl, content: Inhaltstyp) <br />
     * Ein neues Element mit dem uebergebenen Inhalt wird an der Position index
     * in die dynamische Reihung eingefuegt. <br />
     * Das Element, das sich vorher an dieser Position befunden hat, und alle
     * nachfolgenden werden nach hinten verschoben. <br />
     * Entspricht der Wert von index der Laenge der dynamischen Reihung, so wird
     * ein neues Element am Ende der dynamischen Reihung angefuegt.
     *
     * @param index: Ganzzahl (int)
     * @param content: Inhaltstyp
     */
    public void insertAt(int index, ContentType content) {
        if (index == this.list.length) {
            append(content);
        } else if ((index >= 0) && (index <= this.lastPos)) {
            ContentType[] tmp = (ContentType[]) new Object[this.list.length + 1];
            for (int i = 0; i< index; i++) {
                tmp[i] = this.list[i];
            }
            tmp[index] = content;
            for (int i = index; i <= this.lastPos; i++) {
                tmp[i + 1] = this.list[i];
            }
            this.list = tmp;
            this.lastPos++;
        }
    }

    /**
     * Methode setItem(index: Ganzzahl, inhalt: Inhaltstyp) <br />
     * Der Inhalt des Elementes an der Position index wird durch den uebergebenen Inhalt ersetzt.
     *
     * @param index: Ganzzahl (int)
     * @param inhalt: Inhaltstyp
     */
    public void setItem(int index, ContentType inhalt) {
        list[index] = inhalt;
    }

    /**
     * Methode delete(index: Ganzzahl) <br />
     * Das Element an der Position index wird entfernt. Alle folgenden Elemente werden um eine Position
     * nach vorne geschoben.
     *
     * @param index: Ganzzahl (int)
     */
    public void delete(int index) {
        if (!isEmpty() && index <= lastPos) {
            ContentType[] tmp = (ContentType[]) new Object[list.length - 1];
            for (int i = 0; i < index; i++) {
                tmp[i] = list[i];
            }
            for (int i = index+1; i < list.length; i++) {
                tmp[i-1] = list[i];
            }
            lastPos--;
            list = tmp;
        }
    }

    /**
     * Methode getLength(): Ganzzahl <br />
     * Die Anzahl der Elemente der dynamischen Reihung wird zurueckgegeben.
     *
     * @return Ganzzahl (int)
     */
    public int getLength() {
        return list.length;
    }


}
