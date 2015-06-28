/**************************************************************************************** 
 Copyright © 2003-2012 ZTEsoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.fccfc.framework.common.utils;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.fccfc.framework.common.ErrorCodeDef;

/**
 * <Description> <br>
 * 
 * @author 王伟 <br>
 * @version 1.0 <br>
 * @CreateDate 2014年10月23日 <br>
 * @see com.fccfc.framework.core.utils <br>
 */
public final class CommonUtil {

    private static final Random random = new Random();

    /**
     * Description: 字符串是为NULL或为空<br>
     * 
     * @author 王伟 <br>
     * @param str
     * @return <br>
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * Description:字符串不为NULL也不为空 <br>
     * 
     * @author 王伟 <br>
     * @param str
     * @return <br>
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断数组是否为NULL或为空
     * 
     * @param t
     * @return
     */
    public static <T> boolean isEmpty(T[] t) {
        return t == null || t.length == 0;
    }

    /**
     * 判断数组不为NULL也不为空
     * 
     * @param t
     * @return
     */
    public static <T> boolean isNotEmpty(T[] t) {
        return !isEmpty(t);
    }

    /**
     * Description: 集合是否为NULL或为空<br>
     * 
     * @author 王伟 <br>
     * @param col <br>
     */
    public static boolean isEmpty(Collection<?> col) {
        return col == null || col.isEmpty();
    }

    /**
     * Description:集合不为NULL也不为空 <br>
     * 
     * @author 王伟 <br>
     * @param col
     * @return <br>
     */
    public static boolean isNotEmpty(Collection<?> col) {
        return !isEmpty(col);
    }

    /**
     * Description: map是否为NULL或为空<br>
     * 
     * @author 王伟 <br>
     * @param col <br>
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Description:map不为NULL也不为空 <br>
     * 
     * @author 王伟 <br>
     * @param col
     * @return <br>
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * Description: <br>
     * 
     * @author 王伟 <br>
     * @param str
     * @return <br>
     */
    public static String lowerCaseFirstChar(String str) {
        if (isNotEmpty(str)) {
            char firstChar = str.charAt(0);
            if (Character.isUpperCase(firstChar)) {
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(0, Character.toLowerCase(firstChar));
                str = sb.toString();
            }
        }
        return str;
    }

    /**
     * 消息格式化
     * 
     * @param message message
     * @param params params
     * @return String
     */
    public static String messageFormat(String message, Object... params) {
        return isNotEmpty(params) ? MessageFormat.format(message, params) : message;
    }

    /**
     * 判断是否是空对象
     * 
     * @param obj obj
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return null == obj;
    }

    /**
     * 获取事务ID
     * 
     * @return 事务ID
     */
    public static String getTransactionID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Description: 获取指定位数的随机数<br>
     * 
     * @author 王伟 <br>
     * @param size
     * @return <br>
     */
    public static String getRandomNumber(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((char) ('0' + random.nextInt(10)));
        }
        return sb.toString();
    }

    public static String getRandomChar(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            switch (random.nextInt(10) % 3) {
                case 0:
                    sb.append((char) ('0' + random.nextInt(10)));
                    break;
                case 1:
                    sb.append((char) ('a' + random.nextInt(26)));
                    break;
                case 2:
                    sb.append((char) ('A' + random.nextInt(26)));
                    break;
            }
        }
        return sb.toString();
    }

    public static String getString(Object obj) {
        String result = null;
        if (obj != null) {
            result = obj instanceof String ? (String) obj : obj.toString();
        }
        return result;
    }

    public final static String md5(String s) throws UtilException {
        char hexDigits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            throw new UtilException(ErrorCodeDef.SYSTEM_ERROR_10001);
        }
    }
}