package br.ufpe.portarias;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufpe.portarias.domain.Atividade;
import br.ufpe.portarias.domain.Cargo;
import br.ufpe.portarias.domain.Nivel;
import br.ufpe.portarias.domain.NumeroPortaria;
import br.ufpe.portarias.domain.UnidadeOrganizacional;
import br.ufpe.portarias.domain.Usuario;
import br.ufpe.portarias.domain.enums.Perfil;
import br.ufpe.portarias.repositories.AtividadeRepository;
import br.ufpe.portarias.repositories.CargoRepository;
import br.ufpe.portarias.repositories.NivelRepository;
import br.ufpe.portarias.repositories.NumeroPortariaRepository;
import br.ufpe.portarias.repositories.UnidadeRepository;
import br.ufpe.portarias.repositories.UsuarioRepository;

@SpringBootApplication
public class PortariasApplication implements CommandLineRunner{
	
	@Autowired
	private AtividadeRepository aRep;
	
	@Autowired
	private NivelRepository nRep;
	
	@Autowired
	private UnidadeRepository uRep;
	
	@Autowired
	private CargoRepository cRep;
	
	@Autowired
	private UsuarioRepository userRep;
	
	@Autowired
	private NumeroPortariaRepository numeroRep;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(PortariasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Atividade a = new Atividade(null, "CHEFE");
		Atividade b = new Atividade(null, "SECRETÁRIO");
		Atividade c = new Atividade(null, "COORDENADOR");
		Atividade d = new Atividade(null, "DIRETOR");
		
		aRep.saveAll(Arrays.asList(a, b, c, d));
		
		Nivel nivel1 = new Nivel(null, "FG-1");
		nRep.saveAll(Arrays.asList(nivel1));
		
		UnidadeOrganizacional unidade1 = new UnidadeOrganizacional(null, "CCEN");
		UnidadeOrganizacional unidade2 = new UnidadeOrganizacional(null, "CCSA");
		UnidadeOrganizacional unidade3 = new UnidadeOrganizacional(null, "CIN");
		UnidadeOrganizacional unidade4 = new UnidadeOrganizacional(null, "GABINETE DO REITOR");
		UnidadeOrganizacional unidade5 = new UnidadeOrganizacional(null, "PROGEPE");
		uRep.saveAll(Arrays.asList(unidade1, unidade2,unidade3, unidade4, unidade5));
		
		Cargo cargo1 = new Cargo(null, d, nivel1, unidade1);
		
		Cargo cargo2 = new Cargo(null, a, nivel1, unidade2);
		
		Cargo cargo3 = new Cargo(null, c, nivel1, unidade3);
		
		cRep.saveAll(Arrays.asList(cargo1, cargo2, cargo3));
		
		Usuario user = new Usuario(null, "gabriel", "gabrielveloso2@gmail.com",pe.encode("123"));		
		user.addPerfil(Perfil.CLIENTE);
		
		Usuario user2 = new Usuario(null, "gabriel", "gava@gmail.com",pe.encode("123"));
		user2.addPerfil(Perfil.ADMIN);
		user2.addPerfil(Perfil.CLIENTE);
		
		userRep.saveAll(Arrays.asList(user, user2));
		
		NumeroPortaria numero = new NumeroPortaria(null, 1, 2021, user, "SFC");
		numeroRep.save(numero);
		
		
	}

}
