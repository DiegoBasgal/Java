public class Main {

    public static void main(String[] args) {

        FilaCircular fl1 = new FilaCircular(5); // Criando fila
        FilaCircular fl2 = new FilaCircular(5);

        fl1.insere('a'); // Inserindo elementos
        fl1.insere('c');
        fl1.insere('e');
        fl1.insere('g');
        fl1.insere('i');
        /*
        fl1.insere('k'); // Caso de fila cheia

        fl1.primeiro(); // Mostrar o primeiro
        fl1.ultimo(); // Mostrar o último

        fl1.remove(); // Remover elementos
        fl1.remove();
        fl1.remove();
        fl1.remove();
        fl1.remove();

        fl1.remove(); // Caso de fila vazia

        */
        // OPERAÇÃO DE MERGE:
        fl2.insere('b');
        fl2.insere('d');
        fl2.insere('f');
        fl2.insere('h');
        fl2.insere('j');

        fl1.merge(fl2);
    }
}
