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
 <code>'$read_tokens'/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$read_tokens_4 extends Predicate {

    public Term arg1, arg2, arg3, arg4;

    public PRED_$read_tokens_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_$read_tokens_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "$read_tokens(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$read_tokens'(A,B,C,D):-read_token(A,E),'$read_tokens1'(A,E,B,C,D)
        engine.setB0();
        Term a1, a2, a3, a4, a5;
        Predicate p1;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
        a4 = arg4;
    // '$read_tokens'(A,B,C,D):-[read_token(A,E),'$read_tokens1'(A,E,B,C,D)]
        a5 = new VariableTerm(engine);
        p1 = new PRED_$read_tokens1_5(a1, a5, a2, a3, a4, cont);
        return new PRED_read_token_2(a1, a5, p1);
    }
}
