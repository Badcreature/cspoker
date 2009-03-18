package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>consult/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_consult_1 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("var");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("consult", 1);
    static IntegerTerm si3 = new IntegerTerm(1);
    static SymbolTerm s4 = SymbolTerm.makeSymbol("[]");
    static Predicate _consult_1_top = new PRED_consult_1_top();
    static Predicate _consult_1_var = new PRED_consult_1_var();
    static Predicate _consult_1_var_1 = new PRED_consult_1_var_1();
    static Predicate _consult_1_var_2 = new PRED_consult_1_var_2();
    static Predicate _consult_1_var_3 = new PRED_consult_1_var_3();
    static Predicate _consult_1_int = new PRED_consult_1_int();
    static Predicate _consult_1_int_1 = new PRED_consult_1_int_1();
    static Predicate _consult_1_con = new PRED_consult_1_con();
    static Predicate _consult_1_con_1 = new PRED_consult_1_con_1();
    static Predicate _consult_1_con_2 = new PRED_consult_1_con_2();
    static Predicate _consult_1_lis = new PRED_consult_1_lis();
    static Predicate _consult_1_lis_1 = new PRED_consult_1_lis_1();
    static Predicate _consult_1_lis_2 = new PRED_consult_1_lis_2();
    static Predicate _consult_1_1 = new PRED_consult_1_1();
    static Predicate _consult_1_2 = new PRED_consult_1_2();
    static Predicate _consult_1_3 = new PRED_consult_1_3();
    static Predicate _consult_1_4 = new PRED_consult_1_4();

    public Term arg1;

    public PRED_consult_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_consult_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "consult(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.cont = cont;
        return _consult_1_top;
    }
}

class PRED_consult_1_top extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        engine.setB0();
        return engine.switch_on_term(_consult_1_var, _consult_1_int, _consult_1_int, _consult_1_con, _consult_1_int, _consult_1_lis);
    }
}

class PRED_consult_1_var extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_consult_1_1, _consult_1_var_1);
    }
}

class PRED_consult_1_var_1 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_consult_1_2, _consult_1_var_2);
    }
}

class PRED_consult_1_var_2 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_consult_1_3, _consult_1_var_3);
    }
}

class PRED_consult_1_var_3 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_consult_1_4);
    }
}

class PRED_consult_1_int extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_consult_1_1, _consult_1_int_1);
    }
}

class PRED_consult_1_int_1 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_consult_1_4);
    }
}

class PRED_consult_1_con extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_consult_1_1, _consult_1_con_1);
    }
}

class PRED_consult_1_con_1 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_consult_1_2, _consult_1_con_2);
    }
}

class PRED_consult_1_con_2 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_consult_1_4);
    }
}

class PRED_consult_1_lis extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_consult_1_1, _consult_1_lis_1);
    }
}

class PRED_consult_1_lis_1 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_consult_1_3, _consult_1_lis_2);
    }
}

class PRED_consult_1_lis_2 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_consult_1_4);
    }
}

class PRED_consult_1_1 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
    // consult(A):-var(A),!,illarg(var,consult(A),1)
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // consult(A):-['$get_level'(B),var(A),'$cut'(B),illarg(var,consult(A),1)]
        a2 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(2))
        if (! a2.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(1))
        a1 = a1.dereference();
        if (! a1.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            throw new IllegalTypeException("integer", a2);
        } else {
            engine.cut(((IntegerTerm) a2).intValue());
        }
        //END inline expansion
        Term[] y1 = {a1};
        a3 = new StructureTerm(s2, y1);
        return new PRED_illarg_3(s1, a3, si3, cont);
    }
}

class PRED_consult_1_2 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
    // consult([]):-!
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // consult([]):-['$neck_cut']
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s4))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s4, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_consult_1_3 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
    // consult([A|B]):-!,consult(A),consult(B)
        Term a1, a2, a3;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // consult([A|B]):-['$neck_cut',consult(A),consult(B)]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a2 = args[0];
            a3 = args[1];
        } else if (a1.isVariable()){
            a2 = new VariableTerm(engine);
            a3 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a2, a3), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_consult_1(a3, cont);
        engine.aregs[1] = a2;
        engine.cont = p1;
        return _consult_1_top;
    }
}

class PRED_consult_1_4 extends PRED_consult_1 {
    public Predicate exec(Prolog engine) {
    // consult(A):-atom(A),!,'$consult'(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // consult(A):-['$get_level'(B),atom(A),'$cut'(B),'$consult'(A)]
        a2 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(2))
        if (! a2.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of atom(a(1))
        a1 = a1.dereference();
        if (! a1.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            throw new IllegalTypeException("integer", a2);
        } else {
            engine.cut(((IntegerTerm) a2).intValue());
        }
        //END inline expansion
        return new PRED_$consult_1(a1, cont);
    }
}
