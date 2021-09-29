public class Cliente{
    private String nome;
    private String cpf;
    private int pontosFidelidade;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public int getPontos(){
        return pontosFidelidade;
    }
    
    public void adicionarPontos(int pontos){
    	pontosFidelidade += pontos;
    }
    
    public void removerPontos(int pontos){
    	pontosFidelidade -= pontos;
    }
}
