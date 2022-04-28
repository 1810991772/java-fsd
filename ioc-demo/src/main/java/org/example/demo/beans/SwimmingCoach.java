package org.example.demo.beans;

public class SwimmingCoach implements Coach{
	
	private FortuneService fortuneService;
	
	

	public SwimmingCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "run 4k todaty";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
