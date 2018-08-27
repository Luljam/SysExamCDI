package hspm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataDataHora {
	public static String formataData(String dt) {
		String data = dt.replace("+", "").trim();
		String ano = data.substring(0, 4);
		String mes = data.substring(4, 6);
		String dia = data.substring(6, 8);

		data = dia + "/" + mes + "/" + ano;

		return data;
	}

	public static String tirarBarrasData(String dt) {
		String data = dt.replace("+", "").trim();
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		data = ano + mes + dia;
		return data;
	}

	public static String formataHora(String h) {
		String horaCompleta = h.trim();
		if (h.equals("")) {
			horaCompleta = "N/C";
		} else {
			String hora = horaCompleta.substring(0, 2);
			String minuto = horaCompleta.substring(2, 4);
			horaCompleta = hora + ":" + minuto;

		}
		return horaCompleta;
	}

	public static String calculaDiffHora(String horaIni, String horaFim) {
		String tempo = null;

		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date d1 = null;
		Date d2 = null;
		Date horasmin = null;
		if ((horaIni.equals("N/C")) || (horaFim.equals("N/C"))) {
			tempo = "N/C";
		} else {
			try {
				d1 = format.parse(horaIni);
				d2 = format.parse(horaFim);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000);
			long diffHours = diff / (60 * 60 * 1000);
			long diffHorasMin = (diffMinutes % 60);
			try {
				horasmin = format.parse(diffHours + ":" + diffHorasMin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo = DateFormat.getTimeInstance(DateFormat.SHORT).format(horasmin);
		}
		return tempo;
	}
}
