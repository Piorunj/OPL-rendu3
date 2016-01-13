package fil.iagl.idl.rendu3;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.maven.shared.invoker.MavenInvocationException;

import fil.iagl.idl.rendu3.entite.Resultat;
import fil.iagl.idl.rendu3.maven.MavenRunner;
import fil.iagl.idl.rendu3.xmlparser.XMLParser;

public class App {
	private static final String INITIAL_PATH = "C:/workspace/IntroClassJava/dataset/smallest/1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9/003";
	private static final String CURRENT_PATH = "C:/workspace/IntroClassJavaCpy/dataset/smallest/1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9/003";

	// [------------------------ ASTOR ------------------------]
	// -srcjavafolder
	// C:\workspace\IntroClassJavaCpy\dataset\syllables\2af3c4163b40679ef94bbbbc863c4fa3785c6e164281f5e8850d9e4ffa387e5b162ceb37449ecca33961ff162d861c8d98ff702e723755b6c37c95d5cfaf1c40\003\src\main\java
	// -srctestfolder
	// C:\workspace\IntroClassJavaCpy\dataset\syllables\2af3c4163b40679ef94bbbbc863c4fa3785c6e164281f5e8850d9e4ffa387e5b162ceb37449ecca33961ff162d861c8d98ff702e723755b6c37c95d5cfaf1c40\003\src\test\java
	// -binjavafolder target\classes
	// -bintestfolder target\test-classes
	// -failing introclassJava.syllables_2af3c416_003WhiteboxTest
	// -dependencies examples/Lang-issue-428/lib/junit-4.7.jar
	// -location
	// C:\workspace\IntroClassJavaCpy\dataset\syllables\2af3c4163b40679ef94bbbbc863c4fa3785c6e164281f5e8850d9e4ffa387e5b162ceb37449ecca33961ff162d861c8d98ff702e723755b6c37c95d5cfaf1c40\003
	// -package introclassJava

	// [------------------------ NOPOL ------------------------]
	// -m repair
	// -e condition
	// -y smt
	// -o angelic
	// -s
	// C:\workspace\IntroClassJava\dataset\smallest\1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9\003\src\main\java;C:\workspace\IntroClassJava\dataset\smallest\1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9\003\src\test\java
	// -c
	// C:\workspace\IntroClassJava\dataset\smallest\1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9\003\target\classes;C:\workspace\IntroClassJava\dataset\smallest\1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9\003\target\test-classes;C:\Users\wokei\.m2\repository\junit\junit\4.11\junit-4.11.jar
	// -p C:\workspace\z3-4.3.2-x64-win\bin\z3.exe

	public static void main(String[] args) throws Exception {

		Map<String, Resultat> result = new HashMap<>();
		Resultat resultGlobal = new Resultat();

		FileUtils.deleteDirectory(new File(CURRENT_PATH));
		FileUtils.copyDirectory(new File(INITIAL_PATH), new File(CURRENT_PATH));

		// try {
		// MavenRunner.cleanCompileTest(INITIAL_PATH + "\\pom.xml");
		// // MavenRunner.clean(revision+"\\pom.xml");
		//
		// } catch (MavenInvocationException e) {
		// e.printStackTrace();
		// }
		//
		// result.put(INITIAL_PATH, new Resultat());
		// XMLParser.readSurefireReport(new File(INITIAL_PATH +
		// "/target/surefire-reports"), result.get(INITIAL_PATH));
		//
		// Resultat max = result.get(INITIAL_PATH);
		// Resultat courant = result.get(INITIAL_PATH);
		// int cpt = 0;
		// while (!courant.isBetterThan(max)) {
		// System.out.println("TOUR DE BOUCLE NUMERO : " + ++cpt);
		// String[] spoonArgs = { "-i", CURRENT_PATH + "/src/main/java/", "-p",
		// "fil.iagl.idl.rendu3.processor.QuantitySwapProcessor", "-o",
		// CURRENT_PATH + "/src/main/java" };
		// Launcher.main(spoonArgs);
		//
		// try {
		// MavenRunner.cleanCompileTest(CURRENT_PATH + "\\pom.xml");
		// // MavenRunner.clean(revision+"\\pom.xml");
		//
		// } catch (MavenInvocationException e) {
		// e.printStackTrace();
		// }
		//
		// result.put(CURRENT_PATH, new Resultat());
		// XMLParser.readSurefireReport(new File(CURRENT_PATH +
		// "/target/surefire-reports"), result.get(CURRENT_PATH));
		//
		// if (result.get(CURRENT_PATH).isBetterThan(max)) {
		// max = result.get(CURRENT_PATH);
		// } else {
		// // FileUtils.deleteDirectory(new
		// // File("C:/workspace/IntroClassJavaCpy/.git"));
		// FileUtils.deleteDirectory(new File(CURRENT_PATH));
		// FileUtils.copyDirectory(new File(INITIAL_PATH), new
		// File(CURRENT_PATH));
		// }
		//
		// System.out.println("INITIAL ==> " + courant);
		// System.out.println("MAX ==> " + max);
		//
		// }

		// try {
		// MavenRunner.cleanCompileTest(
		// "C:/workspace/IntroClassJava/dataset/smallest/1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9/003/pom.xml");
		// //
		// MavenRunner.clean("C:/workspace/IntroClassJava/dataset/smallest/1b31fa5c50f7725ce468ebf24282f2d080a83aed87e4ee35522ae7710c8e0136bc263cc460b8ec7bf2c3519cb59af4a138e114d36541515b2609ab56ad2b8ee9/003/pom.xml");
		//
		// } catch (MavenInvocationException e) {
		// e.printStackTrace();
		// }

		// liste des différents projets
		Set<File> projets = new HashSet<>();
		for (File projet : new File("C:/workspace/IntroClassJava/dataset").listFiles(new DirectoryFilter())) {
			if (projet.isDirectory())
				projets.add(projet);
		}
		for (File projet : projets) {
			// liste des commits des différents étudiants
			for (File commit : projet.listFiles(new DirectoryFilter())) {
				// liste des différentes révisions
				for (File revision : commit.listFiles()) {
					File source = new File(
							new File(revision.getAbsolutePath() + "/src/main/java/introclassJava").list()[0]);
					System.out.println("Revision : " + revision);
					try {
						MavenRunner.cleanCompileTest(revision + "\\pom.xml");
						// MavenRunner.clean(revision+"\\pom.xml");

						System.out.println("Path to pom : " + revision + "\\pom.xml");
						result.put(revision.toString(), new Resultat());
						XMLParser.readSurefireReport(new File(revision + "/target/surefire-reports"),
								result.get(revision.toString()));
						resultGlobal.setBlackFail(
								resultGlobal.getBlackFail() + result.get(revision.toString()).getBlackFail());
						resultGlobal.setBlackSuccess(
								resultGlobal.getBlackSuccess() + result.get(revision.toString()).getBlackSuccess());
						resultGlobal.setWhiteFail(
								resultGlobal.getWhiteFail() + result.get(revision.toString()).getWhiteFail());
						resultGlobal.setWhiteSuccess(
								resultGlobal.getWhiteSuccess() + result.get(revision.toString()).getWhiteSuccess());
					} catch (MavenInvocationException e) {
						e.printStackTrace();
					}

				}
			}
		}
		System.out.println(resultGlobal);
	}

}
