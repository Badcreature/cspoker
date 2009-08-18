package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$stream_property_specifier'/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$stream_property_specifier_1 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("input");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("output");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("alias", 1);
    static SymbolTerm s4 = SymbolTerm.makeSymbol("mode", 1);
    static SymbolTerm s5 = SymbolTerm.makeSymbol("type", 1);
    static SymbolTerm s6 = SymbolTerm.makeSymbol("file_name", 1);
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _$stream_property_specifier_1_var = new PRED_$stream_property_specifier_1_var();
    static Predicate _$stream_property_specifier_1_var_1 = new PRED_$stream_property_specifier_1_var_1();
    static Predicate _$stream_property_specifier_1_var_2 = new PRED_$stream_property_specifier_1_var_2();
    static Predicate _$stream_property_specifier_1_var_3 = new PRED_$stream_property_specifier_1_var_3();
    static Predicate _$stream_property_specifier_1_var_4 = new PRED_$stream_property_specifier_1_var_4();
    static Predicate _$stream_property_specifier_1_var_5 = new PRED_$stream_property_specifier_1_var_5();
    static Predicate _$stream_property_specifier_1_con = new PRED_$stream_property_specifier_1_con();
    static Predicate _$stream_property_specifier_1_str = new PRED_$stream_property_specifier_1_str();
    static Predicate _$stream_property_specifier_1_1 = new PRED_$stream_property_specifier_1_1();
    static Predicate _$stream_property_specifier_1_2 = new PRED_$stream_property_specifier_1_2();
    static Predicate _$stream_property_specifier_1_3 = new PRED_$stream_property_specifier_1_3();
    static Predicate _$stream_property_specifier_1_4 = new PRED_$stream_property_specifier_1_4();
    static Predicate _$stream_property_specifier_1_5 = new PRED_$stream_property_specifier_1_5();
    static Predicate _$stream_property_specifier_1_6 = new PRED_$stream_property_specifier_1_6();
    static java.util.Hashtable<Term, Predicate> con = new java.util.Hashtable<Term, Predicate>(2);
    static java.util.Hashtable<Term, Predicate> str = new java.util.Hashtable<Term, Predicate>(4);
    static {
        con.put(s1, _$stream_property_specifier_1_1);
        con.put(s2, _$stream_property_specifier_1_2);
        str.put(s3, _$stream_property_specifier_1_3);
        str.put(s4, _$stream_property_specifier_1_4);
        str.put(s5, _$stream_property_specifier_1_5);
        str.put(s6, _$stream_property_specifier_1_6);
    }

    public Term arg1;

    public PRED_$stream_property_specifier_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_$stream_property_specifier_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "$stream_property_specifier(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$stream_property_specifier_1_var, _fail_0, _fail_0, _$stream_property_specifier_1_con, _$stream_property_specifier_1_str, _fail_0);
    }
}

class PRED_$stream_property_specifier_1_var extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$stream_property_specifier_1_1, _$stream_property_specifier_1_var_1);
    }
}

class PRED_$stream_property_specifier_1_var_1 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$stream_property_specifier_1_2, _$stream_property_specifier_1_var_2);
    }
}

class PRED_$stream_property_specifier_1_var_2 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$stream_property_specifier_1_3, _$stream_property_specifier_1_var_3);
    }
}

class PRED_$stream_property_specifier_1_var_3 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$stream_property_specifier_1_4, _$stream_property_specifier_1_var_4);
    }
}

class PRED_$stream_property_specifier_1_var_4 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$stream_property_specifier_1_5, _$stream_property_specifier_1_var_5);
    }
}

class PRED_$stream_property_specifier_1_var_5 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$stream_property_specifier_1_6);
    }
}

class PRED_$stream_property_specifier_1_con extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(con, _fail_0);
    }
}

class PRED_$stream_property_specifier_1_str extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(str, _fail_0);
    }
}

class PRED_$stream_property_specifier_1_1 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'(input):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'(input):-[]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$stream_property_specifier_1_2 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'(output):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'(output):-[]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s2))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s2, engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$stream_property_specifier_1_3 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'(alias(A)):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'(alias(A)):-[]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s3.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
        } else if (a1.isVariable()){
            Term[] args = {new VariableTerm(engine)};
            ((VariableTerm) a1).bind(new StructureTerm(s3, args), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$stream_property_specifier_1_4 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'((mode A)):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'((mode A)):-[]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s4.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
        } else if (a1.isVariable()){
            Term[] args = {new VariableTerm(engine)};
            ((VariableTerm) a1).bind(new StructureTerm(s4, args), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$stream_property_specifier_1_5 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'(type(A)):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'(type(A)):-[]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s5.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
        } else if (a1.isVariable()){
            Term[] args = {new VariableTerm(engine)};
            ((VariableTerm) a1).bind(new StructureTerm(s5, args), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$stream_property_specifier_1_6 extends PRED_$stream_property_specifier_1 {
    public Predicate exec(Prolog engine) {
    // '$stream_property_specifier'(file_name(A)):-true
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$stream_property_specifier'(file_name(A)):-[]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s6.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
        } else if (a1.isVariable()){
            Term[] args = {new VariableTerm(engine)};
            ((VariableTerm) a1).bind(new StructureTerm(s6, args), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}
