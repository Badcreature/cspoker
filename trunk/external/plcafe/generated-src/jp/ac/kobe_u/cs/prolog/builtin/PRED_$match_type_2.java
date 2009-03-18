package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$match_type'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$match_type_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("term");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("variable");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("atom");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("atomic");
    static SymbolTerm s5 = SymbolTerm.makeSymbol("byte");
    static IntegerTerm si6 = new IntegerTerm(0);
    static IntegerTerm si7 = new IntegerTerm(255);
    static SymbolTerm s8 = SymbolTerm.makeSymbol("in_byte");
    static IntegerTerm si9 = new IntegerTerm(-1);
    static SymbolTerm s10 = SymbolTerm.makeSymbol("character");
    static IntegerTerm si11 = new IntegerTerm(1);
    static SymbolTerm s12 = SymbolTerm.makeSymbol("in_character");
    static SymbolTerm s13 = SymbolTerm.makeSymbol("number");
    static SymbolTerm s14 = SymbolTerm.makeSymbol("integer");
    static SymbolTerm s15 = SymbolTerm.makeSymbol("float");
    static SymbolTerm s16 = SymbolTerm.makeSymbol("callable");
    static SymbolTerm s17 = SymbolTerm.makeSymbol("compound");
    static SymbolTerm s18 = SymbolTerm.makeSymbol("list");
    static SymbolTerm s19 = SymbolTerm.makeSymbol("java");
    static SymbolTerm s20 = SymbolTerm.makeSymbol("stream");
    static SymbolTerm s21 = SymbolTerm.makeSymbol("stream_or_alias");
    static SymbolTerm s22 = SymbolTerm.makeSymbol("hash");
    static SymbolTerm s23 = SymbolTerm.makeSymbol("jp.ac.kobe_u.cs.prolog.lang.HashtableOfTerm");
    static SymbolTerm s24 = SymbolTerm.makeSymbol("hash_or_alias");
    static SymbolTerm s25 = SymbolTerm.makeSymbol("predicate_indicator");
    static SymbolTerm s26 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s27 = SymbolTerm.makeSymbol("/", 2);
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _$match_type_2_var = new PRED_$match_type_2_var();
    static Predicate _$match_type_2_var_1 = new PRED_$match_type_2_var_1();
    static Predicate _$match_type_2_var_2 = new PRED_$match_type_2_var_2();
    static Predicate _$match_type_2_var_3 = new PRED_$match_type_2_var_3();
    static Predicate _$match_type_2_var_4 = new PRED_$match_type_2_var_4();
    static Predicate _$match_type_2_var_5 = new PRED_$match_type_2_var_5();
    static Predicate _$match_type_2_var_6 = new PRED_$match_type_2_var_6();
    static Predicate _$match_type_2_var_7 = new PRED_$match_type_2_var_7();
    static Predicate _$match_type_2_var_8 = new PRED_$match_type_2_var_8();
    static Predicate _$match_type_2_var_9 = new PRED_$match_type_2_var_9();
    static Predicate _$match_type_2_var_10 = new PRED_$match_type_2_var_10();
    static Predicate _$match_type_2_var_11 = new PRED_$match_type_2_var_11();
    static Predicate _$match_type_2_var_12 = new PRED_$match_type_2_var_12();
    static Predicate _$match_type_2_var_13 = new PRED_$match_type_2_var_13();
    static Predicate _$match_type_2_var_14 = new PRED_$match_type_2_var_14();
    static Predicate _$match_type_2_var_15 = new PRED_$match_type_2_var_15();
    static Predicate _$match_type_2_var_16 = new PRED_$match_type_2_var_16();
    static Predicate _$match_type_2_var_17 = new PRED_$match_type_2_var_17();
    static Predicate _$match_type_2_var_18 = new PRED_$match_type_2_var_18();
    static Predicate _$match_type_2_var_19 = new PRED_$match_type_2_var_19();
    static Predicate _$match_type_2_con = new PRED_$match_type_2_con();
    static Predicate _$match_type_2_1 = new PRED_$match_type_2_1();
    static Predicate _$match_type_2_2 = new PRED_$match_type_2_2();
    static Predicate _$match_type_2_3 = new PRED_$match_type_2_3();
    static Predicate _$match_type_2_4 = new PRED_$match_type_2_4();
    static Predicate _$match_type_2_5 = new PRED_$match_type_2_5();
    static Predicate _$match_type_2_6 = new PRED_$match_type_2_6();
    static Predicate _$match_type_2_7 = new PRED_$match_type_2_7();
    static Predicate _$match_type_2_8 = new PRED_$match_type_2_8();
    static Predicate _$match_type_2_9 = new PRED_$match_type_2_9();
    static Predicate _$match_type_2_10 = new PRED_$match_type_2_10();
    static Predicate _$match_type_2_11 = new PRED_$match_type_2_11();
    static Predicate _$match_type_2_12 = new PRED_$match_type_2_12();
    static Predicate _$match_type_2_13 = new PRED_$match_type_2_13();
    static Predicate _$match_type_2_14 = new PRED_$match_type_2_14();
    static Predicate _$match_type_2_15 = new PRED_$match_type_2_15();
    static Predicate _$match_type_2_16 = new PRED_$match_type_2_16();
    static Predicate _$match_type_2_17 = new PRED_$match_type_2_17();
    static Predicate _$match_type_2_18 = new PRED_$match_type_2_18();
    static Predicate _$match_type_2_19 = new PRED_$match_type_2_19();
    static Predicate _$match_type_2_20 = new PRED_$match_type_2_20();
    static java.util.Hashtable<Term, Predicate> con = new java.util.Hashtable<Term, Predicate>(20);
    static {
        con.put(s1, _$match_type_2_1);
        con.put(s2, _$match_type_2_2);
        con.put(s3, _$match_type_2_3);
        con.put(s4, _$match_type_2_4);
        con.put(s5, _$match_type_2_5);
        con.put(s8, _$match_type_2_6);
        con.put(s10, _$match_type_2_7);
        con.put(s12, _$match_type_2_8);
        con.put(s13, _$match_type_2_9);
        con.put(s14, _$match_type_2_10);
        con.put(s15, _$match_type_2_11);
        con.put(s16, _$match_type_2_12);
        con.put(s17, _$match_type_2_13);
        con.put(s18, _$match_type_2_14);
        con.put(s19, _$match_type_2_15);
        con.put(s20, _$match_type_2_16);
        con.put(s21, _$match_type_2_17);
        con.put(s22, _$match_type_2_18);
        con.put(s24, _$match_type_2_19);
        con.put(s25, _$match_type_2_20);
    }

    public Term arg1, arg2;

    public PRED_$match_type_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$match_type_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$match_type(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$match_type_2_var, _fail_0, _fail_0, _$match_type_2_con, _fail_0, _fail_0);
    }
}

