package org.example.managers;

import java.util.List;

public class Calculator {

    public long countingMaxStringLength(List<String> strings) {
        int maxLength = 0;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
            }
        }
        return maxLength;
    }

    public long countingMinStringLength(List<String> strings) {
        int maxLength = 2;
        for (String string : strings) {
            if (string.length() < maxLength) {
                maxLength = string.length();
            }
        }
        return maxLength;
    }

    public long countingMinIntValue(List<Long> values) {
        long minValue = Long.MAX_VALUE;
        for (Long value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public long countingMaxIntValue(List<Long> values) {
        long maxValue = Long.MIN_VALUE;
        for (Long value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public long countingMidIntValue(List<Long> values) {
        long sumValue = 0;
        for (Long value : values) {
            sumValue = sumValue + value;
        }
        return sumValue / values.size();
    }

    public long countingSumIntValue(List<Long> values) {
        long sumValue = 0;
        for (Long value : values) {
            sumValue = sumValue + value;
        }
        return sumValue;
    }

    public float countingMinFloatValue(List<Float> values) {
        float minValue = Long.MAX_VALUE;
        for (Float value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public float countingMaxFloatValue(List<Float> values) {
        float maxValue = Long.MIN_VALUE;
        for (Float value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public float countingMidFloatValue(List<Float> values) {
        float sumValue = 0;
        for (Float value : values) {
            sumValue = sumValue + value;
        }
        return sumValue / values.size();
    }

    public float countingSumFloatValue(List<Float> values) {
        float sumValue = 0;
        for (Float value : values) {
            sumValue = sumValue + value;
        }
        return sumValue;
    }
}
