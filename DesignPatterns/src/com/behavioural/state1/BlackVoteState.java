/**    
 * @{#} NormalVoteState.java Create on 2013-5-10 下午3:04:00    
 *    
 * Copyright (c) 2013 by mark_zhu. 
 * @author <a href="mailto:mark@morelap.com">mark_zhu</a>   
 * @version 1.0    
 */    
package com.behavioural.state1;

/**    
 * @{#} NormalVoteState.java Create on 2013-5-10 下午3:04:00    
 *    
 * class desc:   正常投票
 *
 * <p>Copyright: Copyright(c) 2013 </p> 
 * <p>Company: morelap</p>
 * @Version 1.0
 * @Author <a href="mailto:mark@morelap.com">mark_zhu</a>   
 *  
 * 
 */
public class BlackVoteState implements IVoteState{

	@Override
	public void vote(String uuid, String voteItem, VoteManager manager) {
		 //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
	}



}
