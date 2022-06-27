package view;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import controller.Desconto1;
import controller.FuncionarioController;
import controller.IDescontoINSS;
import model.Funcionario;
import util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		f1.setId(1);
		f1.setNome("Gabriel Guerra");
		f1.setSalario(2890.00f);
		IDescontoINSS desc = new Desconto1();
		desc.proximoDesconto(f1);
		System.out.println(f1);
		
		Funcionario f2 = new Funcionario();
		f2.setId(2);
		f2.setNome("Joazinho");
		f2.setSalario(2298.00f);
		desc.proximoDesconto(f2);
		System.out.println(f2);
		
		Funcionario f3 = new Funcionario();
		f3.setId(3);
		f3.setNome("Mariazinha");
		f3.setSalario(1782.00f);
		desc.proximoDesconto(f3);
		System.out.println(f3);
		
		@SuppressWarnings("unused")
		SessionFactory sf = HibernateUtil.getSessionFactory();
		FuncionarioController fCont = new FuncionarioController();
		
		try {
			fCont.salvar(f1);
			fCont.salvar(f2);
			fCont.salvar(f3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			f3.setSalario(1782f);
			desc.proximoDesconto(f3);
			fCont.modificar(f3);
			f3 = fCont.consultar(f3);
			System.out.println(f3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Funcionario> funcionarios = fCont.listar();
			funcionarios.forEach(f -> System.out.println(f));
			fCont.remover(f3);
			funcionarios = fCont.listar();
			funcionarios.forEach(f -> System.out.println(f));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
