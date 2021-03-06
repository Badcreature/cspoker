package jp.ac.kobe_u.cs.prolog.builtin;

import java.io.PushbackReader;

import jp.ac.kobe_u.cs.prolog.lang.DoubleTerm;
import jp.ac.kobe_u.cs.prolog.lang.ExistenceException;
import jp.ac.kobe_u.cs.prolog.lang.IllegalDomainException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.JavaException;
import jp.ac.kobe_u.cs.prolog.lang.JavaObjectTerm;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
import jp.ac.kobe_u.cs.prolog.lang.PInstantiationException;
import jp.ac.kobe_u.cs.prolog.lang.PermissionException;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.Token;

/**
 * <code>'$read_token0'/3</code><br>
 * 
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 * @since 0.7
 */
class PRED_$read_token0_3 extends Predicate {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6332608975014145565L;
	private Term arg1, arg2, arg3;

	public PRED_$read_token0_3(Term a1, Term a2, Term a3, Predicate cont) {
		arg1 = a1;
		arg2 = a2;
		arg3 = a3;
		this.cont = cont;
	}

	public PRED_$read_token0_3() {
	}

	@Override
	public void setArgument(Term[] args, Predicate cont) {
		arg1 = args[0];
		arg2 = args[1];
		arg3 = args[2];
		this.cont = cont;
	}

	@Override
	public int arity() {
		return 3;
	}

	@Override
	public String toString() {
		return "$read_token0(" + arg1 + ", " + arg2 + "," + arg3 + ")";
	}

	/*
	 * The a1 must be user, user_input, and java.io.PushbackReader, otherwise
	 * fails.
	 */
	@Override
	public Predicate exec(Prolog engine) {
		engine.setB0();
		Term a1, a2, a3;
		a1 = arg1;
		a2 = arg2;
		a3 = arg3;

		Object stream = null;
		StringBuffer s;
		int type;
		Term token;

		// S_or_a
		a1 = a1.dereference();
		if (a1.isVariable()) {
			throw new PInstantiationException(this, 1);
		} else if (a1.isSymbol()) {
			if (!engine.getStreamManager().containsKey(a1)) {
				throw new ExistenceException(this, 1, "stream", a1, "");
			}
			stream = ((JavaObjectTerm) engine.getStreamManager().get(a1))
					.object();
		} else if (a1.isJavaObject()) {
			stream = ((JavaObjectTerm) a1).object();
		} else {
			throw new IllegalDomainException(this, 1, "stream_or_alias", a1);
		}
		if (!(stream instanceof PushbackReader)) {
			throw new PermissionException(this, "input", "stream", a1, "");
		}
		// read token
		s = new StringBuffer();
		try {
			type = Token.read_token(s, (PushbackReader) stream);
			switch (type) {
			case 'I':
				token = new IntegerTerm(Integer.parseInt(s.toString()));
				break;
			case 'D':
				token = new DoubleTerm(Double.parseDouble(s.toString()));
				break;
			case 'S':
				char[] chars = s.toString().toCharArray();
				token = Prolog.Nil;
				for (int i = chars.length; i > 0; i--) {
					token = new ListTerm(new IntegerTerm(chars[i - 1]), token);
				}
				break;
			default:
				token = SymbolTerm.makeSymbol(s.toString());
				break;
			}
		} catch (Exception e) {
			throw new JavaException(this, 1, e);
		}
		if (!a2.unify(new IntegerTerm(type), engine.trail)) {
			return engine.fail();
		}
		if (!a3.unify(token, engine.trail)) {
			return engine.fail();
		}
		return cont;
	}
}
