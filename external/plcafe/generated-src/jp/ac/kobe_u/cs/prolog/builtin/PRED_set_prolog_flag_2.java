package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>set_prolog_flag/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_set_prolog_flag_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("var");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("set_prolog_flag", 2);
    static IntegerTerm si3 = new IntegerTerm(1);
    static IntegerTerm si4 = new IntegerTerm(2);
    static SymbolTerm s5 = SymbolTerm.makeSymbol("type", 1);
    static SymbolTerm s6 = SymbolTerm.makeSymbol("atom");
    static Term[] s7 = {s6};
    static StructureTerm s8 = new StructureTerm(s5, s7);
    static Predicate _set_prolog_flag_2_sub_1 = new PRED_set_prolog_flag_2_sub_1();
    static Predicate _set_prolog_flag_2_sub_2 = new PRED_set_prolog_flag_2_sub_2();
    static Predicate _set_prolog_flag_2_sub_3 = new PRED_set_prolog_flag_2_sub_3();
    static Predicate _set_prolog_flag_2_1 = new PRED_set_prolog_flag_2_1();
    static Predicate _set_prolog_flag_2_2 = new PRED_set_prolog_flag_2_2();
    static Predicate _set_prolog_flag_2_3 = new PRED_set_prolog_flag_2_3();
    static Predicate _set_prolog_flag_2_4 = new PRED_set_prolog_flag_2_4();

    public Term arg1, arg2;

    public PRED_set_prolog_flag_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_set_prolog_flag_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "set_prolog_flag(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_set_prolog_flag_2_1, _set_prolog_flag_2_sub_1);
    }
}

class PRED_set_prolog_flag_2_sub_1 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_set_prolog_flag_2_2, _set_prolog_flag_2_sub_2);
    }
}

class PRED_set_prolog_flag_2_sub_2 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_set_prolog_flag_2_3, _set_prolog_flag_2_sub_3);
    }
}

class PRED_set_prolog_flag_2_sub_3 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_set_prolog_flag_2_4);
    }
}

class PRED_set_prolog_flag_2_1 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
    // set_prolog_flag(A,B):-var(A),!,illarg(var,set_prolog_flag(A,B),1)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // set_prolog_flag(A,B):-['$get_level'(C),var(A),'$cut'(C),illarg(var,set_prolog_flag(A,B),1)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(1))
        a1 = a1.dereference();
        if (! a1.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(3))
        a3 = a3.dereference();
        if (! a3.isInteger()) {
            throw new IllegalTypeException("integer", a3);
        } else {
            engine.cut(((IntegerTerm) a3).intValue());
        }
        //END inline expansion
        Term[] y1 = {a1, a2};
        a4 = new StructureTerm(s2, y1);
        return new PRED_illarg_3(s1, a4, si3, cont);
    }
}

class PRED_set_prolog_flag_2_2 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
    // set_prolog_flag(A,B):-var(B),!,illarg(var,set_prolog_flag(A,B),2)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // set_prolog_flag(A,B):-['$get_level'(C),var(B),'$cut'(C),illarg(var,set_prolog_flag(A,B),2)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(2))
        a2 = a2.dereference();
        if (! a2.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(3))
        a3 = a3.dereference();
        if (! a3.isInteger()) {
            throw new IllegalTypeException("integer", a3);
        } else {
            engine.cut(((IntegerTerm) a3).intValue());
        }
        //END inline expansion
        Term[] y1 = {a1, a2};
        a4 = new StructureTerm(s2, y1);
        return new PRED_illarg_3(s1, a4, si4, cont);
    }
}

class PRED_set_prolog_flag_2_3 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
    // set_prolog_flag(A,B):-atom(A),!,'$set_prolog_flag0'(A,B)
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // set_prolog_flag(A,B):-['$get_level'(C),atom(A),'$cut'(C),'$set_prolog_flag0'(A,B)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of atom(a(1))
        a1 = a1.dereference();
        if (! a1.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(3))
        a3 = a3.dereference();
        if (! a3.isInteger()) {
            throw new IllegalTypeException("integer", a3);
        } else {
            engine.cut(((IntegerTerm) a3).intValue());
        }
        //END inline expansion
        return new PRED_$set_prolog_flag0_2(a1, a2, cont);
    }
}

class PRED_set_prolog_flag_2_4 extends PRED_set_prolog_flag_2 {
    public Predicate exec(Prolog engine) {
    // set_prolog_flag(A,B):-illarg(type(atom),set_prolog_flag(A,B),1)
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // set_prolog_flag(A,B):-[illarg(type(atom),set_prolog_flag(A,B),1)]
        Term[] y1 = {a1, a2};
        a3 = new StructureTerm(s2, y1);
        return new PRED_illarg_3(s8, a3, si3, cont);
    }
}
