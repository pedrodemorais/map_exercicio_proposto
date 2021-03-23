package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String localDoArquivo = "C:\\Temp\\votacao.txt";
		// Map<String, Integer> votes = new LinkedHashMap<>();

		Map<String, Integer> ListaDeVotos = new TreeMap<>();

		String linhaASerLida;

		try (BufferedReader br = new BufferedReader(new FileReader(localDoArquivo))) {
			linhaASerLida = br.readLine();

			while (linhaASerLida != null) {

				String[] campos = linhaASerLida.split(",");
				String name = campos[0];
				int contaVotos = Integer.parseInt(campos[1]);

				if (ListaDeVotos.containsKey(name)) {
					int votosAteAgora = ListaDeVotos.get(name);
					ListaDeVotos.put(name, contaVotos + votosAteAgora);

				} else
					ListaDeVotos.put(name, contaVotos);

				linhaASerLida = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}

		for (String key : ListaDeVotos.keySet()) {
			System.out.println(key + ": " + ListaDeVotos.get(key));
		}

	}

}