class PRED_$match_type_2_var extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$match_type_2_1, _$match_type_2_var_1);
    }
}

class PRED_$match_type_2_var_1 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_2, _$match_type_2_var_2);
    }
}

class PRED_$match_type_2_var_2 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_3, _$match_type_2_var_3);
    }
}

class PRED_$match_type_2_var_3 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_4, _$match_type_2_var_4);
    }
}

class PRED_$match_type_2_var_4 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_5, _$match_type_2_var_5);
    }
}

class PRED_$match_type_2_var_5 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_6, _$match_type_2_var_6);
    }
}

class PRED_$match_type_2_var_6 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_7, _$match_type_2_var_7);
    }
}

class PRED_$match_type_2_var_7 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_8, _$match_type_2_var_8);
    }
}

class PRED_$match_type_2_var_8 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_9, _$match_type_2_var_9);
    }
}

class PRED_$match_type_2_var_9 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_10, _$match_type_2_var_10);
    }
}

class PRED_$match_type_2_var_10 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_11, _$match_type_2_var_11);
    }
}

class PRED_$match_type_2_var_11 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_12, _$match_type_2_var_12);
    }
}

class PRED_$match_type_2_var_12 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_13, _$match_type_2_var_13);
    }
}

class PRED_$match_type_2_var_13 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_14, _$match_type_2_var_14);
    }
}

class PRED_$match_type_2_var_14 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_15, _$match_type_2_var_15);
    }
}

class PRED_$match_type_2_var_15 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_16, _$match_type_2_var_16);
    }
}

class PRED_$match_type_2_var_16 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_17, _$match_type_2_var_17);
    }
}

class PRED_$match_type_2_var_17 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_18, _$match_type_2_var_18);
    }
}

class PRED_$match_type_2_var_18 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$match_type_2_19, _$match_type_2_var_19);
    }
}

class PRED_$match_type_2_var_19 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$match_type_2_20);
    }
}

class PRED_$match_type_2_con extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(con, _fail_0);
    }
}

class PRED_$match_type_2_1 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(term,A):-true
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(term,A):-[]
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

