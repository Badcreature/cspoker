package jp.ac.kobe_u.cs.prolog.builtin;

import jp.ac.kobe_u.cs.prolog.lang.IllegalTypeException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.PInstantiationException;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.RepresentationException;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;

/**
 * <code>char_code/2</code><br>
 * 
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
public class PRED_char_code_2 extends Predicate {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9066271177749626293L;
	// static SymbolTerm Nil = SymbolTerm.makeSymbol("[]");
	private Term arg1, arg2;

	public PRED_char_code_2(Term a1, Term a2, Predicate cont) {
		arg1 = a1;
		arg2 = a2;
		this.cont = cont;
	}

	public PRED_char_code_2() {
	}

	@Override
	public void setArgument(Term[] args, Predicate cont) {
		arg1 = args[0];
		arg2 = args[1];
		this.cont = cont;
	}

	@Override
	public int arity() {
		return 2;
	}

	@Override
	public String toString() {
		return "char_code(" + arg1 + "," + arg2 + ")";
	}

	@Override
	public Predicate exec(Prolog engine) {
		engine.setB0();
		Term a1, a2;
		a1 = arg1;
		a2 = arg2;

		a1 = a1.dereference();
		a2 = a2.dereference();
		if (a1.isVariable()) { // char_code(-Char, +CharCode)
			if (a2.isVariable()) {
				throw new PInstantiationException(this, 2);
			} else if (!a2.isInteger()) {
				throw new IllegalTypeException(this, 2, "integer", a2);
			}
			int i = ((IntegerTerm) a2).intValue();
			if (!Character.isDefined(i)) {
				throw new RepresentationException(this, 2, "character_code");
			}
			if (!a1.unify(SymbolTerm.makeSymbol(String.valueOf((char) i)),
					engine.trail)) {
				return engine.fail();
			}
		} else if (a1.isSymbol()) { // char_code(+Char, ?CharCode)
			String s = ((SymbolTerm) a1).name();
			if (s.length() != 1) {
				throw new IllegalTypeException(this, 1, "character", a1);
			}
			if (!a2.unify(new IntegerTerm(s.charAt(0)), engine.trail)) {
				return engine.fail();
			}
		} else {
			return engine.fail();
		}
		return cont;
	}
}
