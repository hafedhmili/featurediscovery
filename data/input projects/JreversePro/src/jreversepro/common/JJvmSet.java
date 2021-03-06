/*
 * @(#)JJvmSet.java
 *
 * JReversePro - Java Decompiler / Disassembler.
 * Copyright (C) 2000 2001 Karthik Kumar.
 * EMail: akkumar@users.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or modify
 * it , under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.If not, write to
 *  The Free Software Foundation, Inc.,
 *  59 Temple Place - Suite 330,
 *  Boston, MA 02111-1307, USA.
 **/
package jreversepro.common;

/**
 * This contains the instruction set of the JVM.
 * @author Karthik Kumar
 **/
public class JJvmSet implements  JJvmOpcodes {

    /**
     * sOpCode array contains the sOpCode string for each
     * opcode.
     **/
    private static String[] sOpCode;

    /**
     * sLength array contains the length of each opcode.
     **/
    private static int [] sLength;

    /**
     * Length of the variable length opcode tableswitch
     **/
    public static final int TABLE_LEN = -2;

    /**
     * Length of the variable length opcode lookupswitch
     **/
    public static final int LOOKUP_LEN = -3;

    /**
     * Private constructor to prevent creation of instance.
     **/
    private JJvmSet() { }
    // Not to be instantiated.

    /**
     * Initializes thr JVM Opcode set.
     **/
    static  {
        sOpCode = new String[256];
        sLength = new int[256];

        assign0();
        assign1();
        assign2();
        assign3();
        assign4();

        assign5();
        assign6();
        assign7();
        assign8();
        assign9();

        assign10();
        assign11();
        assign12();
        assign13();
        assign14();
    }

    /**
     * Returns the OpCode string.
     * @param index Index of the Opcode
     * @return Returns the OpCode string corresponding to
     * the opcode aIndex.
     **/
    public static final String getIns(int index) {
        return sOpCode[index];
    }


    /**
     * Returns the OpCode Length.
     * @param index Index of the Opcode
     * @param wide Wide instruction.
     * @return Returns the Length of the JVM Instruction with
     * this opcode.
     **/
    public static final int getInsLen(int index, boolean wide) {
        // wide instructions
        switch (index) {
            case OPCODE_ILOAD:
            case OPCODE_LLOAD:
            case OPCODE_FLOAD:
            case OPCODE_DLOAD:
            case OPCODE_ALOAD:
            case OPCODE_ISTORE:
            case OPCODE_LSTORE:
            case OPCODE_FSTORE:
            case OPCODE_DSTORE:
            case OPCODE_ASTORE:
            case OPCODE_RET:
                if (wide) {
                    return sLength[index] + 1;
                }
                break;
            case OPCODE_IINC:
                if (wide) {
                    return sLength[index] + 2;
                }
                break;
        }
        return sLength[index];
    }

