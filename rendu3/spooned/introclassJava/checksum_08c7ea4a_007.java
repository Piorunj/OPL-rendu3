package introclassJava;


public class checksum_08c7ea4a_007 {
    public java.util.Scanner scanner;

    public java.lang.String output = "";

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        introclassJava.checksum_08c7ea4a_007 mainClass = new introclassJava.checksum_08c7ea4a_007();
        java.lang.String output;
        if ((args.length) <= 0) {
            mainClass.scanner = new java.util.Scanner(args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner(java.lang.System.in);
        }
        mainClass.exec();
        java.lang.System.out.println(mainClass.output);
    }

    public void exec() throws java.lang.Exception {
        char[] string = new char[1000];
        introclassJava.CharObj checksumchar = new introclassJava.CharObj();
        introclassJava.IntObj i = new introclassJava.IntObj();
        introclassJava.IntObj stringlength = new introclassJava.IntObj();
        introclassJava.IntObj checksum_summation = new introclassJava.IntObj();
        output += java.lang.String.format("Enter an abitrarily long string, ending with carriage return > ");
        string = scanner.next().toCharArray();
        stringlength.value = string.length;
        checksum_summation.value = 0;
        for (i.value = 0 ; (i.value) < (stringlength.value) ; (i.value)++) {
            checksum_summation.value += ((int)(string[i.value]));
        }
        checksum_summation.value %= 64;
        checksum_summation.value += 32;
        checksumchar.value = ((char)(checksum_summation.value));
        output += java.lang.String.format("Check sum is %c\n", checksumchar.value);
        if (true)
            return ;
        
    }
}

