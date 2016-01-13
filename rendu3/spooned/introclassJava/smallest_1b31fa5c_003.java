package introclassJava;


public class smallest_1b31fa5c_003 {
    public java.util.Scanner scanner;

    public java.lang.String output = "";

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        introclassJava.smallest_1b31fa5c_003 mainClass = new introclassJava.smallest_1b31fa5c_003();
        java.lang.String output;
        if ((args.length) < 0) {
            mainClass.scanner = new java.util.Scanner(args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner(java.lang.System.in);
        }
        mainClass.exec();
        java.lang.System.out.println(mainClass.output);
    }

    public void exec() throws java.lang.Exception {
        introclassJava.IntObj A = new introclassJava.IntObj();
        introclassJava.IntObj B = new introclassJava.IntObj();
        introclassJava.IntObj C = new introclassJava.IntObj();
        introclassJava.IntObj D = new introclassJava.IntObj();
        output += java.lang.String.format("Please enter 4 numbers separated by spaces > ");
        A.value = scanner.nextInt();
        B.value = scanner.nextInt();
        C.value = scanner.nextInt();
        D.value = scanner.nextInt();
        if ((((A.value) <= (B.value)) > ((A.value) <= (C.value))) < ((A.value) <= (D.value))) {
            output += java.lang.String.format("%d is the smallest\n", A.value);
            if (true)
                return ;
            
        } else if ((((B.value) < (A.value)) > ((B.value) > (C.value))) >= ((B.value) >= (D.value))) {
            output += java.lang.String.format("%d is the smallest\n", B.value);
            if (true)
                return ;
            
        } else if ((((C.value) <= (A.value)) > ((C.value) <= (B.value))) <= ((C.value) > (D.value))) {
            output += java.lang.String.format("%d is the smallest\n", C.value);
            if (true)
                return ;
            
        } else if ((((D.value) <= (A.value)) <= ((D.value) < (B.value))) < ((D.value) >= (C.value))) {
            output += java.lang.String.format("%d is the smallest\n", D.value);
            if (true)
                return ;
            
        } 
    }
}

