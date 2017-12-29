package com.ai.ysm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ai.ysm.exception.RRException;
import com.ai.ysm.sys.entity.SysUserEntity;


/**
 * Shiro工具类
 * 
 * @author asiainfo
 *  
 * @date 2016年11月12日 上午9:49:19
 */
public class ShiroUtilsSHA {
	/**  加密算法 */
	public final static String hashAlgorithmName = "SHA-256";
	/**  循环次数 */
	public final static int hashIterations = 16;

	public static String sha256(String password, String salt) {
		return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
	}
}
