package nodos;

public class ListaLigada<T> {

    private Nodo<T> p = null;

    public void mostrarLista() {
        Nodo<T> q = p;
        while (q != null) {
            System.out.println(q.getValor());
            q = q.getLiga();
        }
    }

    public void insertarInicio(T num) {
        Nodo<T> t = new Nodo();
        t.setValor(num);
        t.setLiga(null);
        t.setLiga(p);
        p = t;
    }

    public void insertaFinal(T obj) {
        Nodo<T> q = p;
        Nodo<T> t = new Nodo<>();
        t.setValor(obj);
        t.setLiga(null);
        if (p == null) {
            p = t;
        } else {
            while (q.getLiga() != null) {
                q = q.getLiga();
            }
            q.setLiga(t);
        }
    }

    public ListaLigada<T> invertirLista() {
        ListaLigada<T> l = new ListaLigada<>();
        Nodo<T> q = p;
        while (q != null) {
            l.insertarInicio(q.getValor());
            q = q.getLiga();
        }
        return l;

    }

    public boolean buscar(T dato) {
        boolean bandera = false;
        Nodo<T> q = p;
        while (q != null) {
            if (q.getValor().equals(dato)) {
                bandera = true;

            }
            q = q.getLiga();
        }
        return bandera;
    }

    public void insertaAntesDeX(T nuevo, T referencia) {
        Nodo<T> q = p;
        Nodo<T> s = new Nodo<>();
        Nodo<T> t = new Nodo<>(nuevo);
        boolean bandera = false;

        while ((q.getValor().equals(referencia)) && (!bandera)) {
            if (q.getLiga() != null) {
                s = q;
                q = q.getLiga();
            } else {
                bandera = true;
            }
        }
        if (!bandera) {
            if (p == q) {
                t.setLiga(p);
                p = t;
            } else {
                s.setLiga(t);
                t.setLiga(q);
            }
        } else {
            System.out.println("No lo encontro");
        }
    }

    public void insertaDespuesDeX(T nuevo, T referencia) {
        boolean bandera = false;
        Nodo<T> t = new Nodo<>(nuevo);
        Nodo<T> s;
        Nodo<T> q = p;
        while ((q != null) && (!bandera)) {
            if (q.getValor().equals(referencia)) {
                bandera = true;
            } else {
                q = q.getLiga();
            }
        }
        if (bandera) {
            s = q.getLiga();
            q.setLiga(t);
            t.setLiga(s);
        }
    }

    public void dividir(Integer num) {
        int cont = 0;
        Nodo<T> q = p;
        while (q != null) {
            q = q.getLiga();
            cont++;
        }
        q = p;
        int primeraParte = cont - cont / 2;
        cont = 0;
        if (num == 1) {
            while (cont != primeraParte) {
                System.out.println(q.getValor());
                q = q.getLiga();
                cont++;
            }
        } else {
            while (cont != primeraParte) {
                q = q.getLiga();
                cont++;
            }
            while (q != null) {
                System.out.println(q.getValor());
                q = q.getLiga();
            }
        }
    }
    public void eliminarDuplicados() {
        Nodo<T> q = p;
        Nodo<T> r;
        Nodo<T> s = q;
        boolean ban;
        while (q != null && s.getLiga() != null) {
            ban = false;
            r = q;
            s = q.getLiga();
            while (s.getValor() != q.getValor() && !ban) {
                if (s.getLiga() != null) {
                    r = s;
                    s = s.getLiga();
                } else {
                    ban = true;
                }
            }
            if (!ban) {
                if (s.getLiga() != null) {
                    s = s.getLiga();
                    r.setLiga(s);
                } else {
                    r.setLiga(null);
                }
            }
            q = q.getLiga();
        }
    }
}
