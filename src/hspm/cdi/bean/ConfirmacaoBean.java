package hspm.cdi.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import hspm.cdi.dao.impl.PacienteHospubDAOOpenbase;
import hspm.cdi.model.Agenda;
import hspm.cdi.model.Consulta;
import hspm.cdi.model.Especialidade;
import hspm.cdi.model.Exame;
import hspm.cdi.model.Grade;
import hspm.cdi.model.GrupoExame;
import hspm.cdi.model.Log_atendimento;
import hspm.cdi.model.Paciente;
import hspm.cdi.model.PacienteHospub;
import hspm.cdi.model.Profissional;
import hspm.cdi.model.StatusGrade;
import hspm.cdi.model.rn.AgendaRN;
import hspm.cdi.model.rn.ConsultaRN;
import hspm.cdi.model.rn.EspecialidadeRN;
import hspm.cdi.model.rn.ExameRN;
import hspm.cdi.model.rn.GradeRN;
import hspm.cdi.model.rn.Log_atendimentoRN;
import hspm.cdi.model.rn.PacienteRN;
import hspm.cdi.model.rn.ProfissionalRN;
import hspm.util.ContextoUtil;
import hspm.util.FormataDataHora;
import hspm.web.ContextoBean;

@ManagedBean
@ViewScoped
public class ConfirmacaoBean {
	private Integer codGrupo;
	private String cpf_profissional;
	private String cpf_solicitante;
	private Integer cod_especialidade;
	private Integer rh;
	private String nome_paciente;

	private Grade grade = new Grade();
	private Consulta consulta = new Consulta();
	private StatusGrade status;
	private Especialidade especialidade;
	private Paciente paciente;
	private Log_atendimento log = new Log_atendimento();

	private List<Especialidade> especialidades;
	private List<Profissional> profissionais;
	private List<Exame> exames;
	private List<Grade> grades;
	private List<Consulta> consultasMarcadas;
	private List<GrupoExame> grupos;
	private List<Agenda> agendasUnicas;
	private List<Agenda> listaAgenda;
	private List<Profissional> listaProfissionalAgenda;

	private ScheduleModel agendas;
	private ScheduleModel consultas;
	DefaultScheduleEvent evt = new DefaultScheduleEvent();

	public void salvar() {
		status = new StatusGrade();
		status.setCodigo(2);
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		String situacao = evt.getTitle();
		try {
			if (situacao.equals("Livre")) {
				grade.setCodigo(Integer.parseInt(evt.getId()));
				consulta.setNum_consulta(grade);

				consulta.setPaciente(paciente);
				consulta.setDt_consulta(evt.getStartDate());
				consulta.setStatus(status);// 2 - marcada
				consulta.setDt_cadastro(new Date());
				consulta.setUsuario(contextoBean.getUsuarioLogado());
				ConsultaRN consultaRN = new ConsultaRN();
				consultaRN.salvar(consulta);
				// Atualiza horario na grade
				Integer codigo = Integer.parseInt(evt.getId());
				grade = new Grade();
				GradeRN gradeRN = new GradeRN();
				grade = gradeRN.carregar(codigo);
				grade.setStatus(status);

				Messages.addGlobalInfo("Consulta marcada com sucesso.");
			} else if (situacao.equals("Bloqueada")) {
				Messages.addFlashGlobalError("Consulta com Data/hora bloqueada.");
			} else if (situacao.equals("Marcada")) {
				Messages.addFlashGlobalError("Consulta com Data/hora já ocupada.");
			}

			consulta = new Consulta();// limpa form
			consultas = new DefaultScheduleModel();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar marcar Consulta");
			erro.printStackTrace();
		}
	}

	public void buscarRH() throws ParseException {
		paciente = new Paciente();
		PacienteRN pacienteRN = new PacienteRN();
		this.paciente = pacienteRN.carregar(rh);

		if (paciente == null) {
			PacienteHospub pacHospub = new PacienteHospubDAOOpenbase().buscarRH(rh);
			if (pacHospub == null) {
				Messages.addFlashGlobalError("Paciente não encontrado!");
			} else {
				paciente = new Paciente();
				setNome_paciente(pacHospub.getNome());

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date data = formato.parse(FormataDataHora.formataData(pacHospub.getNascimento()));

				// importar paciente do Hospub
				paciente.setRh(pacHospub.getRh());
				paciente.setRf(pacHospub.getRf());
				paciente.setNome(pacHospub.getNome());
				paciente.setSexo(pacHospub.getSexo());
				paciente.setTelefone(pacHospub.getTelefone());
				paciente.setDt_nascimento(data);
				paciente.setDt_cadastro(new Date());
				paciente.setAtivo(true);
				pacienteRN.salvar(paciente);
				// Paciente Hospub importado
			}
		} else {
			setNome_paciente(paciente.getNome());
		}
	}

