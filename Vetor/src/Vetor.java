public class Vetor {
    private Object[] elementos;
    public int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }

    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (String) this.elementos[posicao];
    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean adiciona(int posicao, String elemento) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();
        // mover todos os elementos
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = (String) this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
}

class TestaVetor {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(3);
        System.out.println(vetor);
        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");

        //1 Adicionar elemento ao final do vetor
        vetor.adiciona("elemento 3");
        System.out.println(vetor);
        System.out.println("1-) " + vetor.tamanho);


        //2 Duplicar tamanho Vetor
        vetor.aumentaCapacidade();
        System.out.println(vetor);
        System.out.println("2-) " + vetor.tamanho);

        //3 Obter elemento de uma posição no vetor
        System.out.println("3-) " + vetor.busca(2));

        //4 Verificar se elemento existe na posição
        System.out.println("4-) " + vetor.busca("elemento 2"));

        //5 Adicionar elemento em qualquer posição
        vetor.adiciona(1, "teste 2");
        System.out.println("5-) " + vetor);
        System.out.println("tamanho: " + vetor.tamanho);

        //6 Remover elemento do vetor
        vetor.remove(1);
        System.out.println("6-) " + vetor);
        System.out.println("tamanho: " + vetor.tamanho);
    }
}