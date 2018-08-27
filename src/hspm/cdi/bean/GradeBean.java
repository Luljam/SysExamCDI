package hspm.cdi.bean;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
//import org.primefaces.model.DefaultScheduleEvent;
//import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import hspm.cdi.model.Agenda;
import hspm.cdi.model.Grade;
import hspm.cdi.model.GrupoExame;
import hspm.cdi.model.Profissional;
import hspm.cdi.model.StatusGrade;
import hspm.cdi.model.rn.AgendaRN;
import hspm.cdi.model.rn.GradeRN;
import hspm.cdi.model.rn.GrupoExameRN;
import hspm.cdi.model.rn.ProfissionalRN;
import hspm.util.ContextoUtil;
import hspm.web.ContextoBean;


@ViewScoped
@ManagedBean(name = "gradeBean")
public class GradeBean {

	// private Integer codGrupo;
	// private Integer codExame;

	private Grade grade = new Grade();
	private Agenda agenda;
	private ScheduleModel agendas;

	private List<Grade> grades;
	private List<GrupoExame> grupos;
	// private List<Exame> exames;
	private List<Profissional> profissionais;

	// private List<SelectItem> itensGrupos;
	// private List<SelectItem> itensExames;

	private List<String> diasdaSemana;

	private Date dt_inicio_agenda;
	private Date dt_fim_agenda;
	private Integer num_consultas_periodo;
	private Integer duracao_consulta;

	public List<String> getDiasdaSemana() {
		return diasdaSemana;
	}

	public void setDiasdaSemana(List<String> diasdaSemana) {
		this.diasdaSemana = diasdaSemana;
	}

	public Integer getDuracao_consulta() {
		return duracao_consulta;
	}

	public void setDuracao_consulta(Integer duracao_consulta) {
		this.duracao_consulta = duracao_consulta;
	}

	public Integer getNum_consultas_periodo() {
		return num_consultas_periodo;
	}

	public void setNum_consultas_periodo(Integer num_consultas_periodo) {
		this.num_consultas_periodo = num_consultas_periodo;
	}

	// public Integer getCodExame() {
	// return codExame;
	// }
	//
	// public void setCodExame(Integer codExame) {
	// this.codExame = codExame;
	// }

	public Date getDt_inicio_agenda() {
		return dt_inicio_agenda;
	}

	public void setDt_inicio_agenda(Date dt_inicio_agenda) {
		this.dt_inicio_agenda = dt_inicio_agenda;
	}

	public Date getDt_fim_agenda() {
		return dt_fim_agenda;
	}

	public void setDt_fim_agenda(Date dt_fim_agenda) {
		this.dt_fim_agenda = dt_fim_agenda;
	}

	// public Integer getCodGrupo() {
	// return codGrupo;
	// }
	//
	// public void setCodGrupo(Integer codGrupo) {
	// this.codGrupo = codGrupo;
	// }

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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

	public List<GrupoExame> getGrupos() {
		if (this.grupos == null) {
			GrupoExameRN grupoExameRN = new GrupoExameRN();
			this.grupos = grupoExameRN.listar();
		}
		return grupos;
	}

	public void setGrupos(List<GrupoExame> grupos) {
		this.grupos = grupos;
	}

	// public List<Exame> getExames() {
	// if (codGrupo != null) {
	// this.exames = new ArrayList<>();
	// ExameRN exameRN = new ExameRN();
	// this.exames = exameRN.buscarPorGrupo(codGrupo);
	// }
	// return this.exames;
	// }
	//
	// public void setExames(List<Exame> exames) {
	// this.exames = exames;
	// }

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

