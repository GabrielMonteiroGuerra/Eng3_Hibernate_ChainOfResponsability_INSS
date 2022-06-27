package controller;

import model.Funcionario;

public class Desconto3 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		double desconto = 0.0f;
		double valorMin = 2427.35f;
		double valorMaximo = 3641.03f;
		double porcent = 0.12f;
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
		
		Desconto4 descF4 = new Desconto4();
		descF4.proximoDesconto(f);
	}

}
