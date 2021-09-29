public class Loja{ 
	public static void main(String[] args){ 
		
		Cliente c = new Cliente("Fulano", "08276523388"); 
		
		Produto p = new Produto("Xbox One S", 2900); 
		
		CompraParcelada compra = new CompraParcelada(c, p, 10, 5);
  
		  System.out.println("[Teste #01] Saldo devedor inicial");
		  
		  if(compra.getSaldoDevedor() == 3045){ 
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o construtor da classe CompraParcelada, na definição inicial do atributo saldoDevedor\n"); 
			  System.out.println("  Resultado esperado: R$ 3045.00");
			  System.out.println("  Resultado obtido: " + compra.getSaldoDevedor()); }
			  
		  System.out.println("[Teste #02] Cálculo do valor da próxima parcela");
		  if(compra.getValorProximaParcela() == 304.5){ 
			  System.out.println("  [OK]\n");
		  } else{ 
			  System.out.println("  [NOK] Revise o método getValorParcela()\n");
			  System.out.println("  Resultado esperado: R$ 304.50");
			  System.out.println("  Resultado obtido: " + compra.getValorProximaParcela());
		  }
		  
		  System.out.println("[Teste #03] Cálculo de valor com juros");
		  if(compra.calculaValorComJuros(200, 10) == 220){
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o método calculaValorComJuros()\n");
			  System.out.println("  Resultado esperado: 220");
			  System.out.println("  Resultado obtido: " + compra.calculaValorComJuros(200, 10)); 
		  }
		  
		  System.out.println("[Teste #04] Cálculo da quantidade de parcelas restantes"); 
		  if(compra.getQtdParcelasRestantes() == 10){
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o método getQtdParcelasRestantes()\n");
			  System.out.println("  Resultado esperado: 10");
			  System.out.println("  Resultado obtido: " + compra.getQtdParcelasRestantes()); 
		  }
		  
		  //compra.imprimeRelatorio();
		  
		  System.out.println("[Teste #05] Pagamento da primeira parcela (exato valor devido)");
		  if(compra.fazerPagamento(304.5) == 0){ 
			  System.out.println("  [OK]\n"); }
		  else{ 
			  System.out.println("  [NOK] Revise o método fazerPagamento() quando se paga o exato valor da parcela\n"); 
			  }
		  
		  //compra.imprimeRelatorio();
		  
		  System.out.println("[Teste #06] Cálculo do valor da próxima parcela");
		  if(compra.getValorProximaParcela() == 319.73){
			  System.out.println("  [OK]\n"); } 
		  else{ 
			  System.out.println("  [NOK] Revise o método getValorParcela(), no cálculo da segunda parcela\n"); 
			  System.out.println("  Resultado esperado: R$ 319.73");
			  System.out.println("  Resultado obtido: R$ " + compra.getValorProximaParcela()); }
		  
		  	  System.out.println("[Teste #07] Pagamento de um valor maior que o saldo");
		  if(compra.fazerPagamento(3000) == 2){ 
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o método fazerPagamento() quando se paga um valor maior que o saldo devedor\n"); }
		  
		  System.out.println("[Teste #08] Pagamento de um valor menor que a parcela devida");
		  if(compra.fazerPagamento(200) == 1){ 
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o método fazerPagamento() quando se paga um valor menor que a parcela devida\n");
		  }
		  
		  System.out.println("[Teste #09] Pagamento de um valor maior que a parcela devida");
		  if(compra.fazerPagamento(450) == 0){ 
			  System.out.println("  [OK]\n"); 
		  } else{
			  System.out.println("  [NOK] Revise o método fazerPagamento() quando se paga um valor maior que a parcela devida\n"); 
		  }
		  
		  System.out.println("[Teste #10] Cálculo de pontos de fidelidade");
		  if(c.getPontos() == 32){ 
			  System.out.println("  [OK]\n"); 
		  } else{ System.out.println("  [NOK] Revise o método fazerPagamento() quando se paga um valor maior que a parcela devida, quando calculamos os pontos de fidelidade e atualizamos no cadastro do cliente\n");
		 }
		  
		  System.out.println("[Teste #11] Saldo devedor"); 
		  
		  if(compra.getSaldoDevedor() == 2548.90){ 
			  System.out.println("  [OK]\n"); 
		  } else{ 
			  System.out.println("  [NOK] Revise o método fazerPagamento(), ao calcular o saldo devedor\n"); 
			  System.out.println("  Resultado esperado: R$ 2548.90");
			  System.out.println("  Resultado obtido: " + compra.getSaldoDevedor()); }
		  }
	  }
	 