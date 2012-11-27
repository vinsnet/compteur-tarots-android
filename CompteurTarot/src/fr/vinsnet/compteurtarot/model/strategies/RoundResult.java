/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.compteurtarot.model.strategies;

import java.util.Map;

public class RoundResult {

	private boolean isSuccess;

	private float score;

	private String totalComment;

	private float total;
	
	private Map<Long, Float> detailedScores;

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public boolean isSuccess(){
		return isSuccess;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotalComment(String totalComment) {
		this.totalComment = totalComment;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getTotalComment() {
		return this.totalComment;
	}

	public Map<Long, Float> getDetailedScores() {
		return detailedScores;
	}

	public void setDetailedScores(Map<Long, Float> detailedScores) {
		this.detailedScores = detailedScores;
	}
	
	


	
	
}