class PRED_$match_type_2_2 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(variable,A):-var(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(variable,A):-[var(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s2))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s2, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of var(a(2))
        a2 = a2.dereference();
        if (! a2.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_3 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(atom,A):-atom(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(atom,A):-[atom(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s3))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s3, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of atom(a(2))
        a2 = a2.dereference();
        if (! a2.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_4 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(atomic,A):-atomic(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(atomic,A):-[atomic(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s4))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s4, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of atomic(a(2))
        a2 = a2.dereference();
        if (! a2.isSymbol() && ! a2.isNumber()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_5 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(byte,A):-integer(A),0=<A,A=<255
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(byte,A):-[integer(A),'$less_or_equal'(0,A),'$less_or_equal'(A,255)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s5))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s5, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of integer(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(si(6),a(2))
        try {
            if (si6.arithCompareTo(Arithmetic.evaluate(a2)) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(a(2),si(7))
        try {
            if (Arithmetic.evaluate(a2).arithCompareTo(si7) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_6 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(in_byte,A):-integer(A),-1=<A,A=<255
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(in_byte,A):-[integer(A),'$less_or_equal'(-1,A),'$less_or_equal'(A,255)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s8))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s8, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of integer(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(si(9),a(2))
        try {
            if (si9.arithCompareTo(Arithmetic.evaluate(a2)) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(a(2),si(7))
        try {
            if (Arithmetic.evaluate(a2).arithCompareTo(si7) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_7 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(character,A):-atom(A),atom_length(A,1)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(character,A):-[atom(A),atom_length(A,1)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s10))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s10, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of atom(a(2))
        a2 = a2.dereference();
        if (! a2.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        return new PRED_atom_length_2(a2, si11, cont);
    }
}

class PRED_$match_type_2_8 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(in_character,A):-'$dummy_32_builtins.pl'(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(in_character,A):-['$dummy_32_builtins.pl'(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s12))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s12, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_$dummy_32_builtins$002Epl_1(a2, cont);
    }
}

class PRED_$match_type_2_9 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(number,A):-number(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(number,A):-[number(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s13))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s13, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of number(a(2))
        a2 = a2.dereference();
        if (! a2.isNumber()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_10 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(integer,A):-integer(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(integer,A):-[integer(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s14))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s14, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of integer(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_11 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(float,A):-float(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(float,A):-[float(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s15))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s15, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of float(a(2))
        a2 = a2.dereference();
        if (! a2.isDouble()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_12 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(callable,A):-callable(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(callable,A):-[callable(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s16))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s16, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_callable_1(a2, cont);
    }
}

class PRED_$match_type_2_13 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(compound,A):-compound(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(compound,A):-[compound(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s17))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s17, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_compound_1(a2, cont);
    }
}

class PRED_$match_type_2_14 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(list,A):-nonvar(A),'$dummy_33_builtins.pl'(B,C,A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(list,A):-[nonvar(A),'$dummy_33_builtins.pl'(B,C,A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s18))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s18, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of nonvar(a(2))
        a2 = a2.dereference();
        if (a2.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        return new PRED_$dummy_33_builtins$002Epl_3(new VariableTerm(engine), new VariableTerm(engine), a2, cont);
    }
}

class PRED_$match_type_2_15 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(java,A):-java(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(java,A):-[java(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s19))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s19, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of java(a(2))
        a2 = a2.dereference();
        if (! a2.isJavaObject()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_16 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(stream,A):-'$dummy_34_builtins.pl'(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(stream,A):-['$dummy_34_builtins.pl'(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s20))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s20, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_$dummy_34_builtins$002Epl_1(a2, cont);
    }
}

class PRED_$match_type_2_17 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(stream_or_alias,A):-'$dummy_35_builtins.pl'(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(stream_or_alias,A):-['$dummy_35_builtins.pl'(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s21))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s21, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_$dummy_35_builtins$002Epl_1(a2, cont);
    }
}

class PRED_$match_type_2_18 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(hash,A):-java(A,'jp.ac.kobe_u.cs.prolog.lang.HashtableOfTerm')
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(hash,A):-[java(A,'jp.ac.kobe_u.cs.prolog.lang.HashtableOfTerm')]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s22))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s22, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of java(a(2),s(23))
        a2 = a2.dereference();
        if (! a2.isJavaObject()) {
            return engine.fail();
        }
        if (! s23.unify(SymbolTerm.makeSymbol(((JavaObjectTerm) a2).object().getClass().getName()), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$match_type_2_19 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(hash_or_alias,A):-'$dummy_36_builtins.pl'(A)
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(hash_or_alias,A):-['$dummy_36_builtins.pl'(A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s24))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s24, engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_$dummy_36_builtins$002Epl_1(a2, cont);
    }
}

class PRED_$match_type_2_20 extends PRED_$match_type_2 {
    public Predicate exec(Prolog engine) {
    // '$match_type'(predicate_indicator,A):-nonvar(A),A=B:C/D,atom(B),atom(C),integer(D)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$match_type'(predicate_indicator,A):-[nonvar(A),'$unify'(A,B:C/D),atom(B),atom(C),integer(D)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s25))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s25, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of nonvar(a(2))
        a2 = a2.dereference();
        if (a2.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        a3 = new VariableTerm(engine);
        a4 = new VariableTerm(engine);
        a5 = new VariableTerm(engine);
        Term[] y1 = {a4, a5};
        a6 = new StructureTerm(s27, y1);
        Term[] y2 = {a3, a6};
        a7 = new StructureTerm(s26, y2);
        //START inline expansion of $unify(a(2),a(7))
        if (! a2.unify(a7, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of atom(a(3))
        a3 = a3.dereference();
        if (! a3.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of atom(a(4))
        a4 = a4.dereference();
        if (! a4.isSymbol()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of integer(a(5))
        a5 = a5.dereference();
        if (! a5.isInteger()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
