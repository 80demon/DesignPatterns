/**    
 * @{#} VoteManager.java Create on 2013-5-10 下午3:02:14    
 *    
 * Copyright (c) 2013 by mark_zhu. 
 * @author <a href="mailto:mark@morelap.com">mark_zhu</a>   
 * @version 1.0    
 */    
package com.behavioural.state1;

import java.util.HashMap;
import java.util.Map;

/**    
 * @{#} VoteManager.java Create on 2013-5-10 下午3:02:14    
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
public class VoteManager {

	private IVoteState state;
	//记录用户投票的结果，Map<String,String>对应Map<用户名称，投票的选项>
	private Map<String,String> mapVote  = new HashMap<String,String>();

	//记录用户投票次数
	private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();

	 /**
     * 获取用户投票结果的Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    /**
     * 投票
     * @param uuid    投票人
     * @param voteItem    投票的选项
     */
    public void vote(String uuid,String voteItem){
        //1.为该用户增加投票次数
        //从记录中取出该用户已有的投票次数
        Integer oldVoteCount = mapVoteCount.get(uuid);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(uuid, oldVoteCount);
        //2.判断该用户的投票类型，就相当于判断对应的状态
        //到底是正常投票、重复投票、恶意投票还是上黑名单的状态
        if(oldVoteCount == 1){//正常投票
            state = new NormalVoteState();
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){//重复投票
            state = new RepeatVoteState();
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){//恶意投票
            state = new SpiteVoteState();
        }
        else if(oldVoteCount > 8){//拉入黑名单
            state = new BlackVoteState();
        }
        //然后转调状态对象来进行相应的操作
        state.vote(uuid, voteItem, this);//调用具体的实现方法
    }
}
