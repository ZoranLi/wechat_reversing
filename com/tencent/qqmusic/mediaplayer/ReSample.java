package com.tencent.qqmusic.mediaplayer;

class ReSample {
    ReSample() {
    }

    static void reSample(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2) {
        if (bufferInfo != null && bufferInfo.shortBuffer != null && bufferInfo.bufferSize > 0 && bufferInfo2 != null) {
            if (j == j2 || j2 <= 0 || j <= 0) {
                bufferInfo.copy(bufferInfo2);
            } else {
                interpolate(bufferInfo, bufferInfo2, j, j2);
            }
        }
    }

    private static void interpolate(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2) {
        int round = Math.round(((1.0f * ((float) bufferInfo.bufferSize)) / ((float) j)) * ((float) j2));
        float f = ((float) round) / ((float) bufferInfo.bufferSize);
        bufferInfo2.setShortBufferCapacity(round);
        bufferInfo2.bufferSize = round;
        for (int i = 0; i < round; i++) {
            float f2 = ((float) i) / f;
            int i2 = (int) f2;
            int i3 = i2 + 1;
            if (i3 >= bufferInfo.bufferSize) {
                i3 = bufferInfo.bufferSize - 1;
            }
            bufferInfo2.shortBuffer[i] = (short) ((int) ((((float) (bufferInfo.shortBuffer[i3] - bufferInfo.shortBuffer[i2])) * (f2 - ((float) i2))) + ((float) bufferInfo.shortBuffer[i2])));
        }
    }
}
