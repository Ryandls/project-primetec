package br.com.bryan.primetec.services;

import java.text.MessageFormat;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.bryan.primetec.dto.AcompanhamentoClienteDTO;
import br.com.bryan.primetec.dto.ClienteDTO;
import br.com.bryan.primetec.dto.FormularioDTO;
import br.com.bryan.primetec.entitites.Aparelho;
import br.com.bryan.primetec.entitites.Cliente;
import br.com.bryan.primetec.entitites.Defeito;
import br.com.bryan.primetec.entitites.OrdemServico;
import br.com.bryan.primetec.enuns.EnumDefeito;
import br.com.bryan.primetec.enuns.EnumEmailConfig;
import br.com.bryan.primetec.mapper.AcompanhamentoMapper;
import br.com.bryan.primetec.mapper.ClienteMapper;
import br.com.bryan.primetec.repository.ClienteRepository;
import br.com.bryan.primetec.repository.DefeitoRepository;

@Service
public class ClienteService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	ClienteRepository clienteRepository;
	
	
	
	@Autowired
	DefeitoRepository defeitoRepository;
	
	
	
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	public AcompanhamentoClienteDTO inserir(FormularioDTO formulario) {
		// TODO Auto-generated method stub

		
		Cliente cliente = clienteRepository.findByCpf(formulario.getCpf());
		
		if(cliente == null) {
			cliente = new Cliente();
			cliente.setCpf(formulario.getCpf());
			cliente.setEmail(formulario.getEmail());
			cliente.setEndereco(formulario.getEndereco());
			cliente.setCidade(formulario.getCidade());
			cliente.setNumero(formulario.getNumero());
			cliente.setNome(formulario.getNome());
			cliente.setComplemento(formulario.getComplemento());
			cliente.setTelefone(formulario.getTelefone());
		}
		
		
		System.out.println(formulario);



		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setAndamento("Em andamento");
		ordemServico.setCliente(cliente);

		Aparelho aparelho = new Aparelho();
		aparelho.setAparelho_imei(formulario.getImei());
		aparelho.setAparelho_marca(formulario.getMarca());
		aparelho.setAparelho_modelo(formulario.getModelo());
		aparelho.setDescricao(formulario.getDescricao());

		for (Long id_defeito : formulario.getChecklist()) {
			aparelho.getDefeitos().add(defeitoRepository.getById(id_defeito));
		}

		ordemServico.setAparelho(aparelho);

		cliente.getOrdemServicos().add(ordemServico);
		aparelho.getOrdemServicos().add(ordemServico);

		cliente = clienteRepository.save(cliente);
		
		try {
			this.enviarEmail(formulario, cliente);
		} catch (Exception e) {

			System.out.println("Não foi possível enviar o email para " + formulario.getEmail());
			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
		}
		
		return AcompanhamentoMapper.paraAcompanhamento(cliente);
		
	}

	public AcompanhamentoClienteDTO fetchAcompanhamento(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		return AcompanhamentoMapper.paraAcompanhamento(cliente);
	}

	private void enviarEmail(FormularioDTO formulario, Cliente cliente) throws MessagingException {
		
		List<OrdemServico> os = cliente.getOrdemServicos();
		OrdemServico ultimaOs = os.get(os.size()-1);
		

			
			MimeMessage message = emailSender.createMimeMessage();
		     
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(EnumEmailConfig.USERNAME_EMAIL.getValor());
			String[] emails = {EnumEmailConfig.USERNAME_EMAIL.getValor(), formulario.getEmail()};
			helper.setTo(emails);
//			helper.setCc("superglorial1@hotmail.com");
			helper.setSubject(MessageFormat.format("Ordem de Serviço referente ao {0} {1} ({2}) - {3} ",
					formulario.getMarca(), formulario.getModelo(), formulario.getImei(), formulario.getNome()));
			String mensagem = MessageFormat.format("\n"
					+ "      <section>\n"
					+ "\n"
					+ "        <h2>Prezado {0},</h2>\n"
					+ "        <p> Sua Ordem de Serviço com o número: {1} , foi efetuada com sucesso a loja PrimeTec</p>\n"
					+ "        <p> Seu endereço é {2}, {3}, de  {4}. </p>\n"
					+ "        <p>De acordo com o que você descreveu:</p>\n"
					+ "        <p>{5}</p>\n"
					+ "        <p>Os problemas informados foram:</p>\n"
					+ "        <ul>\n"
					+ "          [(CHECKLIST)]\n"
					+ "        </ul>\n"
					+ " <p> Logo, logo entraremos em contato.</p>"
					+ "\n"
					+ "      </section>", formulario.getNome(), 
					ultimaOs.getId_ordem_servico(),
					formulario.getEndereco(), formulario.getNumero(), formulario.getCidade(), formulario.getDescricao());
			
			
			List<Defeito> defeitos = ultimaOs.getAparelho().getDefeitos();
			String checkList = "";
			
			
			for (Defeito defeito : defeitos) {
//				String defeitoDescricao = EnumDefeito.valueOfId(defeito.getId_defeitos());
				checkList = checkList.concat(MessageFormat.format("<li>{0}</li>", defeito.getDescricao()));
			}
			
			mensagem = mensagem.replace("[(CHECKLIST)]", checkList);

			message.setContent(mensagem, "text/html; charset=utf-8");
			emailSender.send(message);
		
	}

	public ClienteDTO recuperarClientePorId(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		return cliente == null ? null : ClienteMapper.paraClienteDTO(cliente);
	}

	
}
