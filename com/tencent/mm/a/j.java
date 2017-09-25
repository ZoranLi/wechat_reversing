package com.tencent.mm.a;

import com.qq.taf.jce.JceStruct;

public final class j {
    private static void a(i iVar, i iVar2, i iVar3) {
        for (int i = 0; i < 8; i++) {
            iVar.fuP[iVar.fuQ + i] = (byte) (iVar2.fuP[iVar2.fuQ + i] ^ iVar3.fuP[iVar3.fuQ + i]);
        }
    }

    private static void a(i iVar, i iVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = iVar.fuP;
            int i3 = iVar.fuQ + i2;
            bArr[i3] = (byte) (bArr[i3] ^ iVar2.fuP[iVar2.fuQ + i2]);
        }
    }

    private static void b(i iVar, i iVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            iVar.fuP[iVar.fuQ + i2] = (byte) ((iVar2.fuP[(i2 >> 3) + iVar2.fuQ] >> (i2 & 7)) & 1);
        }
    }

    private static void c(i iVar, i iVar2, int i) {
        int i2 = 0;
        d(iVar2, iVar, i);
        for (int i3 = 0; i3 < 28 - i; i3++) {
            iVar.fuP[iVar.fuQ + i3] = iVar.fuP[(iVar.fuQ + i3) + i];
        }
        while (i2 < i) {
            iVar.fuP[((iVar.fuQ + i2) + 28) - i] = iVar2.fuP[iVar2.fuQ + i2];
            i2++;
        }
    }

    private static void a(i iVar, i iVar2, byte[] bArr, int i, i iVar3) {
        for (int i2 = 0; i2 < i; i2++) {
            iVar3.fuP[iVar3.fuQ + i2] = iVar2.fuP[(iVar2.fuQ + bArr[i2]) - 1];
        }
        d(iVar, iVar3, i);
    }

    private static void a(i iVar, i iVar2, i iVar3, i iVar4) {
        int i = 0;
        byte[] bArr = new byte[]{(byte) 16, (byte) 7, (byte) 20, (byte) 21, (byte) 29, JceStruct.ZERO_TAG, (byte) 28, (byte) 17, (byte) 1, (byte) 15, (byte) 23, (byte) 26, (byte) 5, (byte) 18, (byte) 31, (byte) 10, (byte) 2, (byte) 8, (byte) 24, (byte) 14, (byte) 32, (byte) 27, (byte) 3, (byte) 9, (byte) 19, JceStruct.SIMPLE_LIST, (byte) 30, (byte) 6, (byte) 22, JceStruct.STRUCT_END, (byte) 4, (byte) 25};
        a(iVar3, iVar, new byte[]{(byte) 32, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 8, (byte) 9, (byte) 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 1}, 48, iVar4);
        a(iVar3, iVar2, 48);
        r1 = new byte[8][][];
        r1[0] = new byte[][]{new byte[]{(byte) 14, (byte) 4, JceStruct.SIMPLE_LIST, (byte) 1, (byte) 2, (byte) 15, JceStruct.STRUCT_END, (byte) 8, (byte) 3, (byte) 10, (byte) 6, JceStruct.ZERO_TAG, (byte) 5, (byte) 9, (byte) 0, (byte) 7}, new byte[]{(byte) 0, (byte) 15, (byte) 7, (byte) 4, (byte) 14, (byte) 2, JceStruct.SIMPLE_LIST, (byte) 1, (byte) 10, (byte) 6, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, (byte) 9, (byte) 5, (byte) 3, (byte) 8}, new byte[]{(byte) 4, (byte) 1, (byte) 14, (byte) 8, JceStruct.SIMPLE_LIST, (byte) 6, (byte) 2, JceStruct.STRUCT_END, (byte) 15, JceStruct.ZERO_TAG, (byte) 9, (byte) 7, (byte) 3, (byte) 10, (byte) 5, (byte) 0}, new byte[]{(byte) 15, JceStruct.ZERO_TAG, (byte) 8, (byte) 2, (byte) 4, (byte) 9, (byte) 1, (byte) 7, (byte) 5, JceStruct.STRUCT_END, (byte) 3, (byte) 14, (byte) 10, (byte) 0, (byte) 6, JceStruct.SIMPLE_LIST}};
        r1[1] = new byte[][]{new byte[]{(byte) 15, (byte) 1, (byte) 8, (byte) 14, (byte) 6, JceStruct.STRUCT_END, (byte) 3, (byte) 4, (byte) 9, (byte) 7, (byte) 2, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, (byte) 0, (byte) 5, (byte) 10}, new byte[]{(byte) 3, JceStruct.SIMPLE_LIST, (byte) 4, (byte) 7, (byte) 15, (byte) 2, (byte) 8, (byte) 14, JceStruct.ZERO_TAG, (byte) 0, (byte) 1, (byte) 10, (byte) 6, (byte) 9, JceStruct.STRUCT_END, (byte) 5}, new byte[]{(byte) 0, (byte) 14, (byte) 7, JceStruct.STRUCT_END, (byte) 10, (byte) 4, JceStruct.SIMPLE_LIST, (byte) 1, (byte) 5, (byte) 8, JceStruct.ZERO_TAG, (byte) 6, (byte) 9, (byte) 3, (byte) 2, (byte) 15}, new byte[]{JceStruct.SIMPLE_LIST, (byte) 8, (byte) 10, (byte) 1, (byte) 3, (byte) 15, (byte) 4, (byte) 2, JceStruct.STRUCT_END, (byte) 6, (byte) 7, JceStruct.ZERO_TAG, (byte) 0, (byte) 5, (byte) 14, (byte) 9}};
        r1[2] = new byte[][]{new byte[]{(byte) 10, (byte) 0, (byte) 9, (byte) 14, (byte) 6, (byte) 3, (byte) 15, (byte) 5, (byte) 1, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, (byte) 7, JceStruct.STRUCT_END, (byte) 4, (byte) 2, (byte) 8}, new byte[]{JceStruct.SIMPLE_LIST, (byte) 7, (byte) 0, (byte) 9, (byte) 3, (byte) 4, (byte) 6, (byte) 10, (byte) 2, (byte) 8, (byte) 5, (byte) 14, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, (byte) 15, (byte) 1}, new byte[]{JceStruct.SIMPLE_LIST, (byte) 6, (byte) 4, (byte) 9, (byte) 8, (byte) 15, (byte) 3, (byte) 0, JceStruct.STRUCT_END, (byte) 1, (byte) 2, JceStruct.ZERO_TAG, (byte) 5, (byte) 10, (byte) 14, (byte) 7}, new byte[]{(byte) 1, (byte) 10, JceStruct.SIMPLE_LIST, (byte) 0, (byte) 6, (byte) 9, (byte) 8, (byte) 7, (byte) 4, (byte) 15, (byte) 14, (byte) 3, JceStruct.STRUCT_END, (byte) 5, (byte) 2, JceStruct.ZERO_TAG}};
        r1[3] = new byte[][]{new byte[]{(byte) 7, JceStruct.SIMPLE_LIST, (byte) 14, (byte) 3, (byte) 0, (byte) 6, (byte) 9, (byte) 10, (byte) 1, (byte) 2, (byte) 8, (byte) 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, (byte) 4, (byte) 15}, new byte[]{JceStruct.SIMPLE_LIST, (byte) 8, JceStruct.STRUCT_END, (byte) 5, (byte) 6, (byte) 15, (byte) 0, (byte) 3, (byte) 4, (byte) 7, (byte) 2, JceStruct.ZERO_TAG, (byte) 1, (byte) 10, (byte) 14, (byte) 9}, new byte[]{(byte) 10, (byte) 6, (byte) 9, (byte) 0, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, (byte) 7, JceStruct.SIMPLE_LIST, (byte) 15, (byte) 1, (byte) 3, (byte) 14, (byte) 5, (byte) 2, (byte) 8, (byte) 4}, new byte[]{(byte) 3, (byte) 15, (byte) 0, (byte) 6, (byte) 10, (byte) 1, JceStruct.SIMPLE_LIST, (byte) 8, (byte) 9, (byte) 4, (byte) 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, (byte) 7, (byte) 2, (byte) 14}};
        r1[4] = new byte[][]{new byte[]{(byte) 2, JceStruct.ZERO_TAG, (byte) 4, (byte) 1, (byte) 7, (byte) 10, JceStruct.STRUCT_END, (byte) 6, (byte) 8, (byte) 5, (byte) 3, (byte) 15, JceStruct.SIMPLE_LIST, (byte) 0, (byte) 14, (byte) 9}, new byte[]{(byte) 14, JceStruct.STRUCT_END, (byte) 2, JceStruct.ZERO_TAG, (byte) 4, (byte) 7, JceStruct.SIMPLE_LIST, (byte) 1, (byte) 5, (byte) 0, (byte) 15, (byte) 10, (byte) 3, (byte) 9, (byte) 8, (byte) 6}, new byte[]{(byte) 4, (byte) 2, (byte) 1, JceStruct.STRUCT_END, (byte) 10, JceStruct.SIMPLE_LIST, (byte) 7, (byte) 8, (byte) 15, (byte) 9, JceStruct.ZERO_TAG, (byte) 5, (byte) 6, (byte) 3, (byte) 0, (byte) 14}, new byte[]{JceStruct.STRUCT_END, (byte) 8, JceStruct.ZERO_TAG, (byte) 7, (byte) 1, (byte) 14, (byte) 2, JceStruct.SIMPLE_LIST, (byte) 6, (byte) 15, (byte) 0, (byte) 9, (byte) 10, (byte) 4, (byte) 5, (byte) 3}};
        r1[5] = new byte[][]{new byte[]{JceStruct.ZERO_TAG, (byte) 1, (byte) 10, (byte) 15, (byte) 9, (byte) 2, (byte) 6, (byte) 8, (byte) 0, JceStruct.SIMPLE_LIST, (byte) 3, (byte) 4, (byte) 14, (byte) 7, (byte) 5, JceStruct.STRUCT_END}, new byte[]{(byte) 10, (byte) 15, (byte) 4, (byte) 2, (byte) 7, JceStruct.ZERO_TAG, (byte) 9, (byte) 5, (byte) 6, (byte) 1, JceStruct.SIMPLE_LIST, (byte) 14, (byte) 0, JceStruct.STRUCT_END, (byte) 3, (byte) 8}, new byte[]{(byte) 9, (byte) 14, (byte) 15, (byte) 5, (byte) 2, (byte) 8, JceStruct.ZERO_TAG, (byte) 3, (byte) 7, (byte) 0, (byte) 4, (byte) 10, (byte) 1, JceStruct.SIMPLE_LIST, JceStruct.STRUCT_END, (byte) 6}, new byte[]{(byte) 4, (byte) 3, (byte) 2, JceStruct.ZERO_TAG, (byte) 9, (byte) 5, (byte) 15, (byte) 10, JceStruct.STRUCT_END, (byte) 14, (byte) 1, (byte) 7, (byte) 6, (byte) 0, (byte) 8, JceStruct.SIMPLE_LIST}};
        r1[6] = new byte[][]{new byte[]{(byte) 4, JceStruct.STRUCT_END, (byte) 2, (byte) 14, (byte) 15, (byte) 0, (byte) 8, JceStruct.SIMPLE_LIST, (byte) 3, JceStruct.ZERO_TAG, (byte) 9, (byte) 7, (byte) 5, (byte) 10, (byte) 6, (byte) 1}, new byte[]{JceStruct.SIMPLE_LIST, (byte) 0, JceStruct.STRUCT_END, (byte) 7, (byte) 4, (byte) 9, (byte) 1, (byte) 10, (byte) 14, (byte) 3, (byte) 5, JceStruct.ZERO_TAG, (byte) 2, (byte) 15, (byte) 8, (byte) 6}, new byte[]{(byte) 1, (byte) 4, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, (byte) 3, (byte) 7, (byte) 14, (byte) 10, (byte) 15, (byte) 6, (byte) 8, (byte) 0, (byte) 5, (byte) 9, (byte) 2}, new byte[]{(byte) 6, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, (byte) 8, (byte) 1, (byte) 4, (byte) 10, (byte) 7, (byte) 9, (byte) 5, (byte) 0, (byte) 15, (byte) 14, (byte) 2, (byte) 3, JceStruct.ZERO_TAG}};
        r1[7] = new byte[][]{new byte[]{JceStruct.SIMPLE_LIST, (byte) 2, (byte) 8, (byte) 4, (byte) 6, (byte) 15, JceStruct.STRUCT_END, (byte) 1, (byte) 10, (byte) 9, (byte) 3, (byte) 14, (byte) 5, (byte) 0, JceStruct.ZERO_TAG, (byte) 7}, new byte[]{(byte) 1, (byte) 15, JceStruct.SIMPLE_LIST, (byte) 8, (byte) 10, (byte) 3, (byte) 7, (byte) 4, JceStruct.ZERO_TAG, (byte) 5, (byte) 6, JceStruct.STRUCT_END, (byte) 0, (byte) 14, (byte) 9, (byte) 2}, new byte[]{(byte) 7, JceStruct.STRUCT_END, (byte) 4, (byte) 1, (byte) 9, JceStruct.ZERO_TAG, (byte) 14, (byte) 2, (byte) 0, (byte) 6, (byte) 10, JceStruct.SIMPLE_LIST, (byte) 15, (byte) 3, (byte) 5, (byte) 8}, new byte[]{(byte) 2, (byte) 1, (byte) 14, (byte) 7, (byte) 4, (byte) 10, (byte) 8, JceStruct.SIMPLE_LIST, (byte) 15, JceStruct.ZERO_TAG, (byte) 9, (byte) 0, (byte) 3, (byte) 5, (byte) 6, JceStruct.STRUCT_END}};
        int i2 = iVar3.fuQ;
        int i3 = iVar.fuQ;
        while (i < 8) {
            byte b = (byte) ((((iVar3.fuP[iVar3.fuQ + 1] << 3) + (iVar3.fuP[iVar3.fuQ + 2] << 2)) + (iVar3.fuP[iVar3.fuQ + 3] << 1)) + iVar3.fuP[iVar3.fuQ + 4]);
            b(iVar, new i(r1[i][(byte) ((iVar3.fuP[iVar3.fuQ + 0] << 1) + iVar3.fuP[iVar3.fuQ + 5])][b]), 4);
            i = (byte) (i + 1);
            iVar3.fuQ += 6;
            iVar.fuQ += 4;
        }
        iVar3.fuQ = i2;
        iVar.fuQ = i3;
        a(iVar, iVar, bArr, 32, iVar4);
    }

    private static void a(i iVar, i iVar2, i[] iVarArr, int i, i iVar3, i iVar4, i iVar5, i iVar6, i iVar7, i iVar8) {
        int i2;
        byte[] bArr = new byte[]{(byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28, (byte) 20, JceStruct.ZERO_TAG, (byte) 4, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 64, (byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, (byte) 16, (byte) 8, (byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, JceStruct.STRUCT_END, (byte) 3, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, JceStruct.SIMPLE_LIST, (byte) 5, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7};
        byte[] bArr2 = new byte[]{(byte) 40, (byte) 8, (byte) 48, (byte) 16, (byte) 56, (byte) 24, (byte) 64, (byte) 32, (byte) 39, (byte) 7, (byte) 47, (byte) 15, (byte) 55, (byte) 23, (byte) 63, (byte) 31, (byte) 38, (byte) 6, (byte) 46, (byte) 14, (byte) 54, (byte) 22, (byte) 62, (byte) 30, (byte) 37, (byte) 5, (byte) 45, JceStruct.SIMPLE_LIST, (byte) 53, (byte) 21, (byte) 61, (byte) 29, (byte) 36, (byte) 4, (byte) 44, JceStruct.ZERO_TAG, (byte) 52, (byte) 20, (byte) 60, (byte) 28, (byte) 35, (byte) 3, (byte) 43, JceStruct.STRUCT_END, (byte) 51, (byte) 19, (byte) 59, (byte) 27, (byte) 34, (byte) 2, (byte) 42, (byte) 10, (byte) 50, (byte) 18, (byte) 58, (byte) 26, (byte) 33, (byte) 1, (byte) 41, (byte) 9, (byte) 49, (byte) 17, (byte) 57, (byte) 25};
        b(iVar3, iVar2, 64);
        a(iVar3, iVar3, bArr, 64, iVar8);
        if (i == 0) {
            for (i2 = 0; i2 < 16; i2++) {
                d(iVar5, iVar7, 32);
                a(iVar7, iVarArr[i2], iVar4, iVar8);
                a(iVar7, iVar6, 32);
                d(iVar6, iVar5, 32);
            }
        } else {
            for (i2 = 15; i2 >= 0; i2--) {
                d(iVar5, iVar6, 32);
                a(iVar6, iVarArr[i2], iVar4, iVar8);
                a(iVar6, iVar7, 32);
                d(iVar7, iVar5, 32);
            }
        }
        a(iVar3, iVar3, bArr2, 64, iVar8);
        a(iVar, 8);
        for (i2 = 0; i2 < 64; i2++) {
            bArr2 = iVar.fuP;
            int i3 = iVar.fuQ + (i2 >> 3);
            bArr2[i3] = (byte) (bArr2[i3] | (iVar3.fuP[iVar3.fuQ + i2] << (i2 & 7)));
        }
    }

    public static char a(byte[] bArr, byte[] bArr2, long j, int i, byte[] bArr3, int i2) {
        i iVar = new i(bArr);
        i iVar2 = new i(bArr2);
        i[] iVarArr = new i[16];
        for (int i3 = 0; i3 < 16; i3++) {
            iVarArr[i3] = new i(new byte[48]);
        }
        i iVar3 = new i(new byte[256]);
        i iVar4 = new i(new byte[24]);
        i iVar5 = new i(new byte[64]);
        i iVar6 = new i();
        i iVar7 = new i();
        i iVar8 = new i();
        i iVar9 = new i();
        i iVar10 = new i(new byte[64]);
        i iVar11 = new i(new byte[48]);
        i iVar12 = new i(new byte[32]);
        i iVar13 = new i(new byte[9]);
        i iVar14 = new i(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j2 = (7 + j) & -8;
            if (j2 != 0) {
                iVar6.fuQ = 0;
                iVar6.fuP = iVar5.fuP;
                iVar7.fuQ = 28;
                iVar7.fuP = iVar5.fuP;
                iVar8.fuQ = 0;
                iVar8.fuP = iVar10.fuP;
                iVar9.fuQ = 32;
                iVar9.fuP = iVar10.fuP;
                a(iVar4, 24);
                iVar5 = new i(bArr3);
                if (i > 24) {
                    i = 24;
                }
                d(iVar4, iVar5, i);
                byte[] bArr4 = new byte[56];
                bArr4 = new byte[]{(byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, JceStruct.STRUCT_END, (byte) 3, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, JceStruct.SIMPLE_LIST, (byte) 5, (byte) 28, (byte) 20, JceStruct.ZERO_TAG, (byte) 4};
                byte[] bArr5 = new byte[48];
                bArr5 = new byte[]{(byte) 14, (byte) 17, JceStruct.STRUCT_END, (byte) 24, (byte) 1, (byte) 5, (byte) 3, (byte) 28, (byte) 15, (byte) 6, (byte) 21, (byte) 10, (byte) 23, (byte) 19, JceStruct.ZERO_TAG, (byte) 4, (byte) 26, (byte) 8, (byte) 16, (byte) 7, (byte) 27, (byte) 20, JceStruct.SIMPLE_LIST, (byte) 2, (byte) 41, (byte) 52, (byte) 31, (byte) 37, (byte) 47, (byte) 55, (byte) 30, (byte) 40, (byte) 51, (byte) 45, (byte) 33, (byte) 48, (byte) 44, (byte) 49, (byte) 39, (byte) 56, (byte) 34, (byte) 53, (byte) 46, (byte) 42, (byte) 50, (byte) 36, (byte) 29, (byte) 32};
                byte[] bArr6 = new byte[16];
                bArr6 = new byte[]{(byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1};
                b(iVar5, iVar4, 64);
                a(iVar5, iVar5, bArr4, 56, iVar3);
                for (int i4 = 0; i4 < 16; i4++) {
                    c(iVar6, iVar3, bArr6[i4]);
                    c(iVar7, iVar3, bArr6[i4]);
                    a(iVarArr[i4], iVar5, bArr5, 48, iVar3);
                }
                int i5 = iVar2.fuQ;
                int i6 = iVar.fuQ;
                long j3;
                if (i2 == 0) {
                    a(iVar, iVar13, iVarArr, i2, iVar10, iVar11, iVar12, iVar8, iVar9, iVar3);
                    d(iVar14, iVar, 8);
                    iVar.fuQ += 8;
                    j3 = 0;
                    long j4 = j2 >> 3;
                    while (j3 < j4) {
                        a(iVar14, iVar14, iVar2);
                        a(iVar, iVar14, iVarArr, i2, iVar10, iVar11, iVar12, iVar8, iVar9, iVar3);
                        d(iVar14, iVar, 8);
                        j3++;
                        iVar.fuQ += 8;
                        iVar2.fuQ += 8;
                    }
                } else {
                    d(iVar13, iVar2, 8);
                    iVar2.fuQ += 8;
                    long j5 = j2 >> 3;
                    long j6 = 1;
                    while (j6 < j5) {
                        a(iVar14, iVar2, iVarArr, i2, iVar10, iVar11, iVar12, iVar8, iVar9, iVar3);
                        a(iVar, iVar14, iVar13);
                        d(iVar13, iVar2, 8);
                        j3 = 1 + j6;
                        iVar.fuQ += 8;
                        iVar2.fuQ += 8;
                        j6 = j3;
                    }
                }
                iVar2.fuQ = i5;
                iVar.fuQ = i6;
                return '\u0001';
            }
        }
        return '\u0000';
    }

    private static void d(i iVar, i iVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            iVar.fuP[iVar.fuQ + i2] = iVar2.fuP[iVar2.fuQ + i2];
        }
    }

    private static void a(i iVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            iVar.fuP[iVar.fuQ + i2] = (byte) 0;
        }
    }
}
