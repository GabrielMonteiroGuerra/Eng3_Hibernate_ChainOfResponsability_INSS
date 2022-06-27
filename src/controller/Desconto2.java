package controller;

import model.Funcionario;

public class Desconto2 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		double desconto = 0.0f;
		double valorMin = 1212.00f;
		double valorMaximo = 2427.35f;
		double porcent = 0.09f;
		if(f.getSalario() > valorMin && f.getSalario() <= valorMaximo) {
			desconto = (f.getSalario() - valorMin) * porcent;
		} else if(f.getSalario() > valorMaximo) {
			desconto = (valorMaximo - valorMin) * porcent;
		}
		return (float) (f.getDescontoINSS() + desconto);
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setDescontoINSS(calculaDesconto(f));
		
		Desconto3 descF3 = new Desconto3();
		descF3.proximoDesconto(f);
	}

}
