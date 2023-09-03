/* 
Imagine que você tem 1 procedimento que consome muito tempo do processador, vamos fazer um cálculo que faz consultas a um Web Service.

A solução então é fazer com que esse procedimento seja executado ao mesmo tempo em que o usuário está realizando o cadastro, o procedimento também é executado.

Iremos criar uma Thread para um bloco específico de código, através da Classe java.lang.Thread
 */

public void calculaTotalRecebido () {
	new Thread() {
		
		@Override
		public void run () {
			//Recebe aproximadamente 70mil registros
			List<Historico Recebimento> recebidos = getListRecebimentos();
			Integer soma = 0;
			
			for(HistoricoRecebimento h1: recebidos){
				soma = soma + recebidos.getValorRecebido();
			}
			
			Integer porcentagemImposto = getReausteAtualFromWebService ();
			soma = soma + ((porcentagemImposto/100)*soma);
			
			retornaParaWebServiceValorTotal(soma);
		}
	}.start();
		/*
		Quando fazemos o “.start();” já estamos iniciando o processamento paralelo, e liberando o programa para executar qualquer outra thread.
		*/
}