	// teste de data e hora
	private Calendar today(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
				calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), 0);

		return calendar;
	}

	// private Date inicioConsulta(Date date) {
	// Calendar t = (Calendar) today(date).clone();
	// // t.set(Calendar.AM_PM, Calendar.PM);
	// t.set(Calendar.DATE, t.get(Calendar.DATE));
	// t.set(Calendar.HOUR, t.get(Calendar.HOUR));
	// t.set(Calendar.MINUTE, t.get(Calendar.MINUTE));
	//
	// return t.getTime();
	// }

	// método para incrementar tempo em hora entre as consultas
	private Date incrementaMinutos(Date date, Integer tempo) {
		Calendar t = (Calendar) today(date).clone();
		// t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE));
		t.set(Calendar.HOUR, t.get(Calendar.HOUR));
		t.set(Calendar.MINUTE, t.get(Calendar.MINUTE) + tempo);

		return t.getTime();
	}

	// método para adicionar 1 dia na data
	private Date incrementaDia(Date date) {
		Calendar t = (Calendar) today(date).clone();
		// t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, t.get(Calendar.HOUR));
		t.set(Calendar.MINUTE, t.get(Calendar.MINUTE));

		return t.getTime();
	}

	// método para zerar apenas a hora
	public static Date getZeroTimeDate(Date fecha) {
		Date res = fecha;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		res = calendar.getTime();

		return res;
	}

	
	// public List<SelectItem> getItensGrupos() {
	// this.itensGrupos = new ArrayList<>();
	// GrupoExameRN grupoExameRN = new GrupoExameRN();
	// List<GrupoExame> grupos = grupoExameRN.listar();
	//
	// itensGrupos.clear();
	//
	// for (GrupoExame ge : grupos) {
	// SelectItem selectItens = new SelectItem(ge.getCodigo(),
	// ge.getDescricao());
	// this.itensGrupos.add(selectItens);
	// }
	// return itensGrupos;
	// }
	//
	// public void setItensGrupos(List<SelectItem> itensGrupos) {
	// this.itensGrupos = itensGrupos;
	// }

	// public List<SelectItem> getItensExames() {
	// if (codGrupo != null) {
	// this.itensExames = new ArrayList<>();
	// ExameRN exameRN = new ExameRN();
	// List<Exame> exames = exameRN.buscarPorGrupo(codGrupo);
	// itensGrupos.clear();
	// for (Exame exm : exames) {
	// SelectItem selectItens = new SelectItem(exm.getCodigo(),
	// exm.getDescricao());
	// this.itensExames.add(selectItens);
	// }
	// } else {
	// itensExames = new ArrayList<>();
	// }
	// return itensExames;
	// }

	// public void setItensExames(List<SelectItem> itensExames) {
	// this.itensExames = itensExames;
	// }

	@SuppressWarnings("deprecation")
	public void salvar() {
		// grade = new Grade();
		int total = 0;
		// Gravar agenda
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		agenda = new Agenda();
		agenda.setTipo(grade.getTipo());
		agenda.setDataCricacao(new Date());
		agenda.setDataInicio(dt_inicio_agenda);
		agenda.setDataFinal(dt_fim_agenda);

		List<String> diasSemana = diasdaSemana;
		String semanaCommaSeparated = String.join(",", diasSemana);
		agenda.setDiasSemana(semanaCommaSeparated);
		agenda.setDuracao(duracao_consulta);
		agenda.setGrupo(grade.getGrupo());
		agenda.setVagas(getNum_consultas_periodo());
		agenda.setProfissional(grade.getProfissional());
		agenda.setUsuario(contextoBean.getUsuarioLogado());
		try {
			AgendaRN agendaRN = new AgendaRN();
			agendaRN.salvar(agenda);

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gravar Agenda");
			erro.printStackTrace();
		}
		// fim da agenda

		grade.setDataConsulta(getDt_inicio_agenda());// set inicio da data

		StatusGrade status = new StatusGrade();
		status.setCodigo(1);

		grade.setStatus(status);
		grade.setAgenda(agenda);
		grade.setTempo(duracao_consulta);

		// Zera apenas a hora da data inicial
		Date dtIni = getZeroTimeDate(dt_inicio_agenda);

		// loop até a data final da agenda
		while (dtIni.compareTo(dt_fim_agenda) <= 0) {
			// verificar dia da semana The returned value (0 = Sunday, 1 =
			// Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 =
			// Saturday)
			for (int i = 1; i <= getNum_consultas_periodo(); i++) {
				for (String semana : diasdaSemana) {
					if (getDt_inicio_agenda().getDay() == Integer.parseInt(semana)) {
						// inicio da contagem
						total++;
						try {
							GradeRN gradeRN = new GradeRN();
							gradeRN.salvar(grade);
						} catch (RuntimeException erro) {
							Messages.addFlashGlobalError("Ocorreu um erro ao gerar Grade de Atendimento");
							erro.printStackTrace();
						}
						// fim teste de gravação
						grade.setDataConsulta(incrementaMinutos(grade.getDataConsulta(), getDuracao_consulta()));
					}
				}
			}
			grade.setDataConsulta(incrementaDia(getDt_inicio_agenda()));
			// setar inicio da consulta em 1 dia setar proxima data de inicio da
			// consulta
			setDt_inicio_agenda(incrementaDia(getDt_inicio_agenda()));
			// incrementa dia para auxiliar o loop while
			dtIni = incrementaDia(dtIni);
		}
		grade = new Grade();
		setDt_inicio_agenda(null);
		setDt_fim_agenda(null);
		setDuracao_consulta(null);
		setNum_consultas_periodo(null);
		setDiasdaSemana(null);
		System.out.println("\n" + total + " consultas geradas.");
		Messages.addGlobalInfo(total + " consultas geradas.");
	}

}
