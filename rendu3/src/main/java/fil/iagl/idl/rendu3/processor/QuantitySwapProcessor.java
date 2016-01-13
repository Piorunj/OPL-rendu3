package fil.iagl.idl.rendu3.processor;

import java.util.Random;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;

//Récupère les opérateurs < > <= >=
public class QuantitySwapProcessor extends AbstractProcessor<CtBinaryOperator> {

	private static final int NB_VALUE = 4;

	@Override
	public boolean isToBeProcessed(CtBinaryOperator candidate) {
		return candidate.getKind().toString() == "LT" || candidate.getKind().toString() == "LE"
				|| candidate.getKind().toString() == "GE" || candidate.getKind().toString() == "GT";
	}

	@Override
	public void process(CtBinaryOperator arg0) {
		System.out.println(arg0.getKind());
		Random r = new Random();
		int random = r.nextInt(NB_VALUE);
		System.out.println(random);
		switch (random) {
		case 0:
			System.out.println("===> from " + arg0.getKind() + " To LT");
			arg0.setKind(BinaryOperatorKind.LT);
			System.out.println(arg0.getKind());
			break;
		case 1:
			System.out.println("===> from " + arg0.getKind() + " To LE");
			arg0.setKind(BinaryOperatorKind.LE);
			System.out.println(arg0.getKind());
			break;
		case 2:
			System.out.println("===> from " + arg0.getKind() + " To GE");
			arg0.setKind(BinaryOperatorKind.GE);
			System.out.println(arg0.getKind());
			break;
		case 3:
			System.out.println("===> from " + arg0.getKind() + " To GT");
			arg0.setKind(BinaryOperatorKind.GT);
			System.out.println(arg0.getKind());
			break;
		default:
			break;
		}
	}
}
