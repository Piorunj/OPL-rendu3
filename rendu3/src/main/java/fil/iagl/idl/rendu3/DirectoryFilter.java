package fil.iagl.idl.rendu3;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryFilter implements FilenameFilter {

    public boolean accept( File dir , String name ) {
//        System.out.println("EST UN REPERTOIRE ?? ==> "+dir+"   "+dir.isDirectory());
        return dir.isDirectory();
    }

}