    /**
     * Assigns opcode information for opcodes 0-15.
     **/
    private static void assign0() {
        int l = 0;

        sOpCode[l] = "nop";
        sLength[l] = 1;

        sOpCode[l + 1] = "aconst_null";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "iconst_ml";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "iconst_0";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "iconst_1";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "iconst_2";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "iconst_3";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "iconst_4";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "iconst_5";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "lconst_0";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "lconst_1";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "fconst_0";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "fconst_1";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "fconst_2";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "dconst_0";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "dconst_1";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 16-31
     **/
    private static void assign1() {
        int l = 16;

        sOpCode[l] = "bipush";
        sLength[l] = 2;

        sOpCode[l + 1] = "sipush";
        sLength[l + 1] = 3;

        sOpCode[l + 2] = "ldc";
        sLength[l + 2] = 2;

        sOpCode[l + 3] = "ldc_w";
        sLength[l + 3] = 3;

        sOpCode[l + 4] = "ldc2_w";
        sLength[l + 4] = 3;

        sOpCode[l + 5] = "iload";
        sLength[l + 5] = 2;

        sOpCode[l + 6] = "lload";
        sLength[l + 6] = 2;

        sOpCode[l + 7] = "fload";
        sLength[l + 7] = 2;

        sOpCode[l + 8] = "dload";
        sLength[l + 8] = 2;

        sOpCode[l + 9] = "aload";
        sLength[l + 9] = 2;

        sOpCode[l + 10] = "iload_0";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "iload_1";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "iload_2";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "iload_3";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "lload_0";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "lload_1";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 32-47
     **/
    private static void assign2() {
        int l = 32;

        sOpCode[l] = "lload_2";
        sLength[l] = 1;

        sOpCode[l + 1] = "lload_3";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "fload_0";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "fload_1";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "fload_2";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "fload_3";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "dload_0";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "dload_1";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "dload_2";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "dload_3";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "aload_0";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "aload_1";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "aload_2";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "aload_3";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "iaload";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "laload";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 48-63
     **/
    private static void assign3() {
        int l = 48;

        sOpCode[l] = "faload";
        sLength[l] = 1;

        // Load from array
        sOpCode[l + 1] = "daload";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "aaload";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "baload";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "caload";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "saload";
        sLength[l + 5] = 1;

        // Store int to a local variable
        sOpCode[l + 6] = "istore";
        sLength[l + 6] = 2;

        sOpCode[l + 7] = "lstore";
        sLength[l + 7] = 2;

        sOpCode[l + 8] = "fstore";
        sLength[l + 8] = 2;

        sOpCode[l + 9] = "dstore";
        sLength[l + 9] = 2;

        sOpCode[l + 10] = "astore";
        sLength[l + 10] = 2;

        sOpCode[l + 11] = "istore_0";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "istore_1";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "istore_2";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "istore_3";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "lstore_0";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 64-79
     **/
    private static void assign4() {
        int l = 64;

        sOpCode[l] = "lstore_1";
        sLength[l] = 1;

        // Load from array
        sOpCode[l + 1] = "lstore_2";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "lstore_3";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "fstore_0";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "fstore_1";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "fstore_2";
        sLength[l + 5] = 1;

        // Store int to a local variable
        sOpCode[l + 6] = "fstore_3";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "dstore_0";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "dstore_1";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "dstore_2";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "dstore_3";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "astore_0";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "astore_1";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "astore_2";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "astore_3";
        sLength[l + 14] = 1;

        // Store into array
        sOpCode[l + 15] = "iastore";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 80-95
     **/
    private static void assign5() {
        int l = 80;

        sOpCode[l] = "lastore";
        sLength[l] = 1;

        // Store to array
        sOpCode[l + 1] = "fastore";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "dastore";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "aastore";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "bastore";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "castore";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "sastore";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "pop";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "pop2";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "dup";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "dup_x1";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "dup_x2";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "dup2";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "dup2_x1";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "dup2_x2";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "swap";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 96-111.
     **/
    private static void assign6() {
        int l = 96;

        sOpCode[l] = "iadd";
        sLength[l] = 1;

        sOpCode[l + 1] = "ladd";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "fadd";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "dadd";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "isub";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "lsub";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "fsub";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "dsub";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "imul";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "lmul";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "fmul";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "dmul";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "idiv";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "ldiv";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "fdiv";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "ddiv";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 112-127.
     **/
    private static void assign7() {
        int l = 112;

        // Integer remainder
        sOpCode[l] = "irem";
        sLength[l] = 1;

        sOpCode[l + 1] = "lrem";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "frem";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "drem";
        sLength[l + 3] = 1;

        // Negate int
        sOpCode[l + 4] = "ineg";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "lneg";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "fneg";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "dneg";
        sLength[l + 7] = 1;

        // Shift left
        sOpCode[l + 8] = "ishl";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "lshl";
        sLength[l + 9] = 1;

        // Shift right
        sOpCode[l + 10] = "ishr";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "lshr";
        sLength[l + 11] = 1;

        // Logical shift right
        sOpCode[l + 12] = "iushr";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "lushr";
        sLength[l + 13] = 1;

        // Boolean AND int
        sOpCode[l + 14] = "iand";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "land";
        sLength[l + 15] = 1;
    }

    /**
     * Assigns opcode information for opcodes 128-143.
     **/
    private static void assign8() {
        int l = 128;

        // OR int
        sOpCode[l] = "ior";
        sLength[l] = 1;

        sOpCode[l + 1] = "lor";
        sLength[l + 1] = 1;

        // XOR op.
        sOpCode[l + 2] = "ixor";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "lxor";
        sLength[l + 3] = 1;

        // Increment local variable
        sOpCode[l + 4] = "iinc";
        sLength[l + 4] = 3;

        // Conversions
        sOpCode[l + 5] = "i2l";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "i2f";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "i2d";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "l2i";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "l2f";
        sLength[l + 9] = 1;

        sOpCode[l + 10] = "l2d";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "f2i";
        sLength[l + 11] = 1;

        sOpCode[l + 12] = "f2l";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "f2d";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "d2i";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "d2l";
        sLength[l + 15] = 1;
    }


    /**
     * Assigns opcode information for opcodes 144-159.
     **/
    private static void assign9() {
        int l = 144;

        // Conversions
        sOpCode[l] = "d2f";
        sLength[l] = 1;

        sOpCode[l + 1] = "i2b";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "i2c";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "i2s";
        sLength[l + 3] = 1;

        // Compare
        sOpCode[l + 4] = "lcmp";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "fcmpl";
        sLength[l + 5] = 1;

        sOpCode[l + 6] = "fcmpg";
        sLength[l + 6] = 1;

        sOpCode[l + 7] = "dcmpl";
        sLength[l + 7] = 1;

        sOpCode[l + 8] = "dcmpg";
        sLength[l + 8] = 1;

        sOpCode[l + 9] = "ifeq";
        sLength[l + 9] = 3;

        sOpCode[l + 10] = "ifne";
        sLength[l + 10] = 3;

        sOpCode[l + 11] = "iflt";
        sLength[l + 11] = 3;

        sOpCode[l + 12] = "ifge";
        sLength[l + 12] = 3;

        sOpCode[l + 13] = "ifgt";
        sLength[l + 13] = 3;

        sOpCode[l + 14] = "ifle";
        sLength[l + 14] = 3;

        sOpCode[l + 15] = "if_icmpeq";
        sLength[l + 15] = 3;
    }


    /**
     * Assigns opcode information for opcodes 160-175
     **/
    private static void assign10() {
        int l = 160;

        sOpCode[l] = "if_icmpne";
        sLength[l] = 3;

        sOpCode[l + 1] = "if_icmplt";
        sLength[l + 1] = 3;

        sOpCode[l + 2] = "if_icmpge";
        sLength[l + 2] = 3;

        sOpCode[l + 3] = "if_cmpgt";
        sLength[l + 3] = 3;

        sOpCode[l + 4] = "if_icmple";
        sLength[l + 4] = 3;

        sOpCode[l + 5] = "if_acmpeq";
        sLength[l + 5] = 3;

        sOpCode[l + 6] = "if_acmpne";
        sLength[l + 6] = 3;

        sOpCode[l + 7] = "goto";
        sLength[l + 7] = 3;

        sOpCode[l + 8] = "jsr";
        sLength[l + 8] = 3;

        sOpCode[l + 9] = "ret";
        sLength[l + 9] = 2;

        sOpCode[l + 10] = "tableswitch";
        sLength[l + 10] = TABLE_LEN;
        // Variable size instruction - 170

        sOpCode[l + 11] = "lookupswitch";
        sLength[l + 11] = LOOKUP_LEN;
        // Variable size instruction - 171

        sOpCode[l + 12] = "ireturn";
        sLength[l + 12] = 1;

        sOpCode[l + 13] = "lreturn";
        sLength[l + 13] = 1;

        sOpCode[l + 14] = "freturn";
        sLength[l + 14] = 1;

        sOpCode[l + 15] = "dreturn";
        sLength[l + 15] = 1;
    }


    /**
     * Assigns opcode information for opcodes 176-191
     **/
    private static void assign11() {
        int l = 176;

        sOpCode[l] = "areturn";
        sLength[l] = 1;

        sOpCode[l + 1] = "return";
        sLength[l + 1] = 1;

        sOpCode[l + 2] = "getstatic";
        sLength[l + 2] = 3;

        sOpCode[l + 3] = "putstatic";
        sLength[l + 3] = 3;

        sOpCode[l + 4] = "getfield";
        sLength[l + 4] = 3;

        sOpCode[l + 5] = "putfield";
        sLength[l + 5] = 3;

        sOpCode[l + 6] = "invokevirtual";
        sLength[l + 6] = 3;

        sOpCode[l + 7] = "invokespecial";
        sLength[l + 7] = 3;

        sOpCode[l + 8] = "invokestatic";
        sLength[l + 8] = 3;

        sOpCode[l + 9] = "invokeinterface";
        sLength[l + 9] = 5;

        sOpCode[l + 10] = "xxxunusedxxx";
        sLength[l + 10] = 1;

        sOpCode[l + 11] = "new";
        sLength[l + 11] = 3;

        sOpCode[l + 12] = "newarray";
        sLength[l + 12] = 2;

        sOpCode[l + 13] = "anewarray";
        sLength[l + 13] = 3;

        // Get length
        sOpCode[l + 14] = "arraylength";
        sLength[l + 14] = 1;

        // Throw exception or error
        sOpCode[l + 15] = "athrow";
        sLength[l + 15] = 1;
    }


    /**
     * Assigns opcode information for opcodes 192-207
     **/
    private static void assign12() {
        int l = 192;

        sOpCode[l] = "checkcast";
        sLength[l] = 3;

        sOpCode[l + 1] = "instanceof";
        sLength[l + 1] = 3;

        sOpCode[l + 2] = "monitorenter";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "monitorexit";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "wide";
        sLength[l + 4] = 1;

        sOpCode[l + 5] = "multianewarray";
        sLength[l + 5] = 4;

        sOpCode[l + 6] = "ifnull";
        sLength[l + 6] = 3;

        sOpCode[l + 7] = "ifnonnull";
        sLength[l + 7] = 3;

        sOpCode[l + 8] = "goto_w";
        sLength[l + 8] = 5;

        sOpCode[l + 9] = "jsr_w";
        sLength[l + 9] = 5;

        sOpCode[l + 10] = "_quick";
        sLength[l + 10] = 1;

        // Quick instructions
        sOpCode[l + 11] = "ldc_quick";
        sLength[l + 11] = 2;

        sOpCode[l + 12] = "ldc_w_quick";
        sLength[l + 12] = 3;

        sOpCode[l + 13] = "ldc2_w_quick";
        sLength[l + 13] = 3;

        // Get length
        sOpCode[l + 14] = "getfield_quick";
        sLength[l + 14] = 3;

        sOpCode[l + 15] = "putfield_quick";
        sLength[l + 15] = 3;
    }


    /**
     * Assigns opcode information for opcodes 208-223
     **/
    private static void assign13() {
        int l = 208;

        sOpCode[l] = "getfield2_quick";
        sLength[l] = 3;

        sOpCode[l + 1] = "putfield2_quick";
        sLength[l + 1] = 3;

        sOpCode[l + 2] = "getstatic_quick";
        sLength[l + 2] = 1;

        sOpCode[l + 3] = "putstatic_quick";
        sLength[l + 3] = 1;

        sOpCode[l + 4] = "getstatic2_quick";
        sLength[l + 4] = 3;

        sOpCode[l + 5] = "putstatic2_quick";
        sLength[l + 5] = 4;

        sOpCode[l + 6] = "invokevirtual_quick";
        sLength[l + 6] = 3;

        sOpCode[l + 7] = "invokenonvirtual_quick";
        sLength[l + 7] = 3;

        sOpCode[l + 8] = "invokesuper_quick";
        sLength[l + 8] = 3;

        sOpCode[l + 9] = "invokestatic_quick";
        sLength[l + 9] = 3;

        sOpCode[l + 10] = "invokeinterface_quick";
        sLength[l + 10] = 5;

        sOpCode[l + 11] = "invokevirtualobject_quick";
        sLength[l + 11] = 3;

        sOpCode[l + 12] = "220-Undefined";
        sLength[l + 12] = 1;
        // cafe babe

        sOpCode[l + 13] = "new_quick";
        sLength[l + 13] = 3;

        sOpCode[l + 14] = "anewarray_quick";
        sLength[l + 14] = 3;

        sOpCode[l + 15] = "multianewarray_quick";
        sLength[l + 15] = 4;
    }


    /**
     * Assigns opcode information for opcodes 224-255.
     **/
    private static void assign14() {
        int l = 224;

        sOpCode[l] = "checkcast_quick";
        sLength[l] = 3;

        sOpCode[l + 1] = "instanceof_quick";
        sLength[l + 1] = 3;

        sOpCode[l + 2] = "invokevirtual_quick_w";
        sLength[l + 2] = 3;

        sOpCode[l + 3] = "getfield_quick_w";
        sLength[l + 3] = 3;

        sOpCode[l + 4] = "putfield_quick_w";
        sLength[l + 4] = 3;

        // Reserved  Op-codes
        sOpCode[202] = "breakpoint";
        sLength[202] = 1;

        sOpCode[254] = "impdep1";
        sLength[254] = 1;

        sOpCode[255] = "impdep2";
        sLength[255] = 1;
    }
}