	private Calendar today(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
				calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), 0);
		return calendar;
	}

	private Date inicioConsulta(Date date) {
		Calendar t = (Calendar) today(date).clone();
		// t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE));
		t.set(Calendar.HOUR, t.get(Calendar.HOUR));
		t.set(Calendar.MINUTE, t.get(Calendar.MINUTE));
		return t.getTime();
	}

	private Date fimConsulta(Date date) {
		Calendar t = (Calendar) today(date).clone();
		// t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE));
		t.set(Calendar.HOUR, t.get(Calendar.HOUR));
		t.set(Calendar.MINUTE, t.get(Calendar.MINUTE));
		return t.getTime();
	}

	public void confirma() {
		status = new StatusGrade();
		Integer codigo = Integer.parseInt(evt.getId());
		ConsultaRN consultaRN = new ConsultaRN();
		consulta = consultaRN.buscarPorConsulta(codigo);

		if (consulta.getStatus().getCodigo() == 5) {
			Messages.addGlobalInfo("Consulta já foi confirmada.");
		} else {
			status.setCodigo(5);// 5 - realizada
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			try {
				consulta.setStatus(status);
				consulta.setUsuario(contextoBean.getUsuarioLogado());

				consultaRN.atualizar(consulta);

				grade = new Grade();
				GradeRN gradeRN = new GradeRN();
				grade = gradeRN.carregar(codigo);
				grade.setStatus(status);
				gradeRN.atualizar(grade);
				
				Messages.addGlobalInfo("Consulta confirmada.");
			} catch (Exception e) {
				Messages.addFlashGlobalError("Ocorreu um erro ao tentar confirmar Consulta");
				e.printStackTrace();
			}
		}
	}

	public void cancela() {
		status = new StatusGrade();
		Integer codigo = Integer.parseInt(evt.getId());
		ConsultaRN consultaRN = new ConsultaRN();
		consulta = consultaRN.buscarPorConsulta(codigo);

		if (consulta.getStatus().getCodigo() == 4) {
			Messages.addGlobalInfo("Consulta já foi cancelada.");
		} else {
			status.setCodigo(4);// 4 - cancelada
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			try {
				consulta.setStatus(status);
				consulta.setUsuario(contextoBean.getUsuarioLogado());

				consultaRN.atualizar(consulta);

				grade = new Grade();
				GradeRN gradeRN = new GradeRN();
				grade = gradeRN.carregar(codigo);
				grade.setStatus(status);
				gradeRN.atualizar(grade);
				
				Log_atendimentoRN logRN = new Log_atendimentoRN();
				
				log.setDt_ocorrencia(new Date());
				log.setNum_atendimento(grade.getCodigo());
				log.setOcorrencia("Cancelado");
				log.setUsuario(contextoBean.getUsuarioLogado().getNome());
				logRN.salvar(log);

				Messages.addGlobalInfo("Consulta cancelada.");
			} catch (Exception e) {
				Messages.addFlashGlobalError("Ocorreu um erro ao tentar cancelar Consulta");
				e.printStackTrace();
			}
		}
	}

	@PostConstruct
	public void lista() {
		consultas = new DefaultScheduleModel();
	}

	public void inicializarGrade() {
		// GradeRN gradeRN = new GradeRN();
		ConsultaRN consultaRN = new ConsultaRN();

		consultas = new DefaultScheduleModel();
		try {
			consultasMarcadas = consultaRN.buscarPorGrupoProfissional(codGrupo, cpf_profissional);
			// grades = gradeRN.buscarPorGrupoProfissional(codGrupo,
			// cpf_profissional);
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar Consultas");
			e.printStackTrace();
		}

		for (Consulta gd : consultasMarcadas) {
			evt = new DefaultScheduleEvent();
			evt.setStartDate(inicioConsulta(gd.getDt_consulta()));
			evt.setEndDate(fimConsulta(gd.getFim_Consulta()));
			evt.setTitle(gd.getPaciente().getNome() + " - Exame: " + gd.getExame().getDescricao());
			evt.setDescription("Consulta: " + gd.getStatus().getDescricao() + " Paciente: " + gd.getPaciente().getNome()
					+ "\n Exame: " + gd.getExame().getDescricao());
			evt.setData(gd.getNum_consulta().getCodigo());

			if (gd.getStatus().getCodigo() == 1) {
				evt.setStyleClass("emp1");// se estiver livre linha fica verde
			} else if (gd.getStatus().getCodigo() == 2) {
				evt.setStyleClass("emp2");// se estiver marcada linha fica
											// vermelha
			} else if (gd.getStatus().getCodigo() == 3) {
				evt.setStyleClass("emp3");
			} else if (gd.getStatus().getCodigo() == 4) {
				evt.setStyleClass("emp4");
			}else if (gd.getStatus().getCodigo() == 5) {
				evt.setStyleClass("emp5");
			}
			consultas.addEvent(evt);
			evt.setId(gd.getNum_consulta().getCodigo().toString());
		}
	}

	public DefaultScheduleEvent getEvt() {
		return evt;
	}

	public void setEvt(DefaultScheduleEvent evt) {
		this.evt = evt;
	}

	public void onEventSelect(SelectEvent selectEvent) {
		evt = (DefaultScheduleEvent) selectEvent.getObject();
	}
	// Getters and Setters

	public Integer getRh() {
		return rh;
	}

	public List<GrupoExame> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoExame> grupos) {
		this.grupos = grupos;
	}

	public List<Agenda> getAgendasUnicas() {
		if (this.agendasUnicas == null) {
			AgendaRN agendaRN = new AgendaRN();
			this.agendasUnicas = agendaRN.listarDistinct();
		}
		return agendasUnicas;
	}

	public void setAgendasUnicas(List<Agenda> agendasUnicas) {
		this.agendasUnicas = agendasUnicas;
	}

	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public List<Profissional> getListaProfissionalAgenda() {
		if (codGrupo != null) {
			this.listaProfissionalAgenda = new ArrayList<>();
			ProfissionalRN profissionalRN = new ProfissionalRN();
			this.listaProfissionalAgenda = profissionalRN.listarProfAgenda(codGrupo);
		}
		return listaProfissionalAgenda;
	}

	public void setListaProfissionalAgenda(List<Profissional> listaProfissionalAgenda) {
		this.listaProfissionalAgenda = listaProfissionalAgenda;
	}

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getCpf_profissional() {
		return cpf_profissional;
	}

	public void setCpf_profissional(String cpf_profissional) {
		this.cpf_profissional = cpf_profissional;
	}

	public String getCpf_solicitante() {
		return cpf_solicitante;
	}

	public void setCpf_solicitante(String cpf_solicitante) {
		this.cpf_solicitante = cpf_solicitante;
	}

	public Integer getCod_especialidade() {
		return cod_especialidade;
	}

	public void setCod_especialidade(Integer cod_especialidade) {
		this.cod_especialidade = cod_especialidade;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public ScheduleModel getAgendas() {
		return agendas;
	}

	public void setAgendas(ScheduleModel agendas) {
		this.agendas = agendas;
	}

	public ScheduleModel getConsultas() {
		return consultas;
	}

	public void setConsultas(ScheduleModel consultas) {
		this.consultas = consultas;
	}

	public void setRh(Integer rh) {
		this.rh = rh;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Especialidade> getEspecialidades() {
		if (this.especialidades == null) {
			EspecialidadeRN especialidadeRN = new EspecialidadeRN();
			this.especialidades = especialidadeRN.listar();
		}
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Profissional> getProfissionais() {
		if (this.profissionais == null) {
			ProfissionalRN profissionalRN = new ProfissionalRN();
			this.profissionais = profissionalRN.listar();
		}
		return this.profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	public List<Exame> getExames() {
		if (codGrupo != null) {
			this.exames = new ArrayList<>();
			ExameRN exameRN = new ExameRN();
			this.exames = exameRN.buscarPorGrupo(codGrupo);
		}
		return this.exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public StatusGrade getStatus() {
		return status;
	}

	public void setStatus(StatusGrade status) {
		this.status = status;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Consulta> getConsultasMarcadas() {
		return consultasMarcadas;
	}

	public void setConsultasMarcadas(List<Consulta> consultasMarcadas) {
		this.consultasMarcadas = consultasMarcadas;
	}

	public Log_atendimento getLog() {
		return log;
	}

	public void setLog(Log_atendimento log) {
		this.log = log;
	}
	
	

}
