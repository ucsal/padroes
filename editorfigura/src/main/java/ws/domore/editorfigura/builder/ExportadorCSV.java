package ws.domore.editorfigura.builder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import ws.domore.editorfigura.model.Figura;

public class ExportadorCSV implements ExportadorBuilder{

	@Override
	public void exportar(List<Figura> figuras) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new BufferedWriter(new FileWriter("tabela-figura.csv")));
			printWriter.println("X" + "," + "Y" + "," + "LARGURA" + "," + "ALTURA" + "," + "ESPESSURA" + "," + "COR"
					+ "," + "PREENCHIMENTO");

			for (Figura figura : figuras) {
				printWriter.println(
						figura.getX() + "," + figura.getY() + "," + figura.getLargura() + 
						"," + figura.getAltura() + "," + figura.getShape().getBounds().width + 
						"," + figura.getCorLinha() + "," + figura.getCorPreenchiento());
			}
			printWriter.flush();
			printWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
