package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$dcg_connect'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dcg_connect_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("->", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol(",", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("true");
    static Predicate _$dcg_connect_3_var = new PRED_$dcg_connect_3_var();
    static Predicate _$dcg_connect_3_var_1 = new PRED_$dcg_connect_3_var_1();
    static Predicate _$dcg_connect_3_var_2 = new PRED_$dcg_connect_3_var_2();
    static Predicate _$dcg_connect_3_int = new PRED_$dcg_connect_3_int();
    static Predicate _$dcg_connect_3_int_1 = new PRED_$dcg_connect_3_int_1();
    static Predicate _$dcg_connect_3_1 = new PRED_$dcg_connect_3_1();
    static Predicate _$dcg_connect_3_2 = new PRED_$dcg_connect_3_2();
    static Predicate _$dcg_connect_3_3 = new PRED_$dcg_connect_3_3();

    public Term arg1, arg2, arg3;

    public PRED_$dcg_connect_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$dcg_connect_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$dcg_connect(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$dcg_connect_3_var, _$dcg_connect_3_int, _$dcg_connect_3_int, _$dcg_connect_3_int, _$dcg_connect_3_var, _$dcg_connect_3_int);
    }
}

class PRED_$dcg_connect_3_var extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$dcg_connect_3_1, _$dcg_connect_3_var_1);
    }
}

class PRED_$dcg_connect_3_var_1 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$dcg_connect_3_2, _$dcg_connect_3_var_2);
    }
}

class PRED_$dcg_connect_3_var_2 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dcg_connect_3_3);
    }
}

class PRED_$dcg_connect_3_int extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$dcg_connect_3_2, _$dcg_connect_3_int_1);
    }
}

class PRED_$dcg_connect_3_int_1 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dcg_connect_3_3);
    }
}

class PRED_$dcg_connect_3_1 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
    // '$dcg_connect'((A->B),C,C):-C=(D->E),!
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$dcg_connect'((A->B),C,C):-['$get_level'(D),'$unify'(C,(E->F)),'$cut'(D)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s1.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
        } else if (a1.isVariable()){
            Term[] args = {new VariableTerm(engine), new VariableTerm(engine)};
            ((VariableTerm) a1).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        if (! a2.unify(a3, engine.trail))
            return engine.fail();
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        Term[] y1 = {new VariableTerm(engine), new VariableTerm(engine)};
        a5 = new StructureTerm(s1, y1);
        //START inline expansion of $unify(a(2),a(5))
        if (! a2.unify(a5, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(4))
        a4 = a4.dereference();
        if (! a4.isInteger()) {
            throw new IllegalTypeException("integer", a4);
        } else {
            engine.cut(((IntegerTerm) a4).intValue());
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$dcg_connect_3_2 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
    // '$dcg_connect'(A,(B->C),((B->C),true)):-!
        Term a1, a2, a3, a4, a5, a6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$dcg_connect'(A,(B->C),((B->C),true)):-['$neck_cut']
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s1.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a4 = args[0];
            a5 = args[1];
        } else if (a2.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            Term[] args = {a4, a5};
            ((VariableTerm) a2).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s2.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a6 = args[0];
            if (! s3.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            Term[] args = {a6, s3};
            ((VariableTerm) a3).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        a6 = a6.dereference();
        if (a6.isStructure()){
            if (! s1.equals(((StructureTerm)a6).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a6).args();
            if (! a4.unify(args[0], engine.trail))
                return engine.fail();
            if (! a5.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a6.isVariable()){
            Term[] args = {a4, a5};
            ((VariableTerm) a6).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$dcg_connect_3_3 extends PRED_$dcg_connect_3 {
    public Predicate exec(Prolog engine) {
    // '$dcg_connect'(A,B,B):-true
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$dcg_connect'(A,B,B):-[]
        if (! a2.unify(a3, engine.trail))
            return engine.fail();
        return cont;
    }
}
