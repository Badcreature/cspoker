package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$read_tokens_until_fullstop'/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$read_tokens_until_fullstop_1 extends Predicate {

    public Term arg1;

    public PRED_$read_tokens_until_fullstop_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_$read_tokens_until_fullstop_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "$read_tokens_until_fullstop(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$read_tokens_until_fullstop'(A):-read_token(A,B),'$read_tokens_until_fullstop'(A,B)
        engine.setB0();
        Term a1, a2;
        Predicate p1;
        a1 = arg1;
    // '$read_tokens_until_fullstop'(A):-[read_token(A,B),'$read_tokens_until_fullstop'(A,B)]
        a2 = new VariableTerm(engine);
        p1 = new PRED_$read_tokens_until_fullstop_2(a1, a2, cont);
        return new PRED_read_token_2(a1, a2, p1);
    }
}
