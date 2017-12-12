package net.skhu.dto;

import lombok.Data;

@Data
public class BallCount {

	int ball;
	int strike;
	boolean out;
	
	@Override
	public String toString() {
		if(this.out) return "OUT";
		return String.format("%dS %dB", this.strike, this.ball);
	}
}
