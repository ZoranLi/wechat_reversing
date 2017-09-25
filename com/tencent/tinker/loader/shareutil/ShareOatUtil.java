package com.tencent.tinker.loader.shareutil;

public final class ShareOatUtil {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xiw = new int[InstructionSet.values().length];

        static {
            try {
                xiw[InstructionSet.kArm.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xiw[InstructionSet.kThumb2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xiw[InstructionSet.kArm64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                xiw[InstructionSet.kX86.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                xiw[InstructionSet.kX86_64.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                xiw[InstructionSet.kMips.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                xiw[InstructionSet.kMips64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                xiw[InstructionSet.kNone.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }
}
