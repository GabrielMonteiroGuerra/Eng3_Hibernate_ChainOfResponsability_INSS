package controller;

import model.Funcionario;

public class Desconto1 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		double desconto = 0.0f;
		double valorMaximo = 1212.00f;
		double porcent = 0.075f;
		if(f.getSalario() <= valorMaximo) {
			desconto = f.getSalario() * porcent;
		} else if(f.getSalario() > valorMaximo) {
			desconto = valorMaximo * porcent;
		}
		return (float) (f.getDescontoINSS() + desconto);
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setDescontoINSS(calculaDesconto(f));
		
		Desconto2 descF2 = new Desconto2();
		descF2.proximoDesconto(f);
	}

}
