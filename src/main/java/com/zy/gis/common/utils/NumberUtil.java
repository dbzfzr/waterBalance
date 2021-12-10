package com.zy.gis.common.utils;

/**
@author Wangchong
@date 2021/12/8 17:30
@description TODO
@param
@return
*/
public class NumberUtil {
    /**
    @author Wangchong
    @date 2021/12/8 17:30
    @description TODO 字节数组转16进制字符串
    @param b 字节数组
    @return  16进制字符串
    */
    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;

            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }

    public static String HexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;

        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }

        return bString;
    }

    // 2进制字符串转Float数，包括正数和负数
    public static float BinaryStringToFloat(final String binaryString) {
        // float是32位，将这个binaryString左边补0补足32位，如果是Double补足64位。
        /* final String stringValue = LeftPad(binaryString, '0', 32); */
        // 首位是符号部分，占1位。
        // 如果符号位是0则代表正数，1代表负数
        final int sign = binaryString.charAt(0) == '0' ? 1 : -1;
        // 第2到9位是指数部分，float占8位，double占11位。
        final String exponentStr = binaryString.substring(1, 9);
        // 将这个二进制字符串转成整数，由于指数部分加了偏移量（float偏移量是127，double是1023）
        // 所以实际值要减去127
        final int exponent = Integer.parseInt(exponentStr, 2) - 127;
        // 最后的23位是尾数部分，由于规格化数，小数点左边隐含一个1，现在加上
        final String mantissaStr = "1".concat(binaryString.substring(9, 32));
        // 这里用double，尽量保持精度，最好用BigDecimal，这里只是方便计算所以用double
        double mantissa = 0.0;

        for (int i = 0; i < mantissaStr.length(); i++) {
            final int intValue = Character.getNumericValue(mantissaStr.charAt(i));
            // 计算小数部分，具体请查阅二进制小数转10进制数相关资料
            mantissa += (intValue * Math.pow(2, -i));
        }
        // 根据IEEE 754 标准计算：符号位 * 2的指数次方 * 尾数部分
        return (float) (sign * Math.pow(2, exponent) * mantissa);
    }

}
