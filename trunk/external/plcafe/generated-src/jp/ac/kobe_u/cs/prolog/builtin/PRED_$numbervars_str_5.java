package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$numbervars_str'/5</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$numbervars_str_5 extends Predicate {
    static IntegerTerm si1 = new IntegerTerm(1);
    static Predicate _$numbervars_str_5_sub_1 = new PRED_$numbervars_str_5_sub_1();
    static Predicate _$numbervars_str_5_1 = new PRED_$numbervars_str_5_1();
    static Predicate _$numbervars_str_5_2 = new PRED_$numbervars_str_5_2();

    public Term arg1, arg2, arg3, arg4, arg5;

    public PRED_$numbervars_str_5(Term a1, Term a2, Term a3, Term a4, Term a5, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        this.cont = cont;
    }

    public PRED_$numbervars_str_5(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        this.cont = cont;
    }

    public int arity() { return 5; }

    public String toString() {
        return "$numbervars_str(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$numbervars_str_5_1, _$numbervars_str_5_sub_1);
    }
}

class PRED_$numbervars_str_5_sub_1 extends PRED_$numbervars_str_5 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$numbervars_str_5_2);
    }
}

class PRED_$numbervars_str_5_1 extends PRED_$numbervars_str_5 {
    public Predicate exec(Prolog engine) {
    // '$numbervars_str'(A,A,B,C,D):-!,arg(A,B,E),'$numbervars'(E,C,D)
        Term a1, a2, a3, a4, a5, a6;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$numbervars_str'(A,A,B,C,D):-['$neck_cut',arg(A,B,E),'$numbervars'(E,C,D)]
        if (! a1.unify(a2, engine.trail))
            return engine.fail();
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        a6 = new VariableTerm(engine);
        p1 = new PRED_$numbervars_3(a6, a4, a5, cont);
        return new PRED_arg_3(a1, a3, a6, p1);
    }
}

class PRED_$numbervars_str_5_2 extends PRED_$numbervars_str_5 {
    public Predicate exec(Prolog engine) {
    // '$numbervars_str'(A,B,C,D,E):-arg(A,C,F),'$numbervars'(F,D,G),H is A+1,'$numbervars_str'(H,B,C,G,E)
        Term a1, a2, a3, a4, a5, a6, a7, a8;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$numbervars_str'(A,B,C,D,E):-[arg(A,C,F),'$numbervars'(F,D,G),'$plus'(A,1,H),'$numbervars_str'(H,B,C,G,E)]
        a6 = new VariableTerm(engine);
        a7 = new VariableTerm(engine);
        a8 = new VariableTerm(engine);
        p1 = new PRED_$numbervars_str_5(a8, a2, a3, a7, a5, cont);
        p2 = new PRED_$plus_3(a1, si1, a8, p1);
        p3 = new PRED_$numbervars_3(a6, a4, a7, p2);
        return new PRED_arg_3(a1, a3, a6, p3);
    }
}
