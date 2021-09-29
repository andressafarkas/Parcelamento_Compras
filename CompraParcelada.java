import java.util.Scanner;

public class CompraParcelada {
    
    Scanner t = new Scanner(System.in);
    
    private Cliente c;
    private Produto p;
    private int numeroParcelas;
    private int parcelasPagas;
    private double valorTotalPago;
    private int juros;
    private double multaDiaria;
    private double saldoDevedor;
    
    public CompraParcelada(Cliente c1, Produto p1, int numeroParcelas, int juros){
    	if (numeroParcelas > 10 || numeroParcelas < 2) {
      	  	System.out.println("Número de parcelas inválidas!"); // Verifica se o numero de parcelas está dentro do limite determinado
        }else{
        	c = c1;
        	p = p1;
  	      	this.numeroParcelas = numeroParcelas;
  	      	this.juros = juros;
  	      	saldoDevedor = p.getPreco() + ((p.getPreco() / 100) * juros);
        }
    }
    
    private double arredondar(double valor) {
    	return Math.round(valor * 100.0)/100.0; // mostra o valor double com duas casas decimais
    }
    
    public double calculaValorComJuros (double valor, double juros) {
    	return valor + ((valor / 100) * juros); // Calculo do juros
    }
    
    public int calculaPontosFidelidade (double valorParcela, double valorPago) {
    	double valorExtra = valorPago - valorParcela;
    	int resultado = (int) valorExtra / 4; // Retorna o valor inteiro da divisão
    	return (resultado);
    }
    
    public int getQtdParcelasRestantes() {
    	return(numeroParcelas - parcelasPagas);
    }

    public double getValorProximaParcela() {
    	double valorProximaParcela = getSaldoDevedor() / getQtdParcelasRestantes();
    	return arredondar(valorProximaParcela);
    }
    
    public int fazerPagamento(double valorPago) {
    	if (valorPago == getValorProximaParcela()) {
    		parcelasPagas ++;
    		valorTotalPago += valorPago;
    		saldoDevedor -= valorPago;
    		saldoDevedor += (saldoDevedor / 100) * juros;
    		return (0);
    	}else if (valorPago < getValorProximaParcela()) {
    		return (1);
    	}else if (valorPago > saldoDevedor) {
    		return(2);
    	}else if (valorPago > getValorProximaParcela()) {
    		int pontos  = calculaPontosFidelidade(getValorProximaParcela(), valorPago);
    		c.adicionarPontos(pontos);
    		parcelasPagas ++;
    		valorTotalPago += valorPago;
    		saldoDevedor -= valorPago;
    		saldoDevedor += (saldoDevedor / 100) * juros;
    		return (0);
    	}else {
    		return(3);
    	}
    }
    
    public void imprimeRelatorio() {
    	System.out.println("Comprador: " + c.getNome() + " (CPF: " + c.getCpf() + ")");
    	System.out.println("Pontos de Fidelidade: " + c.getPontos());
    	System.out.println("Produto: " + p.getNome());
    	System.out.println("Valor do Produto: R$ " + p.getPreco());
    	System.out.println("Comprado em " + numeroParcelas + " parcelas");
    	System.out.println("Valor total pago até o momento: " + valorTotalPago);
    	System.out.println("Número de parcelas restantes: " + (numeroParcelas - parcelasPagas));
    	System.out.println("Valor da próxima parcela: " + getValorProximaParcela());
    	System.out.println("Saldo devedor: " + saldoDevedor);
    }
    
    public int getNumeroParcelasTotal() {
    	return (numeroParcelas);
    }
    
    public int getNumeroParcelasPagas() {
    	return (parcelasPagas);
    }
    
    public double getSaldoDevedor() {
    	return (arredondar(saldoDevedor));
    }
    
    public double getValorJahPago() {
    	return (valorTotalPago);
    }
    
    public double getTaxaJuros() {
    	return (juros);
    }
}
