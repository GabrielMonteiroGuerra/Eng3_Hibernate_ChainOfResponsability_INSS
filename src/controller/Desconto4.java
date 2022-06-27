package controller;

import model.Funcionario;

public class Desconto4 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		double desconto = 0.0f;
		double valorMin = 3641.03f;
		double valorMaximo = 7087.22f;
		double porcent = 0.14f;
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
	}

}
