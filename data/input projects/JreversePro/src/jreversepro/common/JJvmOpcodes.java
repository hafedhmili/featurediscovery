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
 */
package jreversepro.common;

public interface JJvmOpcodes {

    int OPCODE_NOP = 0x00;
    int OPCODE_ACONST_NULL = 0x01;
    int OPCODE_ICONST_M1 = 0x02;
    int OPCODE_ICONST_0 = 0x03;
    int OPCODE_ICONST_1 = 0x04;
    int OPCODE_ICONST_2 = 0x05;
    int OPCODE_ICONST_3 = 0x06;
    int OPCODE_ICONST_4 = 0x07;
    int OPCODE_ICONST_5 = 0x08;
    int OPCODE_LCONST_0 = 0x09;
    int OPCODE_LCONST_1 = 0x0a;
    int OPCODE_FCONST_0 = 0x0b;
    int OPCODE_FCONST_1 = 0x0c;
    int OPCODE_FCONST_2 = 0x0d;
    int OPCODE_DCONST_0 = 0x0e;
    int OPCODE_DCONST_1 = 0x0f;
    int OPCODE_BIPUSH = 0x10;
    int OPCODE_SIPUSH = 0x11;
    int OPCODE_LDC = 0x12;
    int OPCODE_LDC_W = 0x13;
    int OPCODE_LDC2_W = 0x14;
    int OPCODE_ILOAD = 0x15;
    int OPCODE_LLOAD = 0x16;
    int OPCODE_FLOAD = 0x17;
    int OPCODE_DLOAD = 0x18;
    int OPCODE_ALOAD = 0x19;
    int OPCODE_ILOAD_0 = 0x1a;
    int OPCODE_ILOAD_1 = 0x1b;
    int OPCODE_ILOAD_2 = 0x1c;
    int OPCODE_ILOAD_3 = 0x1d;
    int OPCODE_LLOAD_0 = 0x1e;
    int OPCODE_LLOAD_1 = 0x1f;
    int OPCODE_LLOAD_2 = 0x20;
    int OPCODE_LLOAD_3 = 0x21;
    int OPCODE_FLOAD_0 = 0x22;
    int OPCODE_FLOAD_1 = 0x23;
    int OPCODE_FLOAD_2 = 0x24;
    int OPCODE_FLOAD_3 = 0x25;
    int OPCODE_DLOAD_0 = 0x26;
    int OPCODE_DLOAD_1 = 0x27;
    int OPCODE_DLOAD_2 = 0x28;
    int OPCODE_DLOAD_3 = 0x29;
    int OPCODE_ALOAD_0 = 0x2a;
    int OPCODE_ALOAD_1 = 0x2b;
    int OPCODE_ALOAD_2 = 0x2c;
    int OPCODE_ALOAD_3 = 0x2d;
    int OPCODE_IALOAD = 0x2e;
    int OPCODE_LALOAD = 0x2f;
    int OPCODE_FALOAD = 0x30;
    int OPCODE_DALOAD = 0x31;
    int OPCODE_AALOAD = 0x32;
    int OPCODE_BALOAD = 0x33;
    int OPCODE_CALOAD = 0x34;
    int OPCODE_SALOAD = 0x35;
    int OPCODE_ISTORE = 0x36;
    int OPCODE_LSTORE = 0x37;
    int OPCODE_FSTORE = 0x38;
    int OPCODE_DSTORE = 0x39;
    int OPCODE_ASTORE = 0x3a;
    int OPCODE_ISTORE_0 = 0x3b;
    int OPCODE_ISTORE_1 = 0x3c;
    int OPCODE_ISTORE_2 = 0x3d;
    int OPCODE_ISTORE_3 = 0x3e;
    int OPCODE_LSTORE_0 = 0x3f;
    int OPCODE_LSTORE_1 = 0x40;
    int OPCODE_LSTORE_2 = 0x41;
    int OPCODE_LSTORE_3 = 0x42;
    int OPCODE_FSTORE_0 = 0x43;
    int OPCODE_FSTORE_1 = 0x44;
    int OPCODE_FSTORE_2 = 0x45;
    int OPCODE_FSTORE_3 = 0x46;
    int OPCODE_DSTORE_0 = 0x47;
    int OPCODE_DSTORE_1 = 0x48;
    int OPCODE_DSTORE_2 = 0x49;
    int OPCODE_DSTORE_3 = 0x4a;
    int OPCODE_ASTORE_0 = 0x4b;
    int OPCODE_ASTORE_1 = 0x4c;
    int OPCODE_ASTORE_2 = 0x4d;
    int OPCODE_ASTORE_3 = 0x4e;
    int OPCODE_IASTORE = 0x4f;
    int OPCODE_LASTORE = 0x50;
    int OPCODE_FASTORE = 0x51;
    int OPCODE_DASTORE = 0x52;
    int OPCODE_AASTORE = 0x53;
    int OPCODE_BASTORE = 0x54;
    int OPCODE_CASTORE = 0x55;
    int OPCODE_SASTORE = 0x56;
    int OPCODE_POP = 0x57;
    int OPCODE_POP2 = 0x58;
    int OPCODE_DUP = 0x59;
    int OPCODE_DUP_X1 = 0x5a;
    int OPCODE_DUP_X2 = 0x5b;
    int OPCODE_DUP2 = 0x5c;
    int OPCODE_DUP2_X1 = 0x5d;
    int OPCODE_DUP2_X2 = 0x5e;
    int OPCODE_SWAP = 0x5f;
    int OPCODE_IADD = 0x60;
    int OPCODE_LADD = 0x61;
    int OPCODE_FADD = 0x62;
    int OPCODE_DADD = 0x63;
    int OPCODE_ISUB = 0x64;
    int OPCODE_LSUB = 0x65;
    int OPCODE_FSUB = 0x66;
    int OPCODE_DSUB = 0x67;
    int OPCODE_IMUL = 0x68;
    int OPCODE_LMUL = 0x69;
    int OPCODE_FMUL = 0x6a;
    int OPCODE_DMUL = 0x6b;
    int OPCODE_IDIV = 0x6c;
    int OPCODE_LDIV = 0x6d;
    int OPCODE_FDIV = 0x6e;
    int OPCODE_DDIV = 0x6f;
    int OPCODE_IREM = 0x70;
    int OPCODE_LREM = 0x71;
    int OPCODE_FREM = 0x72;
    int OPCODE_DREM = 0x73;
    int OPCODE_INEG = 0x74;
    int OPCODE_LNEG = 0x75;
    int OPCODE_FNEG = 0x76;
    int OPCODE_DNEG = 0x77;
    int OPCODE_ISHL = 0x78;
    int OPCODE_LSHL = 0x79;
    int OPCODE_ISHR = 0x7a;
    int OPCODE_LSHR = 0x7b;
    int OPCODE_IUSHR = 0x7c;
    int OPCODE_LUSHR = 0x7d;
    int OPCODE_IAND = 0x7e;
    int OPCODE_LAND = 0x7f;
    int OPCODE_IOR = 0x80;
    int OPCODE_LOR = 0x81;
    int OPCODE_IXOR = 0x82;
    int OPCODE_LXOR = 0x83;
    int OPCODE_IINC = 0x84;
    int OPCODE_I2L = 0x85;
    int OPCODE_I2F = 0x86;
    int OPCODE_I2D = 0x87;
    int OPCODE_L2I = 0x88;
    int OPCODE_L2F = 0x89;
    int OPCODE_L2D = 0x8a;
    int OPCODE_F2I = 0x8b;
    int OPCODE_F2L = 0x8c;
    int OPCODE_F2D = 0x8d;
    int OPCODE_D2I = 0x8e;
    int OPCODE_D2L = 0x8f;
    int OPCODE_D2F = 0x90;
    int OPCODE_I2B = 0x91;
    int OPCODE_I2C = 0x92;
    int OPCODE_I2S = 0x93;
    int OPCODE_LCMP = 0x94;
    int OPCODE_FCMPL = 0x95;
    int OPCODE_FCMPG = 0x96;
    int OPCODE_DCMPL = 0x97;
    int OPCODE_DCMPG = 0x98;
    int OPCODE_IFEQ = 0x99;
    int OPCODE_IFNE = 0x9a;
    int OPCODE_IFLT = 0x9b;
    int OPCODE_IFGE = 0x9c;
    int OPCODE_IFGT = 0x9d;
    int OPCODE_IFLE = 0x9e;
    int OPCODE_IF_ICMPEQ = 0x9f;
    int OPCODE_IF_ICMPNE = 0xa0;
    int OPCODE_IF_ICMPLT = 0xa1;
    int OPCODE_IF_ICMPGE = 0xa2;
    int OPCODE_IF_ICMPGT = 0xa3;
    int OPCODE_IF_ICMPLE = 0xa4;
    int OPCODE_IF_ACMPEQ = 0xa5;
    int OPCODE_IF_ACMPNE = 0xa6;
    int OPCODE_GOTO = 0xa7;
    int OPCODE_JSR = 0xa8;
    int OPCODE_RET = 0xa9;
    int OPCODE_TABLESWITCH = 0xaa;
    int OPCODE_LOOKUPSWITCH = 0xab;
    int OPCODE_IRETURN = 0xac;
    int OPCODE_LRETURN = 0xad;
    int OPCODE_FRETURN = 0xae;
    int OPCODE_DRETURN = 0xaf;
    int OPCODE_ARETURN = 0xb0;
    int OPCODE_RETURN = 0xb1;
    int OPCODE_GETSTATIC = 0xb2;
    int OPCODE_PUTSTATIC = 0xb3;
    int OPCODE_GETFIELD = 0xb4;
    int OPCODE_PUTFIELD = 0xb5;
    int OPCODE_INVOKEVIRTUAL = 0xb6;
    int OPCODE_INVOKESPECIAL = 0xb7;
    int OPCODE_INVOKESTATIC = 0xb8;
    int OPCODE_INVOKEINTERFACE = 0xb9;
    int OPCODE_XXXUNUSEDXXX = 0xba;
    int OPCODE_NEW = 0xbb;
    int OPCODE_NEWARRAY = 0xbc;
    int OPCODE_ANEWARRAY = 0xbd;
    int OPCODE_ARRAYLENGTH = 0xbe;
    int OPCODE_ATHROW = 0xbf;
    int OPCODE_CHECKCAST = 0xc0;
    int OPCODE_INSTANCEOF = 0xc1;
    int OPCODE_MONITORENTER = 0xc2;
    int OPCODE_MONITOREXIT = 0xc3;
    int OPCODE_WIDE = 0xc4;
    int OPCODE_MULTIANEWARRAY = 0xc5;
    int OPCODE_IFNULL = 0xc6;
    int OPCODE_IFNONNULL = 0xc7;
    int OPCODE_GOTOW = 0xc8;
    int OPCODE_JSRW = 0xc9;
}