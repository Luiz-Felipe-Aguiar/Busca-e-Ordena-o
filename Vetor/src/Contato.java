//Atv 1 -)

public class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
    }
}

class VetorContatos {
    private Contato[] contatos;
    private int tamanho;

    public VetorContatos() {
        contatos = new Contato[10];
        tamanho = 0;
    }

    // 1. Adicionar elemento ao final do vetor
    public void adicionarContato(Contato contato) {
        if (tamanho == contatos.length) {
            duplicarTamanho();
        }
        contatos[tamanho++] = contato;
    }

    // 2. Verificar a quantidade de elementos do vetor
    public int quantidadeContatos() {
        return tamanho;
    }

    // 3. Imprimir elementos do vetor
    public void imprimirContatos() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(contatos[i]);
        }
    }

    // 4. Obter elemento de uma posição do vetor
    public Contato obterContato(int index) {
        if (index >= 0 && index < tamanho) {
            return contatos[index];
        }
        return null;
    }

    // 5. Verificar se elemento existe no vetor
    public boolean existeContato(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].equals(contato)) {
                return true;
            }
        }
        return false;
    }

    // 6. Adicionar elemento em qualquer posição do vetor
    public void adicionarContato(int index, Contato contato) {
        if (index >= 0 && index <= tamanho) {
            if (tamanho == contatos.length) {
                duplicarTamanho();
            }
            for (int i = tamanho; i > index; i--) {
                contatos[i] = contatos[i - 1];
            }
            contatos[index] = contato;
            tamanho++;
        }
    }

    // 7. Duplicar o tamanho do vetor
    private void duplicarTamanho() {
        Contato[] novoArray = new Contato[contatos.length * 2];
        System.arraycopy(contatos, 0, novoArray, 0, contatos.length);
        contatos = novoArray;
    }

    // 8. Remover elemento do vetor
    public void removerContato(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].equals(contato)) {
                for (int j = i; j < tamanho - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[--tamanho] = null;
                break;
            }
        }
    }

    // 9. Pesquisa por nome
    public Contato pesquisarPorNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        return null;
    }

    // 10. Pesquisa por e-mail
    public Contato pesquisarPorEmail(String email) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getEmail().equalsIgnoreCase(email)) {
                return contatos[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        VetorContatos contato = new VetorContatos();
        Contato contato1 = new Contato("João", "123456789", "joao@example.com");
        Contato contato2 = new Contato("Maria", "987654321", "maria@example.com");

        contato.adicionarContato(contato1);
        contato.adicionarContato(contato2);

        System.out.println("Quantidade de contatos: " + contato.quantidadeContatos());
        contato.imprimirContatos();

        Contato contatos = contato.obterContato(1);
        System.out.println("Contato na posição 1: " + contato);

        System.out.println("Contato existe: " + contato.existeContato(contato1));

        Contato contato3 = new Contato("Pedro", "555555555", "pedro@example.com");
        contato.adicionarContato(1, contato3);
        contato.imprimirContatos();

        contato.duplicarTamanho();
        System.out.println("Capacidade do vetor duplicada.");

        contato.removerContato(contato1);
        contato.imprimirContatos();

        // Teste de pesquisa por nome
        Contato contatoPesquisadoPorNome = contato.pesquisarPorNome("Maria");
        System.out.println("Contato pesquisado por nome 'Maria': " + contatoPesquisadoPorNome);

        // Teste de pesquisa por e-mail
        Contato contatoPesquisadoPorEmail = contato.pesquisarPorEmail("pedro@example.com");
        System.out.println("Contato pesquisado por e-mail 'pedro@example.com': " + contatoPesquisadoPorEmail);
    }
}


