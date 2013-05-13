/**    
 * @{#} OracleDB.java Create on 2013-5-7 下午2:13:23    
 *    
 * Copyright (c) 2013 by mark_zhu. 
 * @author <a href="mailto:mark@morelap.com">mark_zhu</a>   
 * @version 1.0    
 */    
package com.creational.simplefactory;

/**    
 * @{#} OracleDB.java Create on 2013-5-7 下午2:13:23    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p> 
 * <p>Company: morelap</p>
 * @Version 1.0
 * @Author <a href="mailto:mark@morelap.com">mark_zhu</a>   
 *  
 * 
 */
public class OracleDB implements IDB {

	@Override
	public void getDB() {
		System.out.println("得到Oracle数据库对象");
	}

}
