package fil.iagl.idl.rendu3;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.maven.shared.invoker.MavenInvocationException;

import fil.iagl.idl.rendu3.maven.MavenRunner;

public class App {

    public static void main( String[] args ) {

//    	try {
//			MavenRunner.cleanCompileTest("C:/workspace/IntroClassJava/dataset/checksum/08c7ea4ac39aa6a5ab206393bb4412de9d2c365ecdda9c1b391be963c1811014ed23d2722d7433b8e8a95305eee314d39da4950f31e01f9147f90af91a5c433a/007/pom.xml");
//			MavenRunner.clean("C:/workspace/IntroClassJava/dataset/checksum/08c7ea4ac39aa6a5ab206393bb4412de9d2c365ecdda9c1b391be963c1811014ed23d2722d7433b8e8a95305eee314d39da4950f31e01f9147f90af91a5c433a/007/pom.xml");
//			
//    	} catch (MavenInvocationException e) {
//			e.printStackTrace();
//		}
    	
    	
    	
    	
    	
    	
    	
    	
        // liste des différents projets
    	Set<File> projets = new HashSet<>();
    	for ( File projet : new File( "C:/workspace/IntroClassJava/dataset" ).listFiles( new DirectoryFilter() ) ) {
    	 if(projet.isDirectory())
    		 projets.add(projet);
    	}
    	for ( File projet : projets) {
            //liste des commits des différents étudiants
            for ( File commit : projet.listFiles( new DirectoryFilter() ) ) {
                //liste des différentes révisions
                for ( File revision : commit.listFiles() ) {
//                    File source = new File(new File(revision.getAbsolutePath()+"//src//main//java//introclassJava").list()[0]);
                	System.out.println("Path to pom : "+revision+"\\pom.xml");
                	try {
                		MavenRunner.cleanCompileTest(revision+"\\pom.xml");
//                		MavenRunner.clean(revision+"\\pom.xml");

                	} catch (MavenInvocationException e) {
                		e.printStackTrace();
                	}

                }
            }
        }
    }


}


