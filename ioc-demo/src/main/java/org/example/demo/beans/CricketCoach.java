package org.example.demo.beans;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
	
	public CricketCoach(FortuneService fortuneService) {
	
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practice leg spin today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
