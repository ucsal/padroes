package ws.domore.editorfigura.builder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ws.domore.editorfigura.model.Figura;

public class ExportadorJSON implements ExportadorBuilder {

	@Override
	public void exportar(List<Figura> figuras) {
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		int size = figuras.size();

		for (int i = 0; i < size; i++) {
			JSONObject jsonObj = new JSONObject();

			try {
				jsonObj.put("X", figuras.get(i).getX());
				jsonObj.put("Y", figuras.get(i).getY());
				jsonObj.put("largura", figuras.get(i).getLargura());
				jsonObj.put("altura", figuras.get(i).getAltura());
				jsonObj.put("espessura", figuras.get(i).getShape().getBounds().width);
				jsonObj.put("cor", figuras.get(i).getCorLinha());
				jsonObj.put("preenchimento", figuras.get(i).getCorPreenchiento());

				jsonArray.put(jsonObj);
				jsonResult.put("figuras", jsonArray);

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		try {
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("figuras.json")));
			printWriter.println(jsonResult);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
