package fil.iagl.idl.rendu3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.xml.sax.SAXException;

import fil.iagl.idl.rendu3.entite.Resultat;
import fil.iagl.idl.rendu3.maven.MavenRunner;
import fil.iagl.idl.rendu3.xmlparser.XMLParser;

public class IDLMainNopol {

	static Map<String, Resultat> result = new HashMap<>();
	static Resultat resultGlobal = new Resultat();
	static File revision;

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

	// Resultat initial Resultat [blackSuccess=2284, blackFail=801,
	// whiteSuccess=2543, whiteFail=1031]

	public static void main(String[] args) throws Exception {
		int nbPatch = 0;
		// liste des différents projets
		Set<File> projets = new HashSet<>();
		for (File projet : new File("C:/workspace/IntroClassJavaCpy/dataset").listFiles(new DirectoryFilter())) {
			if (projet.isDirectory())
				projets.add(projet);
		}
		for (File projet : projets) {
			// liste des commits des différents étudiants
			for (File commit : projet.listFiles(new DirectoryFilter())) {
				// liste des différentes révisions
				for (File revision2 : commit.listFiles()) {
					revision = revision2;
					System.out.println("Revision : " + revision);

					try {
						System.out.println("Path to pom : " + revision + "\\pom.xml");
						result.put(revision.toString(), new Resultat());

						MavenRunner.cleanCompileTest(revision + "\\pom.xml");

						File testFileName = new File(
								new File(revision + "/src/test/java/introclassJava").list(new FilenameFilter() {

									@Override
									public boolean accept(File dir, String name) {
										return name.contains("White");
									}
								})[0]);
						File ReportFolder = new File("report/" + revision.toString().substring(39));
						if (!ReportFolder.exists()) {
							ReportFolder.mkdirs();
						}
						Runtime rt = Runtime.getRuntime();

						Process pr = rt
								.exec("C:/Program Files/Java/jdk1.7.0_79/bin/javaw.exe -Dfile.encoding=UTF-8 -classpath C:/workspace/nopol/nopol/target/classes;C:/Users/wokei/.m2/repository/org/apache/maven/shared/maven-invoker/2.2/maven-invoker-2.2.jar;C:/Users/wokei/.m2/repository/junit/junit/4.11/junit-4.11.jar;C:/Users/wokei/.m2/repository/org/reflections/reflections/0.9.9-RC1/reflections-0.9.9-RC1.jar;C:/Users/wokei/.m2/repository/org/javassist/javassist/3.16.1-GA/javassist-3.16.1-GA.jar;C:/Users/wokei/.m2/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar;C:/Users/wokei/.m2/repository/xml-apis/xml-apis/1.0.b2/xml-apis-1.0.b2.jar;C:/Users/wokei/.m2/repository/com/google/guava/guava/15.0/guava-15.0.jar;C:/Users/wokei/.m2/repository/ch/qos/logback/logback-classic/1.0.13/logback-classic-1.0.13.jar;C:/Users/wokei/.m2/repository/ch/qos/logback/logback-core/1.0.13/logback-core-1.0.13.jar;C:/Users/wokei/.m2/repository/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar;C:/Users/wokei/.m2/repository/com/google/code/findbugs/jsr305/2.0.1/jsr305-2.0.1.jar;C:/Users/wokei/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar;C:/workspace/nopol/gzoltar-wrapper/target/classes;C:/Users/wokei/.m2/repository/gov/nasa/jpf/jpf/1154/jpf-1154.jar;C:/Users/wokei/.m2/repository/gov/nasa/jpf/jpf-symbc/576/jpf-symbc-576.jar;C:/Users/wokei/.m2/repository/com/microsoft/z3/z3/0.0.1/z3-0.0.1.jar;C:/Users/wokei/.m2/repository/fr/inria/gforge/spoon/spoon-core/4.3.0/spoon-core-4.3.0.jar;C:/Users/wokei/.m2/repository/org/eclipse/jdt/core/compiler/ecj/4.4.2/ecj-4.4.2.jar;C:/Users/wokei/.m2/repository/com/martiansoftware/jsap/2.1/jsap-2.1.jar;C:/Users/wokei/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar;C:/Users/wokei/.m2/repository/commons-io/commons-io/1.3.2/commons-io-1.3.2.jar;C:/Users/wokei/.m2/repository/org/smtlib/smtlib/0.9.7.1/smtlib-0.9.7.1.jar;C:/Program Files/Java/jdk1.7.0_79/lib/tools.jar;C:/Users/wokei/.m2/repository/sacha/infra/0.1/infra-0.1.jar;C:/Users/wokei/.m2/repository/com/gzoltar/gzoltar/0.1.1/gzoltar-0.1.1.jar fr.inria.lille.repair.Main "
										+ "-m repair " + "-e condition " + "-y smt " + "-o angelic " + "-s " + revision
										+ "/src/main/java" + revision + "/src/test/java " + "-c " + revision
										+ "/target/classes;" + revision
										+ "/target/test-classes;C:/Users/wokei/.m2/repository/junit/junit/4.11/junit-4.11.jar "
										+ "-p C:/workspace/z3-4.3.2-x64-win/bin/z3.exe");

						InputStream is = pr.getInputStream();
						File reportFile = new File("report/" + revision.toString().substring(39) + "/"
								+ testFileName.toString().replace(".java", "") + ".txt");
						OutputStream os = new FileOutputStream(reportFile);

						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = is.read(bytes)) != -1) {
							os.write(bytes, 0, read);
						}
						is.close();
						os.close();

						try {
							InputStream ips = new FileInputStream(reportFile);
							InputStreamReader ipsr = new InputStreamReader(ips);
							BufferedReader br = new BufferedReader(ipsr);
							boolean patchFound = false;
							String ligne;
							while ((ligne = br.readLine()) != null) {
								if (ligne.contains("----PATCH FOUND----")) {
									System.out.println("Fix trouvé pour le projet : " + revision);
									nbPatch++;
									patchFound = true;
								}
								if (patchFound) {
									System.out.println(ligne);
								}
							}
							br.close();
						} catch (Exception e) {
							System.out.println(e.toString());
						}

						System.out.println(revision + "/target/surefire-reports");
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

					} catch (IOException e) {
						e.printStackTrace();
					} catch (SAXException e) {
						e.printStackTrace();
					} catch (ParserConfigurationException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(resultGlobal);
		System.out.println("Nombre de patch trouvé : " + nbPatch);
	}
}
