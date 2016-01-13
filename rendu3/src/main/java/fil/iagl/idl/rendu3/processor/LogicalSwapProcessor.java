package fil.iagl.idl.rendu3.processor;

import java.util.Random;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;

public class LogicalSwapProcessor extends AbstractProcessor<CtBinaryOperator> {

	private static final int NB_VALUE = 2;

	@Override
	public boolean isToBeProcessed(CtBinaryOperator candidate) {
		return candidate.getKind().toString() == "AND" || candidate.getKind().toString() == "OR";
	}

	@Override
	public void process(CtBinaryOperator arg0) {
		System.out.println(arg0.getKind());
		Random r = new Random();
		int random = r.nextInt(NB_VALUE);
		System.out.println(random);
		switch (random) {
		case 0:
			System.out.println("===> from " + arg0.getKind() + " To AND");
			arg0.setKind(BinaryOperatorKind.AND);
			System.out.println(arg0.getKind());
			break;
		case 1:
			System.out.println("===> from " + arg0.getKind() + " To OR");
			arg0.setKind(BinaryOperatorKind.OR);
			System.out.println(arg0.getKind());
			break;
		default:
			break;
		}
	}

}
